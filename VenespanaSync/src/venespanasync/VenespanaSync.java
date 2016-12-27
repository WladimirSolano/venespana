package venespanasync;

import java.util.Iterator;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import venespanasync.hibernate.model.Customer;





/**
 *
 * @author Lasar-Soporte
 */
public class VenespanaSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
            /*DatabaseUtil.setIsHibernate(true);
            DatabaseUtil.setDbType(DatabaseUtil.MARIADB);
            DatabaseUtil.setHost("190.9.44.82");
            DatabaseUtil.setDbPort("3306");
            DatabaseUtil.setUsername("venespan_ocar341");
            DatabaseUtil.setPassword("DMp8gS61@-");      
            DatabaseUtil.openDatabase();
            EntityManager em = DatabaseUtil.getCurrentEntityManager();
            System.out.println("Is Open " + em.isOpen());*/ 
                
            Session session = new Configuration().configure("hibernateMySQL.cfg.xml").buildSessionFactory().openSession();             
            
            System.out.println(session.isOpen());                                 
            
            Query query = session.createQuery("FROM Customer");
            
            List result = query.list();
            
            for (int i = 0; i < result.size(); i++){
                Customer customer = (Customer) result.get(i);
                System.out.println("Customer " + customer.getFirstname() + " " + customer.getLastname());
            }
            
            session.close();
            
            System.out.println(session.isOpen());
       
        
    }    
}
