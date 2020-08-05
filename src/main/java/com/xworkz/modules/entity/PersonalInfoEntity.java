package main.java.com.xworkz.modules.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSONAL_INFO_TABLE")
@NamedQueries({@NamedQuery(name="fetchEmailCount",query = "select count(emailId) from PersonalInfoEntity where emailId=:email"),
	@NamedQuery(name="fetchPhoneNumberCount",query = "select count(mobileNumber) from PersonalInfoEntity where mobileNumber=:phone")})
public class PersonalInfoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PERSON_ID")
	private Integer personId;
	@Column(name="PERSON_NAME")
	private String name;
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="PERSON_AGE")
	private Double age;
	@Column(name="PERSON_STATE")
	private String state;
	@Column(name="PERSON_EMAIL")
	private String emailId;
	@Column(name="VISITING_DATE")
	private String date;
	
	@OneToOne(mappedBy ="personEntity" )
	private VisitingInfoEntity entity;
	
	public PersonalInfoEntity() {
		// TODO Auto-generated constructor stub
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
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

	public VisitingInfoEntity getEntity() {
		return entity;
	}

	public void setEntity(VisitingInfoEntity entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "PersonalInfoEntity [personId=" + personId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + ", age=" + age + ", state=" + state + ", emailId=" + emailId + ", date="
				+ date + ", entity=" + entity + "]";
	}

	
	

}
