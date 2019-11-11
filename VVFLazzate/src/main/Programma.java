package main;

import java.util.Scanner;

import aggregatore.Distaccamento;

public class Programma {

	private static final String PWD = "piefragio1";

	public static void main(String[] args) {
		
		Scanner tastiera = new Scanner(System.in);
																	//?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		Distaccamento lazzate = new Distaccamento("jdbc:mysql://localhost:3306/vvflazzate?useSSL=false","root",PWD);

		System.out.println(lazzate.stampaPersonale());
		System.out.println(lazzate.stampaMezzi());
		System.out.println(lazzate.stampaAnniServizio());
//		System.out.println("Inserisci nome da cercare:");
//		String nome = tastiera.nextLine();
//		System.out.println("Inserisci cognome da cercare:");
//		String cognome = tastiera.nextLine();
//		System.out.println(lazzate.ricerca(nome, cognome));
//		System.out.println("Inserisci grado di patente ministeriale da cercare (1,2,3,4):");
//		int gradopatente = Integer.parseInt(tastiera.nextLine());
//		System.out.println(lazzate.ricerca(gradopatente));

		
	}

}
