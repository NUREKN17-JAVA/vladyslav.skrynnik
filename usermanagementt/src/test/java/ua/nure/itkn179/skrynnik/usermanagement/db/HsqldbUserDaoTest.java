package ua.nure.itkn179.skrynnik.usermanagement.db;

import java.util.Calendar;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import java.util.Collection;

import ua.nure.itkn179.skrynnik.usermanagement.User;
import ua.nure.itkn179.skrynnik.usermanagement.db.ConnectionFactory;
import ua.nure.itkn179.skrynnik.usermanagement.db.ConnectionFactoryImplement;
import ua.nure.itkn179.skrynnik.usermanagement.db.DatabaseException;


public class HsqldbUserDaoTest extends DatabaseTestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	private static final String DRIVER = "org.hsqldb.jdbcDriver";
	private static final String URL = "jdbc:hsqldb:file:db/usermanagement";
	private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final long TEST_ID = 1000;
    private static final String TEST_LAST_NAME = "Withfunc";

	private static final String LAST_NAME = "Withoutfunc";
	private static final String FIRST_NAME = "Forma";
	private static final int YEAR = 2010;
	private static final int MONTH = 1;
	private static final int CREATE_DAY = 1;



	public void testCreate() throws DatabaseException {
		User user = new User();

		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR, MONTH, CREATE_DAY);
		user.setDateOfBirthd(calendar.getTime());
		assertNull(user.getId());
		User userToCheck = dao.create(user);
		assertNotNull(userToCheck);
		assertNotNull(userToCheck.getId());
		assertEquals(user.getFirstName(), userToCheck.getFirstName());
        assertEquals(user.getLastName(), userToCheck.getLastName());
        assertEquals(user.getDateOfBirthd(), userToCheck.getDateOfBirthd());

	}


	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao(connectionFactory);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testFindAll() throws DatabaseException {
        Collection<User> items = dao.findAll();
        assertNotNull("Collection is null", items);
        assertEquals("Collection size doesn't match.", 2, items.size());
    }
	public void testFind() throws DatabaseException {
        User userToCheck = dao.find(TEST_ID);
        assertNotNull(userToCheck);
        assertEquals(FIRST_NAME, userToCheck.getFirstName());
        assertEquals(LAST_NAME, userToCheck.getLastName());
    }
	public void testUpdate() throws DatabaseException {
		 User userToUpdate = dao.find(TEST_ID);
		 assertNotNull(userToUpdate);
		 userToUpdate.setLastName(TEST_LAST_NAME);
		 dao.update(userToUpdate);
		 User updatedUser = dao.find(TEST_ID);
		 assertEquals(updatedUser.getLastName(), TEST_LAST_NAME);
	 }
	public void testDelete() throws DatabaseException {
		User userToDelete = new User();
		userToDelete.setId(TEST_ID);
		dao.delete(userToDelete);
		assertNull(dao.find(TEST_ID));
    }


	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImplement(DRIVER, URL, USER, PASSWORD);
        return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new 	XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
				return dataSet;
	}

}