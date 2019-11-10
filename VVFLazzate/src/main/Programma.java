package main;

import aggregatore.Distaccamento;

public class Programma {

	private static final String PWD = "piefragio1";

	public static void main(String[] args) {
																	//?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		Distaccamento lazzate = new Distaccamento("jdbc:mysql://localhost:3306/vvflazzate?useSSL=false","root",PWD);

		

//		System.out.println(lazzate.stampaPersonale());
//		System.out.println(lazzate.stampaMezzi());
		System.out.println(lazzate.stampaAnniServizio());
		
	}

}
