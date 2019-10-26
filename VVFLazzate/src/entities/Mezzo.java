package entities;

public class Mezzo {
	
	private String nome, sigla, targa;
	private int posti;
	
	private static  String charNotLetters = ",.;:-_|!£$%&/()=?^*+€°§";
	
	// COSTRUTTORE ---------------------------------------------------------------------------------------------------------------------------
	
	public Mezzo(String nome, String sigla, String targa, int posti) {
		this.nome = nome;
		this.sigla = sigla;
		this.targa = targa;
		this.posti = posti;
	}

	// GET SET ---------------------------------------------------------------------------------------------------------------------------
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(isNomeValido(nome))
			this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		if(isSiglaValida(sigla))
			this.sigla = sigla;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		if(isTargaValida(targa))
			this.targa = targa;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		if(isPostiValidi(posti))
			this.posti = posti;
	}
	
	// VALIDAZIONE ---------------------------------------------------------------------------------------------------------------------------
	
	static boolean isValido(String[] riga) {
		return 	isNomeValido(riga[0])	&&
				isSiglaValida(riga[1])	&&
				isTargaValida(riga[2])	&&
				isPostiValidi(Integer.parseInt(riga[3]));
	}
	
	private static boolean isNomeValido(String n) {
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

	private static boolean isSiglaValida(String n) {
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

	private static boolean isTargaValida(String targa) {
		return targa.length() == 7 && targa.substring(0,2).equalsIgnoreCase("vf");
	}

	private static boolean isPostiValidi(int posti) {
		return posti <= 6 && posti >= 2;
	}

	// METODI ---------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return (nome != null ? "Nome: " + nome + ", \n" : "") + (sigla != null ? "Sigla: " + sigla + ", \n" : "")
				+ (targa != null ? "Targa: " + targa + ", \n" : "") + "Posti: " + posti;
	}	

}
