package main.java.com.xworkz.modules.dao;

import java.util.List;

import main.java.com.xworkz.modules.entity.TempleEntity;

public interface TempleDAO {
	
	public List<TempleEntity> fetchByType(String type);

}
