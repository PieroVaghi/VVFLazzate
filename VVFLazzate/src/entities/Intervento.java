package entities;

import java.util.List;

public class Intervento {
	
	private int rapporto, unita;
	private String data, funzionario, tipologia, comune, indirizzo, oraUscita, oraRientro, note;
	private boolean reperibilita;
	private List<Vigile> capopartenza, autista, vigili;
	
	
	public Intervento(int rapporto, String data, String funzionario, String tipologia, String comune, String indirizzo,
			String oraUscita, String oraRientro, boolean reperibilita, int unita, List<Vigile> capopartenza,
			List<Vigile> autista, List<Vigile> vigili, String note) {
		this.rapporto = rapporto;
		this.data = data;
		this.funzionario = funzionario;
		this.tipologia = tipologia;
		this.comune = comune;
		this.indirizzo = indirizzo;
		this.oraUscita = oraUscita;
		this.oraRientro = oraRientro;
		this.reperibilita = reperibilita;
		this.unita = unita;
		this.capopartenza = capopartenza;
		this.autista = autista;
		this.vigili = vigili;
		this.note = note;
	}
	
	
	
	

}
