package main.java.com.xworkz.modules.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="APP_PROP_TABLE")
@NamedQueries({@NamedQuery(name="fetchByType", query = "select temple from TempleEntity temple where type=:type")})
public class TempleEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="PROP_ID")
	private Integer id;
	@Column(name="PROP_NAME")
	private String name;
	@Column(name="PROP_VALUE")
	private String value;
	@Column(name="PROP_TYPE")
	private String type;
	
//	private Logger logger=Logger.getLogger(TempleEntity.class);
	
	public TempleEntity() {
//		logger.info("Created "+this.getClass().getSimpleName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TempleEntity [id=" + id + ", name=" + name + ", value=" + value + ", type=" + type + "]";
	}
	
	

}
