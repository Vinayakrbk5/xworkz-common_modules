package main.java.com.xworkz.modules.dto;

public class TempleDTO {
	
	private Integer id;
	private String name;
	private String value;
	private String type;
	
public TempleDTO() {
	System.out.println("Created "+this.getClass().getSimpleName());
	
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

@Override
public String toString() {
	return "TempleDTO [id=" + id + ", name=" + name + ", value=" + value + ", type=" + type + "]";
}



}
