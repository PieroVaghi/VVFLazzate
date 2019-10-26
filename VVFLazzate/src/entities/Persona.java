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
	
	// GET-SET
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(String datanascita) {
		this.datanascita = datanascita;
	}

	public String getComuneRes() {
		return comuneRes;
	}

	public void setComuneRes(String comuneRes) {
		this.comuneRes = comuneRes;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}