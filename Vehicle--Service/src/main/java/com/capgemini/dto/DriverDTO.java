
/*package com.capgemini.dto;

//Vehicle dependent driver details as Data transfer object
public class DriverDTO {

	private int driverId;
	private String firstName;
	private String lastName;
	private String address;
	private String mobileNumber;
	private String emailId;
	private String licenseNo;

	// No-argument constructor
	public DriverDTO() {
	}

	// Parameterized constructor
	public DriverDTO(int driverId, String firstName, String lastName, String address,
					 String mobileNumber, String emailId, String licenseNo) {
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.licenseNo = licenseNo;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
*/
package com.capgemini.dto;

//  dependent driver details as Data Transfer Object (DTO)
public class DriverDTO {

	private int driverId; // Unique identifier for the driver
	private String firstName; // Driver's first name
	private String lastName; // Driver's last name
	private String address; // Driver's address
	private String mobileNumber; // Driver's mobile number
	private String emailId; // Driver's email ID
	private String licenseNo; // Driver's license number

	// No-argument constructor
	public DriverDTO() {
	}

	// Parameterized constructor
	public DriverDTO(int driverId, String firstName, String lastName, String address,
					 String mobileNumber, String emailId, String licenseNo) {
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.licenseNo = licenseNo;
	}
	//getters and setters

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
