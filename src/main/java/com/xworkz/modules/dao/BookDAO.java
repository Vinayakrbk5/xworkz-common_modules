package main.java.com.xworkz.modules.dao;

import main.java.com.xworkz.modules.entity.VisitingInfoEntity;

public interface BookDAO {
	
	public int saveVisitDetails(VisitingInfoEntity entity, String email);

}
