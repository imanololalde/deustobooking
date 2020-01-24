package principal;

import java.util.Collection;
import java.util.Iterator;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.BasicConfigurator;

import datos.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aeropuerto salida = new Aeropuerto();
	    salida.setCodigo("BIO");
	    salida.setNombre("Bilbao");
	    
	    Aeropuerto llegada = new Aeropuerto();
	    llegada.setCodigo("BCN");
	    llegada.setNombre("Barcelona");
	    
	    Usuario usuario = new Usuario();
	    usuario.setNombre("Livio");
	    usuario.setApellidos("Curatolo");
	    usuario.setNickname("LEC");
	    usuario.setEmail("liviocuratolo@opendeusto.es");
	    
	    Vuelo vuelo = new Vuelo();
	    vuelo.setCodigoVuelo("IB6789");
	    vuelo.addElement(salida);
	    vuelo.addElement(llegada);
	    Vuelo vuelo2 = new Vuelo();
	    vuelo2.setCodigoVuelo("VL7845");
	    vuelo2.addElement(llegada);
	    vuelo2.addElement(salida);
	    
	    ReservaVuelo reserva = new ReservaVuelo();
	    reserva.addUsuario(usuario);
	    reserva.addVuelo(vuelo);
	    reserva.setImporte(49.99);
	    reserva.setNumAsientos(188);
	    reserva.setCodigo("RV034");
	    
		try {
			BasicConfigurator.configure();
			
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try {
				
				transaction = persistentManager.currentTransaction();
				transaction.begin();
			    
			    persistentManager.makePersistent(usuario);
			    persistentManager.makePersistent(vuelo);
			    persistentManager.makePersistent(vuelo2);
			    persistentManager.makePersistent(reserva);
			    
			    System.out.println("- Inserted into db: " + usuario.getNickname());
			    System.out.println("- Inserted into db: " + vuelo.getCodigoVuelo());
			    System.out.println("- Inserted into db: " + reserva.getCodigo());
			    
			    transaction.commit();
			    
			} catch(Exception ex) {
				System.err.println("Error insertando los datos en la BD: " + ex.getMessage());
			} finally {		    
				
				if (transaction != null && transaction.isActive()) {
					transaction.rollback();
				}

				if (persistentManager != null && !persistentManager.isClosed()) {
					persistentManager.close();
				}
			}
				
			try {
				//Selecionar datos usando Query
				persistentManager = persistentManagerFactory.getPersistenceManager();
				transaction = persistentManager.currentTransaction();
			    transaction.begin();
	
			    System.out.println("Seleccionando los vuelos con precio mayor que 150€");
			    
			    @SuppressWarnings("unchecked")
				Query<Vuelo> vuelosQuery = persistentManager.newQuery("SELECT * FROM " + Vuelo.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");
			    
			    @SuppressWarnings("unchecked")
				Collection<Vuelo> resultado = (Collection<Vuelo>)vuelosQuery.execute();
			    
			    Iterator<Vuelo> iterator = resultado.iterator();
			    while(iterator.hasNext()) {
			    	System.out.println("Vuelo: "+iterator.next().toString());
			    }
	
			    transaction.commit();
			    
			} catch(Exception ex) {
				System.err.println("Error seleccionando el vuelo: " + ex.getMessage());
			} finally {
				
				if (transaction != null && transaction.isActive()) {
					transaction.rollback();
				}

				if (persistentManager != null && !persistentManager.isClosed()) {
					persistentManager.close();
				}

			}
			
			try {
				//Actualizar la reserva
				persistentManager = persistentManagerFactory.getPersistenceManager();
				transaction = persistentManager.currentTransaction();
				transaction.begin();
				
				System.out.println("Actualizando reserva del vuelo "+reserva.getCodigo());
				
				Query<ReservaVuelo> reservaQuery = persistentManager.newQuery(ReservaVuelo.class);
				reservaQuery.setFilter("codigo = IB6722");
				
				transaction.commit();
				
			} catch (Exception ex) {
				System.err.println("Error actualizando la reserva: " + ex.getMessage());
			} finally {
				
				if(transaction != null && transaction.isActive()) {
					transaction.rollback();
				}
				if(persistentManager != null && !persistentManager.isClosed()) {
					persistentManager.close();
				}
			}
			
			try {
				//Borrando la reserva
				persistentManager = persistentManagerFactory.getPersistenceManager();
				transaction = persistentManager.currentTransaction();
				transaction.begin();
				
				System.out.println("Borrando la reserva: "+reserva.getCodigo());
				
				Query<ReservaVuelo> reservaQuery = persistentManager.newQuery(ReservaVuelo.class);
				reservaQuery.setFilter("codigo == 'RV034'");
				
				@SuppressWarnings("unchecked")
				Collection<ReservaVuelo> resultado = (Collection<ReservaVuelo>) reservaQuery.execute();
				
				Iterator<ReservaVuelo> iterator = resultado.iterator();
				while(iterator.hasNext()) {
					persistentManager.deletePersistent(iterator.next());
				}
				//Reserva borrada
				
				transaction.commit();
				
			} catch (Exception ex) {
				System.err.println("Error borrando reserva: " + ex.getMessage());
			} finally {
				
				if (transaction != null && transaction.isActive()) {
					transaction.rollback();
				}

				if (persistentManager != null && !persistentManager.isClosed()) {
					persistentManager.close();
				}
			}
		} catch (Exception ex) {
			System.err.println("* Exception: " + ex.getMessage());
		}
		
	}
}


