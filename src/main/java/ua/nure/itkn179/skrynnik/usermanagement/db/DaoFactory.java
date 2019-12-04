package main.java.ua.nure.itkn179.skrynnik.usermanagement.db;

import main.java.ua.nure.itkn179.skrynnik.usermanagement.User;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
    public void init(Properties properties){
        properties = new Properties();
    }
    private static Properties properties;
    static{
        properties = new Properties();
        try {
            properties.load(DaoFactory.class.getResourceAsStream(
                    "settings.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String USER = "connection.user";
    private static final String PASSWORD = "connection.password";
    private static final String URL = "connection.url";
    private static final String DRIVER = "connection.driver";
    private static final String HSQLDB_USER_DAO = "dao.UserDao";

    private final static DaoFactory INSTANCE = new DaoFactory();


    private static final String DAO_FACTORY = "dao.factory";
    private static DaoFactory instance;
    public DaoFactory() {

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static synchronized DaoFactory getInstance() {
        if (instance == null){
            try {
                Class factoryClass = Class.forName(properties.getProperty(DAO_FACTORY));
                instance = (DaoFactory) factoryClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
    private ConnectionFactory getConnectionFactory() {
        String user = properties.getProperty(USER);
        String password = properties.getProperty(PASSWORD);
        String url = properties.getProperty(URL);
        String driver = properties.getProperty(DRIVER);

        return new ConnectionFactoryImplement(user, password, url, driver);
    }

    @SuppressWarnings("unchecked")
    public UserDao.Dao<User> getUserDao() {
        UserDao.Dao<User> result = null;
        try {
            Class<?> hsqldbUserDaoClass = Class.forName(properties.getProperty(HSQLDB_USER_DAO));
            result = (UserDao.Dao<User>) hsqldbUserDaoClass.newInstance();
            result.setConnectionFactory(getConnectionFactory());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return result;
    }

}