package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.SingletonConnectionBDD;
import main.Clavier;
public class Fournisseur {
	private Connection cnx = null;
	private ResultSet rs = null;
	private Statement st=null;
	private Commande com = null;
	private List<Integer> listfournc = null;
	private List<String> listlocalite, paysfour = null;
	private String raison, localite,pays, numero, email, Rraison, Rlocalite, Rpays;
	private String ancraison,anclocalite,ancpays,ancnumero,ancemail;
	private int code, codesup;

	public Fournisseur() throws Exception {
		// TODO Auto-generated constructor stub
		cnx= SingletonConnectionBDD.getConnection();
		com=new Commande();
		 st = cnx.createStatement();
	}

	// fonction qui renvoie un Arrayliste avec la liste des fournisseurs qui n'ont
	// pas pass�s aucune commande
	public List<Integer> ListFourNonCom() {
		listfournc = new ArrayList<Integer>();
		String sql = "select * from fournisseur_tb f LEFT JOIN commande_tb c ON f.code_fournisseur= c.code_fournisseur WHERE c.code_fournisseur IS NULL";
		try {
			rs = st.executeQuery(sql);

			while (rs.next()) {

				listfournc.add(rs.getInt("code_fournisseur"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listfournc;
	}

	// fonction qui renvoie un Arrayliste avec la liste des localit�s des fournisseurs

	public List<String> ListLocalite() {
		listlocalite = new ArrayList<String>();
		String sql = "select DISTINCT localite  from fournisseur_tb ";
		try {
			rs = st.executeQuery(sql);

			while (rs.next()) {

				listlocalite.add(rs.getString("localite"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listlocalite;
	}
	// fonction qui renvoie un Arrayliste avec la liste des pays des fournisseurs

	public List<String> ListPays() {
		paysfour = new ArrayList<String>();
		String sql = "select DISTINCT pays  from fournisseur_tb ";
		try {
			rs = st.executeQuery(sql);

			while (rs.next()) {

				paysfour.add(rs.getString("pays"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return paysfour;
	}
// Afficher tous les fournisseurs
	public void AfficherFournisseur() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("                                                             Liste des Fournisseurs:");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		String sql = "select * from 	fournisseur_tb";
		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-30s %-20s %10s %30s %30s %30s", "Code:", " Nom:","Localite:","Pays:", "Tel: ", "Email: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				System.out.printf("%-30s %-20s %10s %30s %30s %30s", rs.getString("code_fournisseur"),
						rs.getString("raison_social"),rs.getString("localite"),
						rs.getString("pays"), rs.getString("tel_fournisseur"),
						rs.getString("email_fournisseur"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Afficher fournisseur par raison social
 public void AfficherFournisseurParRaison() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("                                                             Liste des Raisons Social:");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		do {
			
			for (int i = 0; i < com.ListRaison().size(); i++) {
				System.out.printf("%90s",
						"------------------------------------");
				System.out.println("");

				
				System.out.printf("%80s", com.ListRaison().get(i));
				System.out.println("");

			}

			System.out.println("Choisir raison social:");
			Rraison = Clavier.lireString();
		} while (com.ListRaison().contains(Rraison) == false);
		
		String sql = "select * from 	fournisseur_tb where raison_social='" + Rraison + "'";
		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-30s %-20s %10s %30s %30s %30s", "Code:", " Nom:","Localite:","Pays:", "Tel: ", "Email: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				System.out.printf("%-30s %-20s %10s %30s %30s %30s", rs.getString("code_fournisseur"),
						rs.getString("raison_social"),rs.getString("localite"),
						rs.getString("pays"), rs.getString("tel_fournisseur"),
						rs.getString("email_fournisseur"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Afficher fournisseur par localit� 
	public void AfficherFournisseurParLocalite() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println(
				"                                                             Liste des localit�s des fournisseurs:");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		do {

			for (int i = 0; i < ListLocalite().size(); i++) {
				System.out.printf("%90s",
						"------------------------------------");
				System.out.println("");

				System.out.printf("%80s", ListLocalite().get(i));
				System.out.println("");

			}

			System.out.println("Choisir localit�:");
			Rlocalite = Clavier.lireString();
		} while (ListLocalite().contains(Rlocalite) == false);
		String sql = "select * from 	fournisseur_tb where localite='" + Rlocalite + "'";
		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-30s %-20s %10s %30s %30s %30s", "Code:", " Nom:","Localite:","Pays:", "Tel: ", "Email: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				System.out.printf("%-30s %-20s %10s %30s %30s %30s", rs.getString("code_fournisseur"),
						rs.getString("raison_social"),rs.getString("localite"),
						rs.getString("pays"), rs.getString("tel_fournisseur"),
						rs.getString("email_fournisseur"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Afficher fournisseur par pays 
		public void AfficherFournisseurParPays() {
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			System.out.println(
					"                                                             Liste des Pays des fournisseurs:");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
			do {

				for (int i = 0; i < ListPays().size(); i++) {
					System.out.printf("%90s",
							"------------------------------------");
					System.out.println("");

				
					System.out.printf("%80s", ListPays().get(i));
					System.out.println("");

				}

				System.out.println("Choisir pays:");
				Rpays = Clavier.lireString();
			} while (ListPays().contains(Rpays) == false);
			
			String sql = "select * from 	fournisseur_tb where pays='" + Rpays + "'";
			try {
				rs = st.executeQuery(sql);
				System.out.printf("%-30s %-20s %10s %30s %30s %30s", "Code:", " Nom:","Localite:","Pays:", "Tel: ", "Email: ");
				System.out.println("");

				while (rs.next()) {
					System.out.println(
							"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

					System.out.printf("%-30s %-20s %10s %30s %30s %30s", rs.getString("code_fournisseur"),
							rs.getString("raison_social"),rs.getString("localite"),
							rs.getString("pays"), rs.getString("tel_fournisseur"),
							rs.getString("email_fournisseur"));
					System.out.println("");
					System.out.println(
							"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	// Ajout d'un fournisseur

	public void AjouterFournisseur() {

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("                                                             Ajout d'un fournisseur:");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		do {

			System.out.println("Donner le code de fournisseur exp(102)");
			code = Clavier.lireInt();
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		} while (com.ListFournisseur().contains(code));
		System.out.println("Donner la raison social");
		raison = Clavier.lireString();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Donner la localit�");
		localite = Clavier.lireString();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Donner le pays");
		pays = Clavier.lireString();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Donner le num�ro de t�l");
		numero = Clavier.lireString();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Donner l'e_mailr");
		email = Clavier.lireString();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		String sql = " INSERT INtO fournisseur_tb (`code_fournisseur`,`raison_social`,`localite`,`pays`,`tel_fournisseur`,`email_fournisseur` ) VALUES ('"
				+ code + "','" + raison + "','" + localite + "','" + pays+ "','" + numero + "','" + email + "')";
		try {
			int res = st.executeUpdate(sql);
			if (res > 0) {
				System.out.println("Fournisseur ajouter avec succ�s ");
			} else {
				System.out.println("Fournisseur non ajouter");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void UpdateFournisseur() {

		AfficherFournisseur();
		do {

			System.out.println("Donner le code de fournisseur � modifier");
			code = Clavier.lireInt();
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		} while (com.ListFournisseur().contains(code));
//
		
		String sql = "select * from 	fournisseur_tb where code_fournisseur= '"+code+"'";
		try {
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				//System.out.printf("%-30s %-20s %10s %30s %30s %30s", rs.getString("code_fournisseur"),
					ancraison=	rs.getString("raison_social");
					anclocalite=rs.getString("localite");
						ancpays=rs.getString("pays");
						ancnumero=rs.getString("tel_fournisseur");
						ancemail=rs.getString("email_fournisseur");
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Donner la raison social");
		raison = Clavier.lireString();
		if(raison.length()<1){
			raison=ancraison;
			
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Donner la localit�");
		localite = Clavier.lireString();
		if(localite.length()<1){
			localite=anclocalite;
			
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Donner le pays");
		pays = Clavier.lireString();
		if(pays.length()<1){
			pays=ancpays;
			
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Donner le num�ro de t�l");
		numero = Clavier.lireString();
		if(numero.length()<1){
			numero=ancnumero;
			
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Donner l'e_mailr");
		email = Clavier.lireString();
		if(email.length()<1){
			email=ancemail;
			
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		 String sql1 = "UPDATE fournisseur_tb SET raison_social ='"+raison+"', localite ='"+localite+"',pays ='"+pays+"',tel_fournisseur ='"+numero+"' WHERE code_fournisseur = "+code+"";
		 try {
			int res = st.executeUpdate(sql1);
			if (res > 0) {
				System.out.println("Fournisseur modifier ");
			} else {
				System.out.println("erreur");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Affiche la liste des fournisseurs qui n'ont pas pass�s aucune commande
	public void AfficherFourNonCommandes() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println(
				"                                                            La Liste des des fournisseurs qui n'ont pas pass�s aucune commande:");

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		String sql = "select * from fournisseur_tb f LEFT JOIN commande_tb c ON f.code_fournisseur= c.code_fournisseur WHERE c.code_fournisseur IS NULL";
		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-30s %-20s %10s %30s %30s %30s", "Code:", " Nom:","Localite:","Pays:", "Tel: ", "Email: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				System.out.printf("%-30s %-20s %10s %30s %30s %30s", rs.getString("code_fournisseur"),
						rs.getString("raison_social"),rs.getString("localite"),
						rs.getString("pays"), rs.getString("tel_fournisseur"),
						rs.getString("email_fournisseur"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Suprim�e un fournisseur
	public void DeleteFournisseur() {

		AfficherFourNonCommandes();
		do {
			System.out.println("Saisir le code du fournisseur � suprim�");
			codesup = Clavier.lireInt();
		} while (ListFourNonCom().contains(codesup)==false );
		System.out.println("trouv�");
		String sql = "delete FROM fournisseur_tb WHERE code_fournisseur ='" + codesup + "' ";
		try {
			int res = st.executeUpdate(sql);
			if (res > 0) {
				System.out.println("Fournisseur suprim�e ");
			} else {
				System.out.println("Fournisseur non suprim�e");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}



}
