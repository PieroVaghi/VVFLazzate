package entities;

import java.util.List;

public class Vigile extends Persona {
	
	String grado;
	int patente, annoDecreto;
	List<String> qualifiche;
	
	public Vigile(String nome, String cognome, String datanascita, String comuneRes, String tel, String mail,
			String grado, int patente, int annoDecreto, List<String> qualifiche) {
		super(nome, cognome, datanascita, comuneRes, tel, mail);
		this.grado = grado;
		this.patente = patente;
		this.annoDecreto = annoDecreto;
		this.qualifiche = qualifiche;
	}
	
}
