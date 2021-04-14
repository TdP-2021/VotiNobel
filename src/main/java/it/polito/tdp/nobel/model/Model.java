package it.polito.tdp.nobel.model;

import java.util.Set;

public class Model {

	
	public Set<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
		System.out.println("TODO!");
		return null;	
	}

	
	public double calcolaMedia(Set<Esame> esami) {
		
		int crediti = 0;
		int somma = 0;
		
		for(Esame e : esami){
			crediti += e.getCrediti();
			somma += (e.getVoto() * e.getCrediti());
		}
		
		return somma/crediti;
	}
	
	public int sommaCrediti(Set<Esame> esami) {
		int somma = 0;
		
		for(Esame e : esami)
			somma += e.getCrediti();
		
		return somma;
	}

}
