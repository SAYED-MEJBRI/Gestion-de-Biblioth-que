package main;


public class Application {

	public Application() throws Exception {
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		Menu m=new Menu();
		
		

		int choix=0;
		while(choix <=4) {
			System.out.println("******************************************************************************************************" );
			System.out.println("                                   LIBRAIRIE Menu Principal: " );
			System.out.println("******************************************************************************************************" );
			System.out.println("[1]: livres " );
			System.out.println("[2]: Fournisseurs" );
			System.out.println("[3]: Commandes" );		
			System.out.println("Autes Sortir" );
			System.out.println("Tapez le choix" );
			
			choix=Clavier.lireInt();
		switch(choix ) {
		case 1:
			m.Menu_livre();
		break;
		case 2:
			m.Menu_fournisseur();
		break;
		case 3:
			m.Menu_commande();
		break;
		
			default:
				System.out.println("Terminer" );
									
			
		}
			}
		
	}
	

	}


