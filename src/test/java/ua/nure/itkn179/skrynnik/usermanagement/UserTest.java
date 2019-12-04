package test.java.ua.nure.itkn179.skrynnik.usermanagement;

import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;
import main.java.ua.nure.itkn179.skrynnik.usermanagement.User;


public class UserTest extends TestCase {

    private static final int CURRENT_YEAR = 2019;
    private static final int YEAR_OF_BIRTH = 2000;



    private static final int ETALON_AGE1 = CURRENT_YEAR - YEAR_OF_BIRTH;
    private static final int DAY_OF_BIRTH1 = 1;
    private static final int MONTH_OF_BIRTH1 = Calendar.SEPTEMBER;



    private static final int ETALON_AGE2 = CURRENT_YEAR - YEAR_OF_BIRTH;
    private static final int DAY_OF_BIRTH2= 2;
    private static final int MONTH_OF_BIRTH2 = Calendar.SEPTEMBER;


    private static final int ETALON_AGE3 = CURRENT_YEAR - YEAR_OF_BIRTH;
    private static final int DAY_OF_BIRTH3 = 3;
    private static final int MONTH_OF_BIRTH3 = Calendar.NOVEMBER;


    private static final int ETALON_AGE4 = CURRENT_YEAR - YEAR_OF_BIRTH ;
    private static final int DAY_OF_BIRTH4 = 3;
    private static final int MONTH_OF_BIRTH4 = Calendar.FEBRUARY;



    private static final int ETALON_AGE5 = CURRENT_YEAR - YEAR_OF_BIRTH ;
    private static final int DAY_OF_BIRTH5 = 7;
    private static final int MONTH_OF_BIRTH5 = Calendar.OCTOBER;




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