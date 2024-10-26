
package bank.dto;

import java.time.LocalDate;

public class Registration {
    private String firstname;
    private String lastname;
    private String email;
    private String pwd;
    private String confirmpwd;
    private String address;
    private String gender;
    private String nationality;
    private long phone;
    private int age;
    private LocalDate dob;

	public Registration(String firstname, String lastname, String email, String pwd, String confirmpwd,
			String address, String gender, String nationality, long phone, int age, LocalDate dob) {
		    this.firstname = firstname;
	        this.lastname = lastname;
	        this.email = email;
	        this.pwd = pwd;
	        this.confirmpwd = confirmpwd;
	        this.address = address;
	        this.gender = gender;
	        this.nationality = nationality;
	        this.phone = phone;
	        this.age = age;
	        this.dob = dob;	
	}

	// Getters and setters
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getConfirmpwd() {
		return confirmpwd;
	}

	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Registration [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", pwd=" + pwd
				+ ", confirmpwd=" + confirmpwd + ", address=" + address + ", gender=" + gender + ", nationality="
				+ nationality + ", phone=" + phone + ", age=" + age + ", dob=" + dob + "]";
	}
	

}


