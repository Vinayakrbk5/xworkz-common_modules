package main.java.com.xworkz.modules.service;

import java.util.List;

import main.java.com.xworkz.modules.entity.TempleEntity;

public interface TempleService {
	
	public List<TempleEntity> validateFetchByType(String type);

}
