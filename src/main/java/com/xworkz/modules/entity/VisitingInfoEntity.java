package main.java.com.xworkz.modules.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VISITING_INFO_TABLE")
public class VisitingInfoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="VISIT_ID")
	private Integer visitId;
	@Column(name="VISITING_DATE")
	private String date;
	@Column(name="NO_OF_PEOPLE")
	private Double noOfPeople;
	@Column(name="SPECIAL_ENTRY_TYPE")
	private String specialEntry;
	@Column(name="PRASAD_TYPE")
	private String prasad;
	@Column(name="IDCARD_TYPE")
	private String idCardType;
	@Column(name="POOJA_TYPE")
	private String poojaType;
	
	@ManyToOne
	@JoinColumn(name="personId")
	private PersonalInfoEntity personEntity;
	
	public VisitingInfoEntity() {
		// TODO Auto-generated constructor stub
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
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

	public PersonalInfoEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonalInfoEntity personEntity) {
		this.personEntity = personEntity;
	}

	@Override
	public String toString() {
		return "VisitingInfoEntity [visitId=" + visitId + ", noOfPeople=" + noOfPeople + ", specialEntry="
				+ specialEntry + ", prasad=" + prasad + ", idCardType=" + idCardType + ", poojaType=" + poojaType
				+ ", personEntity=" + personEntity + "]";
	}

	
	
	

}
