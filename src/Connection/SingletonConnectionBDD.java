package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	
public class SingletonConnectionBDD {
	
	static Connection conn = null;



		private SingletonConnectionBDD () {
		}
		public static Connection getConnection() {
			
			
			String login="root";
			String passwd="";
		String url="jdbc:mysql://localhost/librairie_db";

			try {
				if(conn== null) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn=DriverManager.getConnection(url, login, passwd);
				}
				
				
				
			} catch (Exception e) {
			
			e.printStackTrace();
			}
			return conn;
		}
		
		
		// fermer la connexion
		public void fermer() throws SQLException
		{
			conn.close();
			
		}
}


		