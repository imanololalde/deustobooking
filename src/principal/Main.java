package principal;

import java.util.Collection;
import java.util.Iterator;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import datos.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try {
			    transaction.begin();
			    Aeropuerto salida=new Aeropuerto("BIO", "Bilbao");
			    Aeropuerto llegada=new Aeropuerto("BCN", "Barcelona");
			    Usuario usuario=new Usuario("Livio", "LEC","liviocuratolo@opendeusto.es");
			    Vuelo vuelo = new Vuelo("IB6789",salida,llegada);
			    ReservaVuelo reserva = new ReservaVuelo(usuario, vuelo, 3, 49.99);	    
			    persistentManager.makePersistent(reserva);
			    
			    System.out.println("- Inserted into db: " + usuario.getNickname());
			    System.out.println("- Inserted into db: " + vuelo.getCodigoVuelo());
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception inserting data into db: " + ex.getMessage());
			} finally {		    
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
			    
			    persistentManager.close();
			}
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try {
			    transaction.begin();
	
			    @SuppressWarnings("unchecked")
				Query<Vuelo> vuelosQuery = persistentManager.newQuery("SELECT FROM " + Vuelo.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");
			    
			    for (Vuelo vuelo : vuelosQuery.executeList()) {
			        System.out.println("- Selected reserva from db: " + vuelo.getCodigoVuelo());
			        persistentManager.deletePersistent(vuelo);
			        System.out.println("- Deleted reserva from db: " + vuelo.getCodigoVuelo());
			    }
			    
			    Extent<ReservaVuelo> reservaVueloExtent = persistentManager.getExtent(ReservaVuelo.class);
			    
			    for (ReservaVuelo reservaVuelo : reservaVueloExtent) {
			    	persistentManager.deletePersistent(reservaVuelo);
			        System.out.println("- Deleted vuelo from db: " + reservaVuelo.getCodigo());
			    }
	
			    transaction.commit();
			} catch(Exception ex) {
				System.err.println("* Exception executing a query: " + ex.getMessage());
			} finally {
				if (transaction.isActive()) {
			        transaction.rollback();
			    }
	
			    persistentManager.close();
			}
			
			try {
				//Crear la transaccion por cada acceso a las BBDD porque est� cerra
				persistentManager = persistentManagerFactory.getPersistenceManager();
				transaction = persistentManager.currentTransaction();
				
				transaction.begin();
				
				Query<ReservaVuelo> reserva = persistentManager.newQuery(ReservaVuelo.class);
				reserva.setFilter("codigo = IB6789");
				@SuppressWarnings("unchecked")
				
				//Borrando la reserva
				Collection<ReservaVuelo> resultado = (Collection<ReservaVuelo>) reserva.execute();
				
				Iterator<ReservaVuelo> iterator = resultado.iterator();
				while(iterator.hasNext()) {
					persistentManager.deletePersistent(iterator.next());
				}
				//Reserva borrada
				
				transaction.commit();
			} catch (Exception ex) {
				System.err.println("* Error borrado de reserva: " + ex.getMessage());
			} finally {
				//En caso de no funcionar la transaccion
				if(transaction != null && transaction.isActive()) {
					transaction.rollback();
				}
				if(persistentManager != null && !persistentManager.isClosed()) {
					persistentManager.close();
				}
			}
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}
}


