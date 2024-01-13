package FINAL;

public class AdminUserLogIn implements Login{
	private static String ADMIN_USERNAME = "admin";
	private static String ADMIN_PASSWORD = "admin123";
	private String fname;
	private String lname;
	private Long number;
	private String address;
	private String payment;
	
	//setters
	void setFname(String fname) {
		this.fname = fname;
	}
	void setLname(String lname) {
		this.lname = lname;
	}
	void setNumber(Long number) {
		this.number = number;
	}
	void setAddress(String address) {
		this.address = address;
	}
	void setPayment(String payment) {
		this.payment = payment;
	}
	//getters
	String getFname() {
		return this.fname;
	}
	String getLname() {
		return this.lname;
	}
	Long getNumber() {
		return this.number;
	}
	String getAddress() {
		return this.address;
	}
	String getPayment() {
		return this.payment;
	}

	@Override
	public boolean aunthenticateAdmin(String username, String password) {
		return ( username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD));
	}
}
