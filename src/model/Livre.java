package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.SingletonConnectionBDD;
import main.Clavier;

public class Livre {
	private Connection cnx = null;
	private ResultSet rs= null;
	private Statement st =null;
	private Commande com=null;
	private List<String> listetheme= null;
	private List<Long> listeNonCommande=null;
	private String theme, auteur , editeur=null;
	private String ajoutitre,ajoutheme,ajoutediteur,ajoutauteur;
	private int  ajoutnbr;
	private double ajoutprix;
	private long ajoutISBN ,ISBN;
	private String anctitre, anctheme, ancnbpage, ancprix, ancediteur,ajoutnbr1, ancauteur, ajoutprix1;
	
	
	public Livre() throws Exception {
		// TODO Auto-generated constructor stub
		cnx= SingletonConnectionBDD.getConnection();
		com=new Commande();
		st = cnx.createStatement();
		
	}
	// fonction qui un Arry liste avec la liste des isbn livres
			public List<Long> ListLivNonCom() throws SQLException{
				listeNonCommande = new ArrayList<Long>();
				String sql= "select * from livre_tb l LEFT JOIN commande_tb c ON l.isbn= c.isbn WHERE c.isbn IS NULL";
				
				try {
				
					rs =st.executeQuery(sql);

					
				while(rs.next())
					{

					listeNonCommande.add(rs.getLong("isbn"));
						
					}
				}catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
				return listeNonCommande;
			}
	
	// fonction qui un Arry liste avec la liste des codes Fournisseur
		public List<String> ListTheme(){
			listetheme = new ArrayList<String>();
			String sql= "select DISTINCT theme_livre from livre_tb";
			try {
				
				rs =st.executeQuery(sql);

				
			while(rs.next())
				{

				listetheme.add(rs.getString("theme_livre"));
					
				}
			}catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			return listetheme;
		}
		
		//Fonfion afficher les information sur les livre 
	public void AfficherLivre() {
		String sql= "select * from livre_tb";
		
		try {
			
			rs =st.executeQuery(sql);
			System.out.printf("%-25s %15s %40s %20s %30s %20s","ISBN:"," Titre:","Thème:","Nbr Pages:","Prix: ","Editeur: " );
			System.out.println("");
			
			while(rs.next())
			{
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-25s %20s %40s %10s %35s %20s",rs.getString("isbn"),rs.getString("titre_livre"),rs.getString("theme_livre"),rs.getString("nbr_pages_livre"),rs.getString("prix_vente"),rs.getString("editeur") );
				System.out.println("");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				
			}
			
			
		}catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	// Affiche la liste des livres non commandés
	public void AfficherLivreNonCommandes() {
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("                                                            La Liste des livres non Commandés");

		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

		String sql= "select * from livre_tb l LEFT JOIN commande_tb c ON l.isbn= c.isbn WHERE c.isbn IS NULL";
		try {
			
			rs =st.executeQuery(sql);
			System.out.printf("%-25s %15s %40s %20s %30s %20s","ISBN:"," Titre:","Thème:","Nbr Pages:","Prix: ","Editeur: " );
			System.out.println("");
			
			while(rs.next())
			{
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-25s %20s %40s %10s %35s %20s",rs.getString("isbn"),rs.getString("titre_livre"),rs.getString("theme_livre"),rs.getString("nbr_pages_livre"),rs.getString("prix_vente"),rs.getString("editeur") );
				System.out.println("");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				
			}
			
			
		}catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	//Fonction afficher les information sur les livre par thème
	public void AfficherParTheme() {
		do {
			System.out.println("liste des suteurs:");
			for(int i=0;i<ListTheme().size();i++) {
				System.out.println(
						"------------------------------------");
			System.out.println(ListTheme().get(i));	
			
			}
			
			System.out.println("Choisir thème");
			theme=Clavier.lireString();
			
			}while(ListTheme().contains(theme)==false);
		
		String sql= "select * from livre_tb where theme_livre='"+theme+"'";
		try {
			
			rs =st.executeQuery(sql);
			System.out.printf("%-25s %15s %40s %20s %30s %20s","ISBN:"," Titre:","Thème:","Nbr Pages:","Prix: ","Editeur: " );
			System.out.println("");
			
			while(rs.next())
			{
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-25s %20s %40s %10s %35s %20s",rs.getString("isbn"),rs.getString("titre_livre"),rs.getString("theme_livre"),rs.getString("nbr_pages_livre"),rs.getString("prix_vente"),rs.getString("editeur") );
				System.out.println("");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				
			}
			
			
		}catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	//Fonction afficher les information sur les livre par auteur
	public void AfficherParAuteur() {
		do {
			System.out.println("liste des auteurs:");
			for(int i=0;i<com.ListAuteur().size();i++) {
				System.out.println(
						"------------------------------------");
			System.out.println(com.ListAuteur().get(i));	
			
			}
			
			System.out.println("Choisir auteur");
			auteur=Clavier.lireString();
			
			}while(ListTheme().contains(auteur));
		
		String sql= "select * from livre_tb where nom_auteur='"+auteur+"'";
		try {
			Statement st = cnx.createStatement();
			rs =st.executeQuery(sql);
			System.out.printf("%-25s %15s %40s %20s %30s %20s","ISBN:"," Titre:","Thème:","Nbr Pages:","Prix: ","Editeur: " );
			System.out.println("");
			
			while(rs.next())
			{
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-25s %20s %40s %10s %35s %20s",rs.getString("isbn"),rs.getString("titre_livre"),rs.getString("theme_livre"),rs.getString("nbr_pages_livre"),rs.getString("prix_vente"),rs.getString("editeur") );
				System.out.println("");
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

				
			}
			
			
		}catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	//Fonction afficher les informations sur les livres par editeur
		public void AfficherParEditeur() {
			do {
				System.out.println("liste des éditeurs:");
				for(int i=0;i<com.ListEditeur().size();i++) {
					System.out.println(
							"------------------------------------");
				System.out.println(com.ListEditeur().get(i));	
				
				}
				
				System.out.println("Choisir éditeur");
				editeur=Clavier.lireString();
				
				}while(ListTheme().contains(editeur));
			
			String sql= "select * from livre_tb where editeur='"+editeur+"'";
			try {
				
				rs =st.executeQuery(sql);
				System.out.printf("%-25s %15s %40s %20s %30s %20s","ISBN:"," Titre:","Thème:","Nbr Pages:","Prix: ","Editeur: " );
				System.out.println("");
				
				while(rs.next())
				{
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.printf("%-25s %20s %40s %10s %35s %20s",rs.getString("isbn"),rs.getString("titre_livre"),rs.getString("theme_livre"),rs.getString("nbr_pages_livre"),rs.getString("prix_vente"),rs.getString("editeur") );
					System.out.println("");
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

					
				}
				
				
			}catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		// Fonction Ajouter livre ajoute un livre
		public void AjouterLivre() {

			do {
				System.out.println("liste des éditeurs:");
				for(int i=0;i<com.ListLivre().size();i++) {
					System.out.println(
							"------------------------------------");
				System.out.println(com.ListLivre().get(i));	
				
				}
				
				System.out.println("Donner le ISBN du livre exp(1020304050)");
				ajoutISBN= Clavier.lireLong();
				
				}while(com.ListLivre().contains(ajoutISBN));
				
				
				System.out.println("Donner le Titre de livreà à jouter");
				ajoutitre= Clavier.lireString();
				System.out.println("Donner le thème");
				ajoutheme  = Clavier.lireString();
				System.out.println("Nombres de pages");
				ajoutnbr= Clavier.lireInt();
				System.out.println("Donner le nom de l'auteur");
				ajoutauteur= Clavier.lireString();
				System.out.println("Donner l'editeur de livre");
				ajoutediteur= Clavier.lireString();
				System.out.println("Entrée le prix de vente");
				ajoutprix = Clavier.lireDouble();
				String sql= " INSERT INtO livre_tb (`isbn`,`titre_livre`,`theme_livre`,`nbr_pages_livre`,`nom_auteur`,`editeur`,`prix_vente` ) VALUES ('"+ajoutISBN+"','"+ajoutitre+"','"+ajoutheme+"','"+ajoutnbr+"','"+ajoutauteur+"','"+ajoutediteur+"','"+ajoutprix+"')";
				try {
					
					int res = st.executeUpdate(sql);
					if(res>0) {
						System.out.println("Livre ajouter avec succés ");
					}
						else {
							System.out.println("livre non ajouter");
						}
					
					
				}catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
		}
		public void UpdateLivre() {

			do {
				
				AfficherLivre();
				
				System.out.println("Donner le ISBN du livre à modifier");
				ajoutISBN= Clavier.lireLong();
				
				}while(!com.ListLivre().contains(ajoutISBN));
			String sql= "select * from livre_tb where isbn='"+ajoutISBN+"'";
			try {
				
				rs =st.executeQuery(sql);
				
				
				while(rs.next())
				{
					
					
					 anctitre=rs.getString("titre_livre");
					// System.out.println(anctitre);
					 anctheme=rs.getString("theme_livre");
					 ancnbpage=rs.getString("nbr_pages_livre");
					 ancprix=rs.getString("prix_vente");
					 ancediteur=rs.getString("editeur");
					 ancauteur=rs.getString("nom_auteur");
				}
				
				
			}catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
				
				System.out.println("Voulez vous modifier le titre");
				ajoutitre= Clavier.lireString();
				if(ajoutitre.length()<1){
					ajoutitre=anctitre;
					 
				}
			System.out.println(ajoutitre);
				System.out.println("Voulez vous modifié thème");
				ajoutheme  = Clavier.lireString();
				if(ajoutheme.length()<1){
					ajoutheme=anctheme;
					
				}
				System.out.println("Voulez vous modifié le Nombre de page");
				 ajoutnbr1= Clavier.lireString();
				if(ajoutnbr1.length()<1){
					ajoutnbr1=ancnbpage;
					
				}
				ajoutnbr=Integer.parseInt(ajoutnbr1);
				System.out.println("Voulez vous modifié le nom de l'auteur");
				ajoutauteur= Clavier.lireString();
				if(ajoutauteur.length()<1){
					ajoutauteur=ancauteur;

				}
				System.out.println("Voulez vous modifié l'editeur de livre");
				ajoutediteur= Clavier.lireString();
				if(ajoutediteur.length()<1){
					ajoutediteur=ancediteur;
					
				}
				System.out.println("Entrée le prix de vente");
				ajoutprix1 = Clavier.lireString();
				if(ajoutprix1.length()<1){
					ajoutprix1=ancprix;
					
				}
				ajoutprix=Float.parseFloat(ajoutprix1);
				 String sql1 = "UPDATE livre_tb SET titre_livre ='"+ajoutitre+"', theme_livre ='"+ajoutheme+"',nbr_pages_livre ='"+ajoutnbr+"',nom_auteur ='"+ajoutauteur+"',editeur ='"+ajoutediteur+"',prix_vente ='"+ajoutprix+"' WHERE isbn = "+ajoutISBN+"";//				  String sql1 = "UPDATE livre_tb SET titre_livre = '"+ajoutitre+"'WHERE isbn = "+ajoutISBN+" ;";
		            try {
		            	Statement st = cnx.createStatement();
		                int res = st.executeUpdate(sql1);
		                if (res>0) {
		                    System.out.println("Livre modifier");
		                    System.out.println("");
		            } 
		                else 
		            { 
		                System.out.println("Erreur de syntaxe");
		                System.out.println("");
		            }



		        } 

		        catch (SQLException e) 
		        {

		        }
		    
		  
		    }
		public void DeleteLivre() throws SQLException {
			AfficherLivreNonCommandes();
			do {
			System.out.println("Saisir l'ISBN du livre à suprimé");
			ISBN=Clavier.lireLong();
			}while(ListLivNonCom().contains(ISBN)==false);
			System.out.println("trouvé");
			String sql= "delete FROM livre_tb WHERE isbn ='"+ISBN+"' ";
			try {
				int res = st.executeUpdate(sql);
				if(res>0) {
					System.out.println("Livre suprimée ");
				}
					else {
						System.out.println("Livre non suprimée");
					}
				
				
			}catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}


}
