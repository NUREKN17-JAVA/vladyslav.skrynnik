package ua.nure.itkn179.skrynnik.usermanagement;

import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;



public class UserTest extends TestCase {
	
	private static final int CURRENT_YEAR = 2019;
	private static final int YEAR_OF_BIRTH = 2000;
	
	
	// Когда день рождения прошел но месяц еще идет.
	private static final int ETALON_AGE1 = CURRENT_YEAR - YEAR_OF_BIRTH;
	private static final int DAY_OF_BIRTH1 = 1;
	private static final int MONTH_OF_BIRTH1 = Calendar.OCTOBER;
	
	
	//Когда месяц рождения прошел.
	private static final int ETALON_AGE2 = CURRENT_YEAR - YEAR_OF_BIRTH;
	private static final int DAY_OF_BIRTH2= 1;
	private static final int MONTH_OF_BIRTH2 = Calendar.SEPTEMBER;
	
	//День рождения сегодня.
	private static final int ETALON_AGE3 = CURRENT_YEAR - YEAR_OF_BIRTH;
	private static final int DAY_OF_BIRTH3 = 8;
	private static final int MONTH_OF_BIRTH3 = Calendar.OCTOBER;
	
	//День рождения будет в этом месяце
	private static final int ETALON_AGE4 = CURRENT_YEAR - YEAR_OF_BIRTH - 1;
	private static final int DAY_OF_BIRTH4 = 12;
	private static final int MONTH_OF_BIRTH4 = Calendar.OCTOBER;
	
	//Месяц рождения ещё не настал.
	
	private static final int ETALON_AGE5 = CURRENT_YEAR - YEAR_OF_BIRTH - 1;
	private static final int DAY_OF_BIRTH5 = 8;
	private static final int MONTH_OF_BIRTH5 = Calendar.NOVEMBER;
	
	
	
	
	private User user;
	private Date dateOfBirthd;

	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, Calendar.FEBRUARY, 26);
		dateOfBirthd = calendar.getTime();
	}
	
	public void testGetFullName() {
		user.setFirstName("John");
		user.setLastName("Doe");
		assertEquals("Doe , John", user.getFullName());
	}
	
	public void testGetAge1() {
		 Calendar calendar = Calendar.getInstance();
	        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH1, DAY_OF_BIRTH1);
	        dateOfBirthd = calendar.getTime();
	        user.setDateOfBirthd(dateOfBirthd);
	        assertEquals(ETALON_AGE1, user.getAge());
	}
	public void testGetAge2() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH2, DAY_OF_BIRTH2);
        dateOfBirthd = calendar.getTime();
        user.setDateOfBirthd(dateOfBirthd);
        assertEquals(ETALON_AGE2, user.getAge());
    }
	
	public void testGetAge3() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH3, DAY_OF_BIRTH3);
        dateOfBirthd = calendar.getTime();
        user.setDateOfBirthd(dateOfBirthd);
        assertEquals(ETALON_AGE3, user.getAge());
    }
	
	public void testGetAge4 () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH4, DAY_OF_BIRTH4);
        dateOfBirthd = calendar.getTime();
        user.setDateOfBirthd(dateOfBirthd);
        assertEquals(ETALON_AGE4, user.getAge());
    }
	
	public void testGetAge5() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH, MONTH_OF_BIRTH5, DAY_OF_BIRTH5);
        dateOfBirthd = calendar.getTime();
        user.setDateOfBirthd(dateOfBirthd);
        assertEquals(ETALON_AGE5, user.getAge());
    }

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
