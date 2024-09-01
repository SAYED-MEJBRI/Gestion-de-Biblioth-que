package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.SingletonConnectionBDD;
import main.Clavier;

public class Commande {
	private Connection cnx = null;
	private ResultSet rs = null;
	private Statement st = null;
	private List<Long> liste, liste1 = null;
	private List<String> listauteur, listraison, listediteur = null;
	private List<Integer> ListIdCommande = null;
	private String date, ancdate, nbexemplaire1, ancprix, prix1, ancnb,auteur, raison, editeur, Idc;
	private Long isbn;
	private int id, nbexemplaire, codefournisseur;
	private double prix;

	public Commande() throws Exception {
		cnx= SingletonConnectionBDD.getConnection();
		st = cnx.createStatement();
	}

	// fonction qui un Arry liste avec la liste des codes Fournisseur
	public List<Long> ListFournisseur() {
		liste = new ArrayList<Long>();
		String sql = "select * from fournisseur_tb";
		try {
			
			rs =st.executeQuery(sql);
			while (rs.next()) {

				liste.add(rs.getLong("code_fournisseur"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return liste;
	}

	// fonction qui un Arry liste avec la liste des isbn livres
	public List<Long> ListLivre() {
		liste1 = new ArrayList<Long>();
		String sql = "select * from livre_tb";
		try {
			
			rs =st.executeQuery(sql);

			while (rs.next()) {

				liste1.add(rs.getLong("isbn"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return liste1;
	}

	// fonction qui rend une liste des noms d'auteurs
	public List<String> ListAuteur() {
		listauteur = new ArrayList<String>();
		String sql = "select Distinct nom_auteur from livre_tb";
		try {
			rs =st.executeQuery(sql);

			while (rs.next()) {

				listauteur.add(rs.getString("nom_auteur"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listauteur;
	}

	// fonction qui rend une liste des noms d'auteurs
	public List<String> ListEditeur() {
		listediteur = new ArrayList<String>();
		String sql = "select DISTINCT editeur  from livre_tb";
		try {
			rs = st.executeQuery(sql);

			while (rs.next()) {

				listediteur.add(rs.getString("editeur"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listediteur;
	}

	// fonction ranvoi une liste des raison social des fournisseur
	public List<String> ListRaison() {
		listraison = new ArrayList<String>();
		String sql = "SELECT * FROM fournisseur_tb";
		try {
			rs = st.executeQuery(sql);

			while (rs.next()) {

				listraison.add(rs.getString("raison_social"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listraison;
	}

	// fonction qui renvoie un Array liste avec la liste des codes Fournisseur
	public List<Integer> ListIdCommande() {
		ListIdCommande = new ArrayList<Integer>();
		String sql = "select * from commande_tb";
		try {
			rs = st.executeQuery(sql);

			while (rs.next()) {

				ListIdCommande.add(rs.getInt("id_commande"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ListIdCommande;
	}

	public void AfficherCommande() {
		String sql = "SELECT c.id_commande,c.data_achat, c.prix_achat, c.nb_exemplaires, l.titre_livre, l.nom_auteur, f.raison_social, f.localite "
				+ "FROM commande_tb c,fournisseur_tb f, livre_tb l WHERE c.code_fournisseur=f.code_fournisseur and c.isbn=l.isbn";

		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-10s %20s %10s %10s %30s %20s %30s %30s", "Id Commande:", "Dtae d'achat:",
					" Prix d'achat:", "Nembre d'exemplaire: ", "Titre de livre: ", " Nom auteur:", "Raison social: ",
					"Localité: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-10s %-20s %10s %10s %50s %20s %20s %30s", rs.getString("c.id_commande"),
						rs.getString("c.data_achat"), rs.getString("c.prix_achat"), rs.getString("c.nb_exemplaires"),
						rs.getString("l.titre_livre"), rs.getString("l.nom_auteur"), rs.getString("f.raison_social"),
						rs.getString("f.localite"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// afficher les commande par auteur
	public void AfficherCommandeParauteur() {

		do {
			System.out.println("liste des auteurs:");
			for (int i = 0; i < ListAuteur().size(); i++) {
				System.out.println(
						"------------------------------------");
				System.out.println(ListAuteur().get(i));

			}

			System.out.println("Choisir auteur");
			auteur = Clavier.lireString();

		} while (ListAuteur().contains(auteur)==false);
		String sql = "SELECT c.data_achat, c.prix_achat, c.nb_exemplaires, l.titre_livre, l.nom_auteur, f.raison_social, f.localite "
				+ "FROM commande_tb c,fournisseur_tb f, livre_tb l WHERE c.code_fournisseur=f.code_fournisseur and c.isbn=l.isbn and l.nom_auteur='"
				+ auteur + "'";

		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-20s %10s %10s %30s %20s %30s %30s", "Date d'achat:", " Prix d'achat:",
					"Nembre d'exemplaire: ", "Titre de livre: ", " Nom auteur:", "Raison social: ", "Localité: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s %10s %10s %50s %20s %20s %30s", rs.getString("c.data_achat"),
						rs.getString("c.prix_achat"), rs.getString("c.nb_exemplaires"), rs.getString("l.titre_livre"),
						rs.getString("l.nom_auteur"), rs.getString("f.raison_social"), rs.getString("f.localite"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Recherche par raison editeur
	public void AfficherCommandeParEditeur() {

		do {
			System.out.println("liste des éditeurs:");
			for (int i = 0; i < ListRaison().size(); i++) {
				System.out.println(
						"------------------------------------");
				System.out.println(ListRaison().get(i));

			}

			System.out.println("Choisir un éditeur");
			editeur = Clavier.lireString();

		} while (ListRaison().contains(editeur) == false);
		String sql = "SELECT c.data_achat, c.prix_achat, c.nb_exemplaires, l.titre_livre, l.nom_auteur, f.raison_social, f.localite "
				+ "FROM commande_tb c,fournisseur_tb f, livre_tb l WHERE c.code_fournisseur=f.code_fournisseur and c.isbn=l.isbn and f.raison_social='"
				+ editeur + "'";

		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-20s %10s %10s %30s %20s %30s %30s", "Dtae d'achat:", " Prix d'achat:",
					"Nembre d'exemplaire: ", "Titre de livre: ", " Nom auteur:", "Raison social: ", "Localité: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s %10s %10s %50s %20s %20s %30s", rs.getString("c.data_achat"),
						rs.getString("c.prix_achat"), rs.getString("c.nb_exemplaires"), rs.getString("l.titre_livre"),
						rs.getString("l.nom_auteur"), rs.getString("f.raison_social"), rs.getString("f.localite"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Recherche par raison social
	public void AfficherCommandeParRaison() {

		do {
			System.out.println("liste des raison social:");
			for (int i = 0; i < ListRaison().size(); i++) {
				System.out.println(
						"------------------------------------");
				System.out.println(ListRaison().get(i));

			}

			System.out.println("Choisir raison social");
			raison = Clavier.lireString();

		} while (ListRaison().contains(raison) == false);
		String sql = "SELECT c.data_achat, c.prix_achat, c.nb_exemplaires, l.titre_livre, l.nom_auteur, f.raison_social, f.localite "
				+ "FROM commande_tb c,fournisseur_tb f, livre_tb l WHERE c.code_fournisseur=f.code_fournisseur and c.isbn=l.isbn and f.raison_social='"
				+ raison + "'";

		try {
			rs = st.executeQuery(sql);
			System.out.printf("%-20s %10s %10s %30s %20s %30s %30s", "Dtae d'achat:", " Prix d'achat:",
					"Nembre d'exemplaire: ", "Titre de livre: ", " Nom auteur:", "Raison social: ", "Localité: ");
			System.out.println("");

			while (rs.next()) {
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-20s %10s %10s %50s %20s %20s %30s", rs.getString("c.data_achat"),
						rs.getString("c.prix_achat"), rs.getString("c.nb_exemplaires"), rs.getString("l.titre_livre"),
						rs.getString("l.nom_auteur"), rs.getString("f.raison_social"), rs.getString("f.localite"));
				System.out.println("");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void AjouterCommande() {
		do {
			System.out.println("liste des Codes fournisseur :");
			for (int i = 0; i < ListFournisseur().size(); i++) {
				System.out.println(
						"------------------------------------");
				System.out.println(ListFournisseur().get(i));

			}
			System.out.println("Donner le code fournisseur");
			codefournisseur = Clavier.lireInt();

		} while (ListFournisseur().contains(codefournisseur));
		System.out.println("Trouvé");
		do {
			System.out.println("liste des ISBN :");
			for (int i = 0; i < ListLivre().size(); i++) {

				System.out.println(ListLivre().get(i));

			}

			System.out.println("Donner l'isbn livre");
			isbn = Clavier.lireLong();

		} while (!ListLivre().contains(isbn));
		System.out.println("Trouvé");
		System.out.println("Donner la date ");
		date = Clavier.lireString();
		System.out.println("saisir le prix ");
		prix = Clavier.lireDouble();
		System.out.println("saisir le nombre d'exemplaire ");
		nbexemplaire = Clavier.lireInt();
		String sql = " INSERT INtO commande_tb"
				+ " (`isbn`,`code_fournisseur`,`data_achat`,`prix_achat`,`nb_exemplaires` ) " + "VALUES ('" + isbn
				+ "','" + codefournisseur + "','" + date + "','" + prix + "','" + nbexemplaire + "')";
		try {
			int res = st.executeUpdate(sql);
			if (res > 0) {
				System.out.println("Commande ajouter avec succés ");
			} else {
				System.out.println("Commande non ajouter");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void UpdateCommande() {
	AfficherCommande();
	System.out.println("donner l'id du commande a modifier");
	id = Clavier.lireInt();
	String sql= "select * from commande_tb where id_commande='"+id+"'";
	try {
		rs =st.executeQuery(sql);
		
		
		while(rs.next())
		{
			ancdate=rs.getString("data_achat");
			ancprix=rs.getString("prix_achat");
			ancnb=rs.getString("nb_exemplaires");
		}
		
		
	}catch (SQLException e) 
	{
		
		e.printStackTrace();
	}
		//System.out.println("Trouvé");
		System.out.println("modifier la date format aaaa-mm-jj ");
		date = Clavier.lireString();
		if(date.length()<1) {
			date=ancdate;
		}
		System.out.println("modifier le prix ");
		 prix1 = Clavier.lireString();
		if (prix1.length()<1) 
		{
			prix1=ancprix;
		}
		prix=Float.parseFloat(prix1);
		System.out.println("modifier le nombre d'exemplaire ");
		nbexemplaire1 = Clavier.lireString();
		if(nbexemplaire1.length()<1) {
			nbexemplaire1=ancnb;
		}
		nbexemplaire=Integer.parseInt(nbexemplaire1);
		String sql1 = " UPDATE commande_tb SET data_achat ='" + date + "',prix_achat='" + prix + "', nb_exemplaires='" + nbexemplaire + "' where id_commande ='"+id+"'";
				
		try {
			int res = st.executeUpdate(sql1);
			if (res > 0) {
				System.out.println("Commande modifier ");
			} else {
				System.out.println("erreur");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void DeleteCommande() {
		AfficherCommande();
		do {
			System.out.println("Saisir l'Id de la commande a suprimé");
			id = Clavier.lireInt();
		} while (ListIdCommande().contains(id) == false);
		System.out.println("trouvé");
		String sql = "delete FROM commande_tb WHERE id_commande ='" + id + "' ";
		try {
			int res = st.executeUpdate(sql);
			if (res > 0) {
				System.out.println("Commande suprimée ");
			} else {
				System.out.println("Commande non suprimée");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
