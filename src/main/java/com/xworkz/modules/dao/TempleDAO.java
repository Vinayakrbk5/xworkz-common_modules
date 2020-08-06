package main.java.com.xworkz.modules.dao;

import java.util.List;

import main.java.com.xworkz.modules.dto.TempleDTO;
import main.java.com.xworkz.modules.entity.PersonalInfoEntity;
import main.java.com.xworkz.modules.entity.VisitingInfoEntity;


public interface TempleDAO {
	
	public List<TempleDTO> fetchByType(String type);
	
	public void save(PersonalInfoEntity entity1,VisitingInfoEntity entity2);
	
	public void save(VisitingInfoEntity vEntity,PersonalInfoEntity pEntity);
	
	public long fetchEmailCount(String email);

	public long fetchPhoneNumberCount(String phoneNumber);
	
	public VisitingInfoEntity fetchVisitDetailsByEmail(String email);

}
