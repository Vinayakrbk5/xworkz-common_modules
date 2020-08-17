package main.java.com.xworkz.modules.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSONAL_INFO_TABLE")
@NamedQueries({@NamedQuery(name="fetchEmailCount",query = "select count(emailId) from PersonalInfoEntity where emailId=:email"),
	@NamedQuery(name="fetchPhoneNumberCount",query = "select count(mobileNumber) from PersonalInfoEntity where mobileNumber=:phone"),
	@NamedQuery(name="fetchDetailsByEmailAndPassword",query = "select person from PersonalInfoEntity person where emailId=:email and password=:pass"),
	@NamedQuery(name="fetchPersonalDetailsByEmail",query = "select person from PersonalInfoEntity person where emailId=:email"),
	@NamedQuery(name="updatePasswordByEmailId",query = "update PersonalInfoEntity set password=:password where emailId=:email"),
	@NamedQuery(name="fetchByEmail",query = "select personal from PersonalInfoEntity personal where emailId=:email"),
	@NamedQuery(name="fetchLoginCountByEmail",query = "select loginCount from PersonalInfoEntity where emailId=:email"),
	@NamedQuery(name="updateLoginCountByEmail",query = "update PersonalInfoEntity set loginCount=:count where emailId=:email"),
	@NamedQuery(name="fetchDateByEmail", query = "select person.loginDate from PersonalInfoEntity person where emailId=:email"),
	@NamedQuery(name="updateDateByEmail",query = "Update PersonalInfoEntity set loginDate=:date where emailId=:email")})
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
	private Integer age;
	@Column(name="PERSON_STATE")
	private String state;
	@Column(name="PERSON_EMAIL")
	private String emailId;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="LOGIN_COUNT")
	private Integer loginCount;
	
	@Column(name="LOGIN_DATE")
	private Date loginDate;
	
	@OneToMany(mappedBy ="personEntity" )
	private List<VisitingInfoEntity> entity;
	
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
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

	public void setEmailId(String emailId) {// password
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<VisitingInfoEntity> getEntity() {
		return entity;
	}
	public void setEntity(List<VisitingInfoEntity> entity) {
		this.entity = entity;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Override
	public String toString() {
		return "PersonalInfoEntity [personId=" + personId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + ", age=" + age + ", state=" + state + ", emailId=" + emailId + ", password="
				+ password + ", loginCount=" + loginCount + ", entity=" + entity + "]";
	}

//	@Override
//	public String toString() {
//		return "PersonalInfoEntity [personId=" + personId + ", name=" + name + ", mobileNumber=" + mobileNumber
//				+ ", address=" + address + ", age=" + age + ", state=" + state + ", emailId=" + emailId + ", date="
//				+ date + ", entity=" + entity + "]";
//	}

	
	

}
