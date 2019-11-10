package entities;

import java.time.Year;

public class Persona {
	

	String nome, cognome, datanascita, comuneRes, tel, mail, ruolo;
	int id;
	
	private static  String charNotLetters = "0123456789,.;:-_|!£$%&/()=?^*+€°§";
	private static final String charNotNumbers = "abcdefghijklmnopqrstuvwxyz,.;:_<>ùàòè+ç°§*é@#ù][{}ì'|!£$%&/()=?^";
	
	// COSTRUTTORI ---------------------------------------------------------------------------------------------------------------------------

	public Persona(int id, String nome, String cognome, String datanascita, String comuneRes, String tel, String mail, String ruolo) {
		this.id = id;
		this.ruolo = ruolo;
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = datanascita;
		this.comuneRes = comuneRes;
		this.tel = tel;
		this.mail = mail;
	}
	
	// GET-SET ---------------------------------------------------------------------------------------------------------------------------
	
	
	
	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuolo() {
		return ruolo;
	}
	
	public void setRuolo(String ruolo) {
		if(isNomeCognomeValido(ruolo))
			this.ruolo = ruolo;
	}

	public void setNome(String nome) {
		if(isNomeCognomeValido(nome))
			this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		if(isNomeCognomeValido(cognome))
			this.cognome = cognome;
	}
	
	public String getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(String datanascita) {
		if(isDataValida(datanascita))
			this.datanascita = datanascita;
	}

	public String getComuneRes() {
		return comuneRes;
	}

	public void setComuneRes(String comuneRes) {
		if(isComuneValido(comuneRes))
			this.comuneRes = comuneRes;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		if(isTelValido(tel))
			this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		if(isMailValida(mail))
			this.mail = mail;
	}
	
	// VALIDAZIONE ---------------------------------------------------------------------------------------------------------------------------
	
	public static boolean isValido(String[] parti) {			// TODO DA SISTEMARE TUTTE LE PARTI DI PARTI
		return  isNomeCognomeValido(parti[2]) 	&&
				isNomeCognomeValido(parti[3]) 	&&
				isDataValida(parti[4])			&&
				isComuneValido(parti[2])		&&
				isTelValido(parti[1])			&&
				isMailValida(parti[7])			;			
	}
	
	public static boolean isNomeCognomeValido (String n) {
		boolean ris = true;
		if(!n.isEmpty()) {
			String[] numeri = charNotLetters.split("");
			for( String s : numeri)
				if(n.indexOf(s) >=0)
					return false;
		}
		else 
			ris = false;
		return ris;			
	}
	
	public static boolean isBisestile (int anno) {
		if(anno%4 == 0) {
			if(anno%100 == 0) 
				return(anno%400 == 0) ? true : false;
			return true;
		} 
		else 
			return false;
	}
	
	public static boolean isAnnoGiusto (int anno) {
		if(anno < Year.now().getValue() && anno > 1880)
			return true;
		else 
			return false;
	}
	
	public static boolean isMeseGiusto (int mese) {
		if(mese < 1 || mese > 12)
			return false;
		else 
			return true;
	}
	
	public static boolean isGiornoGiusto (int giorno, int mese, int anno) {
		switch (mese) {
			case 4:
			case 6:
			case 9:
			case 11:
				if(giorno>0 && giorno<31)
					return true;
			break;
			case 2:
				if(isBisestile(anno) && (giorno>0 && giorno<30))
					return true;
				if(!isBisestile(anno) && (giorno>0 && giorno<29))
					return true;
			break;
			default:
				if(giorno>0 && giorno<32)
					return true;
			break;
		}
		return false;
	}
	
	public static boolean isDataValida (String data) {
		// YYYY-MM-DD
		data = data.toLowerCase();
		String[] lettere = charNotNumbers.split("");
		for(int i = 0; i < lettere.length; i++)
			if(data.indexOf(lettere[i]) >=0)
				return false;
		String[] dataSplit = data.split("-");
		int anno = Integer.parseInt(dataSplit[0]);
		int mese = Integer.parseInt(dataSplit[1]);
		int giorno = Integer.parseInt(dataSplit[2]);
		return 	isAnnoGiusto(anno) &&
				isMeseGiusto(mese) &&
				isGiornoGiusto(giorno,mese,anno);
	}	
	
	public static boolean isComuneValido (String comune) {
		boolean ris = true;
		if(!comune.isEmpty()) {
			String[] numeri = charNotLetters.split("");
			for( String s : numeri)
				if(comune.indexOf(s) >=0)
					return false;
		}
		else 
			ris = false;
		return ris;			
	}
	
	public static boolean isTelValido (String tel) {
		boolean ris = true;
		if(!tel.isEmpty()) {
			String[] numeri = charNotNumbers.split("");
			for( String s : numeri)
				if(tel.indexOf(s) >=0)
					return false;
		}
		else 
			ris = false;
		return ris;
	}
	
	public static boolean isMailValida (String mail) {
		boolean ris = true;
		if(!mail.isEmpty()) {
			String[] numeri = {".","@"};
			for( String s : numeri)
				if(mail.indexOf(s) <=0)
					return false;
		}
		else 
			ris = false;
		return ris;
	}

	// METODI ---------------------------------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "id: " + id + ", \n" + (nome != null ? "nome: " + nome + ", \n" : "")
				+ (cognome != null ? "cognome: " + cognome + ", \n" : "")
				+ (datanascita != null ? "datanascita: " + datanascita + ", \n" : "")
				+ (comuneRes != null ? "comuneRes: " + comuneRes + ", \n" : "")
				+ (tel != null ? "tel: " + tel + ", \n" : "") + (mail != null ? "mail: " + mail + "," : "");
//				+ (ruolo != null ? "ruolo: " + ruolo : "");
	}
	

	
}