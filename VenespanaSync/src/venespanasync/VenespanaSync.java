package venespanasync;

import javax.persistence.EntityManager;
import org.hibernate.criterion.CriteriaQuery;
import venespanasync.hibernate.util.DatabaseUtil;

/**
 *
 * @author Lasar-Soporte
 */
public class VenespanaSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseUtil.setIsHibernate(true);
        DatabaseUtil.setDbType(DatabaseUtil.MARIADB);
        DatabaseUtil.setHost("190.9.44.82");
        DatabaseUtil.setDbPort("3306");
        DatabaseUtil.setUsername("venespan_ocar341");
        DatabaseUtil.setPassword("DMp8gS61@-");      
        DatabaseUtil.openDatabase();
        EntityManager em = DatabaseUtil.getCurrentEntityManager();
        System.out.println("Is Open " + em.isOpen());
    }    
}
