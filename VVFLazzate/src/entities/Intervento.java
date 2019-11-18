package entities;

import java.util.List;

public class Intervento {
	
	private int rapporto, unita;
	private String data, funzionario, tipologia, comune, indirizzo, oraUscita, oraRientro, note;
	private boolean reperibilita;
	private List<Personale> capopartenza, autista, vigili;
	
	// COSTRUTTORE ---------------------------------------------------------------------------------------------------------------------------------------
	
	public Intervento(int rapporto, String data, String funzionario, String tipologia, String comune, String indirizzo,
			String oraUscita, String oraRientro, boolean reperibilita, int unita, List<Personale> capopartenza,
			List<Personale> autista, List<Personale> vigili, String note) {
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

	// GET SET ---------------------------------------------------------------------------------------------------------------------------------------------
	
	public int getRapporto() {
		return rapporto;
	}
	
	public int getUnita() {
		return unita;
	}
	
	public String getData() {
		return data;
	}
	
	public String getFunzionario() {
		return funzionario;
	}
	
	public String getTipologia() {
		return tipologia;
	}
	
	public String getComune() {
		return comune;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public String getOraUscita() {
		return oraUscita;
	}
	
	public String getOraRientro() {
		return oraRientro;
	}
	
	public String getNote() {
		return note;
	}
	
	public boolean isReperibilita() {
		return reperibilita;
	}
	
	public List<Personale> getCapopartenza() {
		return capopartenza;
	}
	
	public List<Personale> getAutista() {
		return autista;
	}
	
	public List<Personale> getVigili() {
		return vigili;
	}
	
	
	
	// VALIDAZIONE -------------------------------------------------------------------------------------------------------------------------------------------------
	
//	public static boolean isValido(String[] parti) {
//		return 	Persona.isTelValido(parti[0])			&&	// valido il rapporto
//				Persona.isDataValida(parti[1])			&&	// valido la data
//				Persona.isNomeCognomeValido(parti[2])	&& 	// valido funzionario
//				isTipologiaValida(parti[3])				&&
//				Persona.isNomeCognomeValido(parti[4])	&&	// valido comune 
//				Persona.isNomeCognomeValido(parti[5])	&&	// valido indirizzo
//				isOraValida(parti[6])					&&
//				isOraValida(parti[7])					&&
//				isUnit‡Valide(parti[8])					;
//	}
	
	
}
