package entities;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vigile extends Persona {
	
	private String grado;
	private int patente, annoDecreto;
	private List<String> qualifiche = new ArrayList<String>();
	
	static String[] qualificheVal = {"TPSS","SAF","NBCR","ATP"};
	static String[] gradiVal = {"VV","CSV"};
	
	// COSTRUTTORE ---------------------------------------------------------------------------------------------------------------------------
	
	public Vigile(String nome, String cognome, String datanascita, String comuneRes, String tel, String mail,
			String grado, int patente, int annoDecreto, String qualifiche) {
		super(nome, cognome, datanascita, comuneRes, tel, mail);
		this.grado = grado;
		this.patente = patente;
		this.annoDecreto = annoDecreto;
		setQualifiche(qualifiche);
	}
	
	// GET - SET ---------------------------------------------------------------------------------------------------------------------------
	
	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		if(isGradoValido(grado))
			this.grado = grado;
	}

	public int getPatente() {
		return patente;
	}

	public void setPatente(int patente) {
		if(isPatenteValida(patente))
			this.patente = patente;
	}

	public int getAnnoDecreto() {
		return annoDecreto;
	}

	public void setAnnoDecreto(int annoDecreto) {
		if(isAnnoDecValido(annoDecreto))
			this.annoDecreto = annoDecreto;
	}

	public List<String> getQualifiche() {
		return qualifiche;
	}

	public void setQualifiche(String qualifiche) {
		List<String> qual = Arrays.asList(qualifiche);
		for(String s : qual)
			for(String z: qualificheVal)
				if(s.equalsIgnoreCase(z))
					this.qualifiche.add(s);
	}
	
	// VALIDAZIONE ---------------------------------------------------------------------------------------------------------------------------
	
	public static boolean isValido(String[] parti) {	//TODO DA SISTEMARE TUTTE LE PARTI DI PARTI
		return  Persona.isValido(parti) 	&&
				isGradoValido(parti[12]) 	&&
				isPatenteValida(Integer.parseInt(parti[5]))	&&
				isAnnoDecValido(Integer.parseInt(parti[2]))	;
	}

	private static boolean isAnnoDecValido(int annoD) {
		return Persona.isAnnoGiusto(annoD);
	}

	private static boolean isPatenteValida(int patente) {
		return patente >= 0 && patente <= 3;
	}

	private static boolean isGradoValido(String grado) {
		for(String s : gradiVal)
			if(s.equalsIgnoreCase(grado))
				return true;
		return false;
	}
	
	// METODI ---------------------------------------------------------------------------------------------------------------------------
	
	public int anniServizio () {
		return Year.now().getValue() - getAnnoDecreto();
	}
	
	public String stampaQualifiche() {
		String risposta = "";
		for(String s : qualifiche)
			risposta = s + ", ";
		return risposta;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + (grado != null ? "Grado: " + grado + ", \n" : "") + "Patente: " + patente + "° grado, \nAnnoDecreto: "
				+ annoDecreto + ", \n" + (qualifiche != null ? "Qualifiche: " + stampaQualifiche() : "");
	}
	
	
	
}
