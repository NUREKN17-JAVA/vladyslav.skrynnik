package ua.nure.itkn179.skrynnik.usermanagement;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {
	
	private static final long serialVersionUID = -2067735433648560430L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirthd;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirthd() {
		return dateOfBirthd;
	}
	public void setDateOfBirthd(Date dateOfBirthd) {
		this.dateOfBirthd = dateOfBirthd;
	}
	public Object getFullName() {

		return getLastName() + " , " + getFirstName();
	}
	 public int getAge() {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(new Date());
	        int currentYear = calendar.get(Calendar.YEAR);
	        int currentMonth = calendar.get(Calendar.MONTH);
	        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
	        calendar.setTime(getDateOfBirthd());
	        int year = calendar.get(Calendar.YEAR);
	        int month = calendar.get(Calendar.MONTH);
	        int day = calendar.get(Calendar.DAY_OF_MONTH);

	        int age = currentYear - year;
	        if ( (currentMonth < month) || (currentMonth == month && currentDay < day))
	            age--;
	        return age;
	    }
	
}
