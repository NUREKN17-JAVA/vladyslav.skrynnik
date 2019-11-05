package ua.nure.itkn179.skrynnik.usermanagement.db;

import junit.framework.TestCase;
import ua.nure.itkn179.skrynnik.usermanagement.User;



public class DaoFactoryTest extends TestCase {
	public void testUserDao() {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            assertNotNull("Dao factory instance is null", daoFactory);
            Dao<User> dao = daoFactory.getUserDao();
            assertNotNull("UserDao instance is null", dao);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

}
