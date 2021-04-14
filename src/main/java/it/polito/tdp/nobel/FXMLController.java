package it.polito.tdp.nobel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.nobel.model.Esame;
import it.polito.tdp.nobel.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;
    
    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaCombinazione(ActionEvent event) {
    	txtResult.clear();
    	try {
    		int numeroCrediti = Integer.parseInt(txtInput.getText());
    			
    		long start = System.currentTimeMillis();
    		Set<Esame> voti = model.calcolaSottoinsiemeEsami(numeroCrediti);
    		long end = System.currentTimeMillis();
    		
    		if(voti == null) {
    			txtResult.appendText("Non ho trovato soluzioni\n");
    			return ;
    		}
    			
    		txtResult.appendText("TEMPO IMPIEGATO: " + (end-start) + " ms\n\n");
    		txtResult.appendText("MEDIA: " + this.model.calcolaMedia(voti) + "\n\n");
    			
    		for(Esame e : voti) {
    			txtResult.appendText(e.toString() + "\n");
    		}

    	} catch (NumberFormatException e) {
    		txtResult.setText("Inserire un numero di crediti > 0");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    		// reset the UI
    		txtInput.clear();
    		txtResult.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'VotiNobel.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'VotiNobel.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'VotiNobel.fxml'.";
    }

	public void setModel(Model model) {
		
		this.model = model;
	}
}
