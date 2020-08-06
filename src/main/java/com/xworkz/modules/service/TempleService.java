package main.java.com.xworkz.modules.service;

import java.util.List;

import main.java.com.xworkz.modules.dto.TempleDTO;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;


public interface TempleService {
	
	public List<TempleDTO> validateAndFetchByType(String type);
	
	public boolean validateAndSave(TempleRegistrationDTO dto);
	
	public void validateAndSave(List<TempleRegistrationDTO> list);
	
	public List<TempleRegistrationDTO> validateAndThenToDtoConvertion(String fileName);
	
	public void validateAndSaveIntoExcel(TempleRegistrationDTO dto, String fileName);
	
	public long validateAndFetchEmailCount(String email);
	
	public long validateAndFetchPhoneNumberCount(String phoneNumber);
	
	public TempleRegistrationDTO validateAndGetVisitDetailsByEmail(String email);
	

}
