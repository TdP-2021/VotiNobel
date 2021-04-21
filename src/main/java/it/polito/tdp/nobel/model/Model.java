package it.polito.tdp.nobel.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.nobel.db.EsameDAO;

public class Model {
	private List<Esame> partenza;
	private Set<Esame> soluzioneMigliore;
	private double mediaSoluzioneMigliore;
	private int casiTestati = 0;
	
	public Model() {
		EsameDAO dao = new EsameDAO();
		this.partenza = dao.getTuttiEsami();
	}
	
	public Set<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
		Set<Esame> parziale = new LinkedHashSet<Esame>();
		soluzioneMigliore = new HashSet<Esame>();
		mediaSoluzioneMigliore = 0;
		casiTestati = 0;
		cerca1(parziale, 0, numeroCrediti);
		//cerca2(parziale, 0, numeroCrediti);
		return soluzioneMigliore;
	}

	/*
	 * APPROCCIO 2
	 * Genero i sottoinsiemi di PARTENZA 1 caso per volta
	 * 		- decido, esame per esame, se debba/non debba far parte della soluzione. 
	 */
	private void cerca2(Set<Esame> parziale, int L, int m) {
		casiTestati ++;
		
		//casi terminali
		int crediti = sommaCrediti(parziale);
		if(crediti > m) {
			return;
		}
				
		if(crediti == m) {
			double media = calcolaMedia(parziale);
			if(media > mediaSoluzioneMigliore) {
				soluzioneMigliore = new HashSet<>(parziale);
				mediaSoluzioneMigliore = media;
			}
			return; 
		}
				
		//sicuramente, crediti < m
		// L = N -> non ci sono più esami da aggiungere
		if(L == partenza.size()) {
			return;
		}
		//generazione sottoproblemi
		//partenza[L] è da aggiungere oppure no? Provo entrambe le cose
		parziale.add(partenza.get(L));
		cerca2(parziale, L+1, m);
		
		parziale.remove(partenza.get(L));
		cerca2(parziale, L+1,m);
	}

	/* 
	 * APPROCCIO 1
	 * Ad ogni livello (L) della ricorsione, aggiungo un esame
	 * 		- devo decidere quale -> li provo tutti (simile agli anagrammi)
	 * 
	 * OTTIMIZZAZIONE: 
	 * 		- scorro gli esami di partenza "in ordine"
	 * 		- non considero esami che "vengono prima" (nella lista di esami di partenza) di quello che sto attualmente considerando
	 */
	private void cerca1(Set<Esame> parziale, int L, int m) {
		casiTestati ++;
		System.out.println("L = " + L + "\t" + parziale);

		//casi terminali
		int crediti = sommaCrediti(parziale);
		if(crediti > m) {
			return;
		}
		
		if(crediti == m) {
			double media = calcolaMedia(parziale);
			if(media > mediaSoluzioneMigliore) {
				soluzioneMigliore = new HashSet<>(parziale);
				mediaSoluzioneMigliore = media;
			}
			return; 
		}
		
		//sicuramente, crediti < m
		// L = N -> non ci sono più esami da aggiungere
		if(L == partenza.size()) {
			return;
		}
		
		//generare i sotto-problemi
		
		/*for(Esame e : partenza) {
			if(!parziale.contains(e)) {
				parziale.add(e);
				cerca1(parziale, L+1, m);
				parziale.remove(e);
			}
		}*/
		
		
		//N.B.: Non è ancora "perfetto": il controllo i>=L non è sufficiente ad evitare tutti i casi duplicati
		for(int i = 0; i < partenza.size(); i ++) {
	
			if(!parziale.contains(partenza.get(i)) && i >= L) {
				parziale.add(partenza.get(i));
				cerca1(parziale, L+1, m);
				parziale.remove(partenza.get(i));
			}
			
		}
		
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
	
	public int getCasiTestati() {
		return this.casiTestati;
	}

}
