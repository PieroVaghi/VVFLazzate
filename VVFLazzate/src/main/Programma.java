package main;

import aggregatore.Distaccamento;

public class Programma {

	private static final String PWD = "piefragio1";

	public static void main(String[] args) {
																	//?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		Distaccamento lazzate = new Distaccamento("jdbc:mysql://localhost:3306/vvflazzate?useSSL=false","root",PWD);
//		lazzate.caricaPersonale();
		lazzate.caricaMezzi();
		

//		System.out.println(lazzate.stampaPersonale());
//		System.out.println(lazzate.stampaMezzi());
		System.out.println(lazzate.stampaAnniServizio());
//		a.caricaLingue();
////		for(Dipendente d : a.caricaDipendenti())
////			System.out.println(d.getLingue()+"\n");
////		for(Lingua l : a.caricaLingue())
////			System.out.println(l+"\n");
//		System.out.println("totStipendio: ");
//		System.out.println(a.totstipendi() + "€");
//		System.out.println("avgStipendio: ");
//		System.out.println(a.avgstipendi() + "€");
//		System.out.println("minStipendio: ");
//		System.out.println(a.minstipendi() + "€");
//		System.out.println("maxStipendio: ");
//		System.out.println(a.maxstipendi() + "€");
//		System.out.println("totStipendioNonORM: ");
//		System.out.println(a.totstipendiNonORM() + "€");
//		System.out.println("avgStipendioNonORM: ");
//		System.out.println(a.avgstipendiNonORM() + "€");
//		System.out.println("maxStipendioNonORM: ");
//		System.out.println(a.maxstipendiNonORM() + "€");
//		System.out.println("minStipendioNonORM: ");
//		System.out.println(a.minstipendiNonORM() + "€");
//		
		
		
	}

}
