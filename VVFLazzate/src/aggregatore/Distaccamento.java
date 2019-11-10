package aggregatore;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import entities.Intervento;
import entities.Mezzo;
import entities.Persona;
import entities.Vigile;

public class Distaccamento {
	
	private List<Persona> personale = new ArrayList<Persona>();
	private List<Mezzo> mezzi = new ArrayList<Mezzo>();
	private List<Intervento> interventi = new ArrayList<Intervento>();
	
	private Database db;
	
	public Distaccamento(String percorso, String username, String pw) {
		db = new Database(percorso, username, pw);
		caricaPersonale();
	}

	public void caricaPersonale() {
		db.apriConnessione();
		String query = "SELECT * FROM personale;";
		try {
			Statement s = db.getConnection().createStatement(); 				// createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet tabsql = s.executeQuery(query);							// un oggetto ResultSet è un'intera tabella di SQL, sia dati che metadati
			while(tabsql.next()) {
				Persona p = new Vigile(	tabsql.getInt("id"),
										tabsql.getString("nome"),
										tabsql.getString("cognome"),
										tabsql.getString("datanascita"),
										tabsql.getString("comuneres"),
										tabsql.getString("telefono"),
										tabsql.getString("mail"),
										tabsql.getString("ruolo"),
										tabsql.getString("grado"),
										tabsql.getInt("patente"),
										tabsql.getInt("annodec"),
										tabsql.getString("qualifiche"));
				personale.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
	}
	
	public void caricaMezzi() {
		db.apriConnessione();
		String query = "SELECT * FROM mezzi;";
		try {
			Statement s = db.getConnection().createStatement(); 				// createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet tabsql = s.executeQuery(query);							// un oggetto ResultSet è un'intera tabella di SQL, sia dati che metadati
			while(tabsql.next()) {
				Mezzo m = new Mezzo(	tabsql.getInt("id"),
										tabsql.getString("nome"),
										tabsql.getString("sigla"),
										tabsql.getInt("disco"),
										tabsql.getString("targa"),
										tabsql.getInt("posti"),
										tabsql.getInt("anno"));
				mezzi.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
	}
	
	// METODI ------------------------------------------------------------------------------------------
	
	public String stampaPersonale() {
		String ris = "";
		for(Persona p : personale)
			ris += p.toString()+"\n------------------------------------\n";
		return ris;
	}
	
	public String stampaMezzi() {
		String ris = "";
		for(Mezzo p : mezzi)
			ris += p+"\n------------------------------------\n";
		return ris;
	}
	
	public String stampaAnniServizio() {
		String ris = "";
		for(Persona p : personale)
			if(p instanceof Vigile)
				ris += p.getNome() + " " + p.getCognome() + " = " + ((Vigile)p).anniServizio() + " anni di servizio: decretato nel " + ((Vigile)p).getAnnoDecreto() + "\n";
		return ris;
	}
	
	
	
//	@Override
//	public double maxstipendi() {
//		double max = Double.MIN_VALUE;
//		for(Dipartimento dipa : dipartimenti)
//			for(Dipendente dipe : dipa.getDipendenti())
//				max = (max < dipe.getStipendio()) ? dipe.getStipendio() : max;
//	return max;
//	}
//
//	@Override
//	public double totstipendiNonORM() {
//		db.apriConnessione();
//		String query = "select round(sum(stipendio),2) totStipendi from dipendenti;";
//		try {
//			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
//			ResultSet rs = s.executeQuery(query);
//			return (rs.next() && rs != null) ? rs.getDouble("totStipendi") : 0;		
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		} finally {
//			db.chiudiConnessione();
//		}
//	}
	
}
