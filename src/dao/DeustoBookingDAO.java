package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import datos.ReservaVuelo;
import datos.Usuario;

public class DeustoBookingDAO {
	private PersistenceManagerFactory factory;

	public DeustoBookingDAO() {
		factory = JDOHelper.getPersistenceManagerFactory("datanucleus.proterties");
	}

	public void registrarUsuario(Usuario u) {
		PersistenceManager persman = factory.getPersistenceManager();
		Transaction tr = persman.currentTransaction();

		try {
			tr.begin();
			System.out.println("   * Guardando un objeto: " + u.getNombre());
			persman.makePersistent(u);
			tr.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error guardando un objeto: " + ex.getMessage());
		} finally {
			if (tr != null && tr.isActive()) {
				tr.rollback();
			}

			persman.close();
		}
	}
	
	public void storeReservaVuelo(ReservaVuelo rv) {
		// TODO Auto-generated method stub
		PersistenceManager pm = factory.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing an object: " + rv.getCodigo());
	       pm.makePersistent(rv);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing an object: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}
	
	public Usuario getUsuario(String nombre) {
		// TODO Auto-generated method stub
		PersistenceManager persman = factory.getPersistenceManager();
		persman.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tr = persman.currentTransaction();
		Usuario resultado = null;
	    
		try {
			System.out.println ("   * Querying a Product: " + nombre);
			
	    	tr.begin();
	    	Query<?> query = persman.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE nombre == '" + nombre + "'");
	    	query.setUnique(true);
	    	resultado = (Usuario)query.execute();	    
 	    	tr.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tr != null && tr.isActive()) {
		   		tr.rollback();
		 }
				
	   		persman.close();
	     }

	    return resultado;
	}
	
	public List<ReservaVuelo> getReservatios(Usuario u) {
		// TODO Auto-generated method stub
		PersistenceManager persman = factory.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		persman.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tr = persman.currentTransaction();
		List<ReservaVuelo> rv = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tr.begin();			
			Extent<ReservaVuelo> extent = persman.getExtent(ReservaVuelo.class, true);
			
			for (ReservaVuelo ReservaVuelo : extent) {
				rv.add(ReservaVuelo);
			}

			tr.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tr != null && tr.isActive()) {
	    		tr.rollback();
	    	}

    		persman.close();    		
	    }
	    				
		return rv;
	}
	
}
