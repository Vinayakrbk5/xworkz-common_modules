package main.java.com.xworkz.modules.converter;

import java.util.List;

import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;

public interface ExcelToDTOConverter {

	
	public List<TempleRegistrationDTO> dtoConvertion(String fileName);
	
	public void saveIntoExcel(TempleRegistrationDTO dto, String fileName);
	
}
