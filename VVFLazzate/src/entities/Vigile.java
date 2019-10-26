package entities;

import java.util.List;

public class Vigile extends Persona {
	
	String grado;
	int patente, annoDecreto;
	List<String> qualifiche;
	
	// COSTRUTTORE
	
	public Vigile(String nome, String cognome, String datanascita, String comuneRes, String tel, String mail,
			String grado, int patente, int annoDecreto, List<String> qualifiche) {
		super(nome, cognome, datanascita, comuneRes, tel, mail);
		this.grado = grado;
		this.patente = patente;
		this.annoDecreto = annoDecreto;
		this.qualifiche = qualifiche;
	}
	
	// GET - SET
	
	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public int getPatente() {
		return patente;
	}

	public void setPatente(int patente) {
		this.patente = patente;
	}

	public int getAnnoDecreto() {
		return annoDecreto;
	}

	public void setAnnoDecreto(int annoDecreto) {
		this.annoDecreto = annoDecreto;
	}

	public List<String> getQualifiche() {
		return qualifiche;
	}

	public void setQualifiche(List<String> qualifiche) {
		this.qualifiche = qualifiche;
	}
	
	//
}
