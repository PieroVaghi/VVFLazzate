package entities;

public class Aspirante extends Persona {
	
	private boolean decretato;

	public Aspirante(String nome, String cognome, String datanascita, String comuneRes, String tel, String mail,
			String decretato) {
		super(nome, cognome, datanascita, comuneRes, tel, mail);
		setDecretato(decretato);
	}

	// COSTRUTTORE ---------------------------------------------------------------------------------------------------------------------------
	
	public boolean isDecretato() {
		return decretato;
	}

	public void setDecretato(String decretato) {
		if(isDecretatoValid(decretato) && decretato.equalsIgnoreCase("si"))
			this.decretato = true;
		else
			this.decretato = false;
	}
	
	// VALIDAZIONE ---------------------------------------------------------------------------------------------------------------------------

	public static boolean isValido(String[] parti) {	//TODO DA SISTEMARE TUTTE LE PARTI DI PARTI
		return  Persona.isValido(parti) 	&&
				isDecretatoValid(parti[12]) ;
	}
	
	private static boolean isDecretatoValid(String decretato) {
		if(decretato.equalsIgnoreCase("si") || decretato.equalsIgnoreCase("no"))
			return true;
		return false;
	}

	// METODI ---------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return super.toString() + "\n" + ((decretato) ? "Decretato" : "In attesa di decreto");
	}
	
	
	
	

}
