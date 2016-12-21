/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venespanasync.hibernate.util;

import javax.persistence.EntityManager;
import org.hibernate.HibernateException;

/**
 *
 * @author henry
 */
public class DatabaseUtil {

    public static final int MSSQL = 0;
    public static final int MYSQL = 1;
    public static final int MARIADB = 1;
    public static final int POSTGRESQL = 2;
    public static final int POSTGRESQLSSL = 3;
    public static final int POSTGRESQLSSLNOVEF = 4;
    public static final int H2DATABASE = 5;
    public static final int H2DATABASEEMBEDDED = 6;
    public static final int H2DATABASEMEMORY = 7;

    private static boolean isHibernate = true;
    private static int dbType = MYSQL;
    private static String host = "190.9.44.82";
    private static String dbName = "venespan_ocar341";
    private static String dbPort = "3306";
    private static String username = "venespan_ocar341";
    private static String password = "DMp8gS61@-";

    private static boolean isOpen = false;

    final static Class[] CLASSES_LIST = new Class[]{
       
    };

    public static void openDatabase() throws HibernateException {
        if (!isOpen) {
            if (isHibernate) {
                HibernateUtil.setDbType(dbType);
                HibernateUtil.setUser(username);
                HibernateUtil.setPwd(password);
                HibernateUtil.setServerUrl(host, dbPort, dbName);
                HibernateUtil.getSession().close();
            } else {
                OpenJPAUtil.setDbType(dbType);
                OpenJPAUtil.setUser(username);
                OpenJPAUtil.setPwd(password);
                OpenJPAUtil.setServerUrl(host, dbPort, dbName);
                OpenJPAUtil.getCurrentEntityManager();
            }
            isOpen = true;
        }
    }

    public static EntityManager getEntityManager() throws HibernateException {
        openDatabase();
        if (isHibernate) {
            return HibernateUtil.getSession();
        } else {
            return OpenJPAUtil.getEntityManager();
        }
    }

    public static EntityManager getCurrentEntityManager() {
        openDatabase();
        if (isHibernate) {
            return HibernateUtil.getCurrentSession();
        } else {
            return OpenJPAUtil.getCurrentEntityManager();
        }
    }

    public static boolean isIsHibernate() {
        return isHibernate;
    }

    public static void setIsHibernate(boolean isHibernate) {
        DatabaseUtil.isHibernate = isHibernate;
    }

    public static int getDbType() {
        return dbType;
    }

    public static void setDbType(int dbType) {
        DatabaseUtil.dbType = dbType;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DatabaseUtil.host = host;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        DatabaseUtil.dbName = dbName;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DatabaseUtil.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DatabaseUtil.password = password;
    }

    public static String getDbPort() {
        return dbPort;
    }

    public static void setDbPort(String dbPort) {
        DatabaseUtil.dbPort = dbPort;
    }

}
