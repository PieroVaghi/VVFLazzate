package aggregatore;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import enities.Dipartimento;
import enities.Dipendente;
import enities.Lingua;
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
						
													tabsql.getInt("massimacapienza"),
													tabsql.getString("nome"),
													tabsql.getString("citta"),
													tabsql.getDouble("budget"));
				dipartimenti.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
	}
	
	public List<Dipendente> caricaDipendenti() {
		List<Dipendente> dipendenti = new ArrayList<Dipendente>();
		db.apriConnessione();
		String query = "SELECT * FROM azienda.dipendenti;";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);							// un oggetto ResultSet  è un'intera tabella di SQL, sia dati che metadati
			while(rs.next()) {
				Dipendente d = new Dipendente(	rs.getInt("id"),
												rs.getInt("mensilita"),
												rs.getString("nome"),
												rs.getString("cognome"),
												rs.getString("genere"),
												rs.getString("dataNascita"),
												rs.getString("ruolo"),
												rs.getString("citta"),
												rs.getInt("iddipartimento"),
												rs.getString("dataassunzione"),
												rs.getInt("idresponsabile"),
												rs.getDouble("stipendio"));
				dipendenti.add(d);
				for (Dipartimento dip : dipartimenti) {
					if(dip.aggiungiDipendente(d))
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
		return dipendenti;
	}
	
	public List<Lingua> caricaLingue() {
		List<Lingua> lingue = new ArrayList<Lingua>();
		db.apriConnessione();
		String query = "select lingue.id, lingue.nome, lingue.bonus, parla.iddipendente, parla.competenza from parla join lingue on parla.idlingua = lingue.id";
		try {
			Statement s = db.getConnection().createStatement(); 				//createStatement() è lo strumento che ci consente di eseguire le query
			ResultSet rs = s.executeQuery(query);							// un oggetto ResultSet  è un'intera tabella di SQL, sia dati che metadati
			while(rs.next()) {
				Lingua l = new Lingua(	rs.getInt("id"),
												rs.getInt("competenza"),
												rs.getInt("iddipendente"),
												rs.getString("nome"),
												rs.getDouble("bonus"));
				lingue.add(l);
				for (Dipartimento dip : dipartimenti) 
					for(Dipendente d : dip.getDipendenti())
						if(d.aggiungiLingua(l))
							break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.chiudiConnessione();
		return lingue;
	}
	
}
