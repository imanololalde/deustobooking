package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		
		java.util.Date date=new java.util.Date();  
		
		

		Aeropuerto salida = new Aeropuerto("BIO","España","Bilbao","Aeropuerto de Loiu");
	   
	    
	    Aeropuerto llegada = new Aeropuerto("BCN","España","Barcelona","Aeropuerto El Prat");
	    
	   
	    
	    Usuario usuario = new Usuario("","",0);
	    usuario.setNombre("Livio");
	    usuario.setSisAutorizacion(1);
	    usuario.setEmail("liviocuratolo@opendeusto.es");
	    ArrayList<Usuario> todosU =new ArrayList<Usuario>();
	    todosU.add(usuario);
	    
	    String[] nombres = new String[todosU.size()];
	    for(int i=0; i<todosU.size();i++) {
	    	nombres[i]=todosU.get(i).getNombre();
	    }
	    Vuelo vuelo = new Vuelo("IB6789",date,120,240,"12:00","14:00",120.00,salida,llegada);
	    
	    Vuelo vuelo2 = new Vuelo("VL7845",date,100,240,"18:00","20:00",100.00,llegada,salida);
	    
	    ArrayList<Vuelo> todosV = new ArrayList<Vuelo>();
	    todosV.add(vuelo);
	    todosV.add(vuelo2);
	    
	    
	    ReservaVuelo reserva = new ReservaVuelo("RV034",188,49.99,date,nombres.length,nombres,todosU,todosV	);
	 
	    
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
			    
			    System.out.println("- Inserted into db: " + usuario.getSisAutorizacion());
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
