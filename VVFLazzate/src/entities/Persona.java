package entities;


public class Persona {
	

	String nome, cognome, genere, datanascita, comuneRes, tel, mail;
	
		// COSTRUTTORI

	public Persona(String nome, String cognome, String datanascita, String comuneRes, String tel, String mail) {
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = datanascita;
		this.comuneRes = comuneRes;
		this.tel = tel;
		this.mail = mail;
	}
	
}
