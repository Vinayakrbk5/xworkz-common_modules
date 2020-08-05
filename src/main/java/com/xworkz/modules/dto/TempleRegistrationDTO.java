package main.java.com.xworkz.modules.dto;

import org.apache.log4j.Logger;

public class TempleRegistrationDTO {
	
	private String name;
	private String mobileNumber;
	private String address;
	private Double age;
	private String state;
	private String emailId;
	private String date;
	private Double noOfPeople;
	private String specialEntry;
	private String prasad;
	private String idCardType;
	private String poojaType;
	private static final Logger logger=Logger.getLogger(TempleRegistrationDTO.class);
	
	public TempleRegistrationDTO() {
		logger.info("Created "+this.getClass().getSimpleName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(Double noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getSpecialEntry() {
		return specialEntry;
	}

	public void setSpecialEntry(String specialEntry) {
		this.specialEntry = specialEntry;
	}

	public String getPrasad() {
		return prasad;
	}

	public void setPrasad(String prasad) {
		this.prasad = prasad;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getPoojaType() {
		return poojaType;
	}

	public void setPoojaType(String poojaType) {
		this.poojaType = poojaType;
	}

	@Override
	public String toString() {
		return "TempleRegistrationDTO [name=" + name + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", age=" + age + ", state=" + state + ", emailId=" + emailId + ", date=" + date + ", noOfPeople="
				+ noOfPeople + ", specialEntry=" + specialEntry + ", prasad=" + prasad + ", idCardType=" + idCardType
				+ ", poojaType=" + poojaType + "]";
	}
	

}
