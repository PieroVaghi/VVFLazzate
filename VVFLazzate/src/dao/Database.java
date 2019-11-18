package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private Connection c;
	private String percorso;
	private String username;
	private String pw;
	
	public Database(String percorso, String username, String pw) {
		this.percorso = percorso;
		this.username = username;
		this.pw = pw;
	}
	
	public void apriConnessione() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(percorso, username, pw);
		} catch (Exception e) {
			System.out.println("CARICA IN BUILD PATH IL DRIVER DI JDBC, POI SE NON FUNZIONA VAI DA GLORIA");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return c;
	}
	
	public void chiudiConnessione() {
		try {
			c.close();
		} catch (Exception e){
			e.printStackTrace();			
		}
	}
	
	
}
