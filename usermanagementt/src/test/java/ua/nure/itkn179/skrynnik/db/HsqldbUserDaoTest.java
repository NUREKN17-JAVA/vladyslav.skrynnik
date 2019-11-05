package ua.nure.itkn179.skrynnik.db;

import java.util.Calendar;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import ua.nure.itkn179.skrynnik.usermanagement.User;
import ua.nure.itkn179.skrynnik.usermanagement.db.ConnectionFactory;
import ua.nure.itkn179.skrynnik.usermanagement.db.ConnectionFactoryImplement;
import ua.nure.itkn179.skrynnik.usermanagement.db.DatabaseException;
import ua.nure.itkn179.skrynnik.usermanagement.db.HsqldbUserDao;

public class HsqldbUserDaoTest extends DatabaseTestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;


	private static final String LAST_NAME = "Forma";
	private static final String FIRST_NAME = "Withoutfunc";
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

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImplement();
        return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new 	XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
				return dataSet;
	}

}