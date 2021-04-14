package it.polito.tdp.nobel.db;

import it.polito.tdp.nobel.model.Esame;

public class PopulateDB {

	public static void main(String[] args) {
		
		EsameDAO vd = new EsameDAO();
		
		// Cancello dal DB tutti i voti inseriti
		vd.cancellaTuttiEsami();
		
		// Aggiungo al DB la seguente lista di esami:
		vd.inserisciEsame(new Esame("16ACFPL", "Analisi matematica I", 10, 27));
		vd.inserisciEsame(new Esame("16AHMPL", "Chimica", 8, 26));
		vd.inserisciEsame(new Esame("12BHDPL", "Informatica", 8, 25));
		vd.inserisciEsame(new Esame("07LKIPL", "Lingua inglese I livello", 3, 24));
		vd.inserisciEsame(new Esame("01RKCPL", "Algebra lineare e geometria", 10, 23));
		vd.inserisciEsame(new Esame("01PNNPL", "Crediti liberi del 1 anno", 6, 22));
		vd.inserisciEsame(new Esame("15AXOPL", "Fisica I", 10, 21));

		vd.inserisciEsame(new Esame("23ACIPL", "Analisi matematica II", 8, 23));
		vd.inserisciEsame(new Esame("14AFQPL", "Basi di dati",  8, 27));
		vd.inserisciEsame(new Esame("20AXPPL", "Fisica II", 6, 28));
		vd.inserisciEsame(new Esame("12CKRPL", "Statistica",  10, 30));
		vd.inserisciEsame(new Esame("06ARHPL", "Economia e organizzazione aziendale", 8, 22));
		vd.inserisciEsame(new Esame("07CESPL", "Ricerca operativa", 8, 18));
		vd.inserisciEsame(new Esame("07CHWPL", "Sistemi di produzione", 8, 30));
		vd.inserisciEsame(new Esame("04CIIPL", "Sistemi elettrici industriali", 8, 18));

		vd.inserisciEsame(new Esame("01QNAPL", "Elementi di diritto privato", 8, 19));
		vd.inserisciEsame(new Esame("09CBIPL", "Programmazione a oggetti", 8, 29));
		vd.inserisciEsame(new Esame("02CBRPL", "Programmazione e gestione della produzione", 10, 30));
		vd.inserisciEsame(new Esame("01NBDPL", "Sistemi telematici", 8, 27));
		vd.inserisciEsame(new Esame("01QYVPL", "Crediti liberi del 3° anno", 6, 22));
		vd.inserisciEsame(new Esame("01NBEPL", "Progettazione di servizi web e reti di calcolatori", 8, 19));
		
		// Ottengo la lista di tutti i voti
		System.out.println("Voti inseriti");
		System.out.println(vd.getTuttiEsami());

	}
	
}
