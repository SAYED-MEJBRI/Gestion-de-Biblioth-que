package main;

import model.Commande;
import model.Fournisseur;
import model.Livre;

public class Menu {
	Livre lv = null;
	Fournisseur fr =null;
	Commande cm=null;
	public Menu() throws Exception {
		lv=new Livre();
		fr=new Fournisseur();
		cm=new Commande();
	}
	
public void Menu_livre() throws Exception  {
	int choix=0;
	
	while(choix <=7) {
		System.out.println("******************************************************************************************************" );
		System.out.println("                                 MENU LIVRES  : " );
		System.out.println("******************************************************************************************************" );
		System.out.println("[1]: Afficher Tous les livres " );
		System.out.println("[2]: Afficher Par th�me" );
		System.out.println("[3]: Afficher par auteur" );
		System.out.println("[4]: Afficher par �diteur" );
		System.out.println("[5]: Ajouter un livre" );
		System.out.println("[6]: Modifier un livre" );
		System.out.println("[7]:supprimer un livre" );
		System.out.println("Autes Quitter" );
		System.out.println("Tapez le choix" );
		choix=Clavier.lireInt();
		switch(choix ) {
		case 1:
			
			lv.AfficherLivre();
		break;
		case 2:
			
			lv.AfficherParTheme();
		break;
		case 3:
			
			lv.AfficherParAuteur();
		break;
		case 4:
	
			lv.AfficherParEditeur();
		break;
		case 5:
			System.out.println("Ajout d'un livre" );
			lv.AjouterLivre();
		break;
		case 6:
		
			lv.UpdateLivre();
		break;
		case 7:
			lv.DeleteLivre();
		break;
			default:
				System.out.println("Terminer" );
									
			
		}
			
	
		}
}

public void Menu_fournisseur() throws Exception {
	int choix=0;
	while(choix <=7) {
		System.out.println("******************************************************************************************************" );
		System.out.println("                                 MENU FOURNISSEUR  : " );
		System.out.println("******************************************************************************************************" );
		System.out.println("[1]: Afficher Tous les fournisseurs " );
		System.out.println("[2]: Afficher Par raison social" );
		System.out.println("[3]: Afficher par localit�" );
		System.out.println("[4]: Afficher par pays" );
		System.out.println("[5]: Ajouter un fournisseur" );
		System.out.println("[6]: Modifier un fournisseur" );
		System.out.println("[7]: Supprimer un fournisseur" );
		System.out.println("Autes Quitter" );
		System.out.println("Tapez le choix" );
		choix=Clavier.lireInt();
		switch(choix ) {
		case 1:
			fr.AfficherFournisseur();
		break;
		//case 2:
		//fr.AfficherFournisseurParRaison();
		//break;
		case 3:
		fr.AfficherFournisseurParLocalite();
		break;
		case 4:
		fr.AfficherFournisseurParPays();
		break;
		//case 5:
		//	System.out.println("Ajouter un fournisseur" );
			
		//	fr.AjouterFournisseur();
		//break;
		//case 6:
			//fr.UpdateFournisseur();
		//break;
		case 7:
			fr.DeleteFournisseur();
		break;
			default:
				System.out.println("Terminer" );
									
			
		}
			
	
		}
}
public void Menu_commande() {
	
	int choix=0;
	while(choix <=7) {
		System.out.println("******************************************************************************************************" );
		System.out.println("                                 MENU COMMANDE  : " );
		System.out.println("******************************************************************************************************" );
		System.out.println("[1]: Afficher Tous les commandes " );
		System.out.println("[2]: Afficher les commandes par auteur" );
		System.out.println("[3]: Afficher les commandes par �diteur" );
		System.out.println("[4]: Afficher les commandes par raison social" );
		System.out.println("[5]: Ajouter une commande" );
		System.out.println("[6]: Modifier Commande" );
		System.out.println("[7]: Supprimer Commande" );

		System.out.println("Autes Quitter" );
		System.out.println("Tapez le choix" );
		choix=Clavier.lireInt();
		switch(choix ) {
		case 1:
			cm.AfficherCommande();
		break;
		case 2:
			cm.AfficherCommandeParauteur();
		break;
		case 3:
			cm.AfficherCommandeParauteur();
		break;
		case 4:
			cm.AfficherCommandeParRaison();
		break;
		case 5:
			cm.AjouterCommande();
		break;
		case 6:
			cm.UpdateCommande();
		break;
		case 7:
			cm.DeleteCommande();
		break;
			default:
				System.out.println("Terminer" );
									
			
		}
	
	}}}
	
		