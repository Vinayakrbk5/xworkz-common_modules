package main.java.com.xworkz.modules.converter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;

@Component
public class ExcelToDTOConverterImpl implements ExcelToDTOConverter{
	public List<TempleRegistrationDTO> list = new ArrayList<>();

	public List<TempleRegistrationDTO> dtoConvertion(String fileName) {
		FileInputStream fileInput = null;
		XSSFWorkbook workbook = null;
		try {
			fileInput = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);

				String name = null;
				if (row.getCell(0) != null) {
					name = row.getCell(0).toString();
				}
				String mobileNumber = null;
				if (row.getCell(1) != null) {
					mobileNumber = row.getCell(1).toString();
				}
				String address = null;
				if (row.getCell(2) != null) {
					address = row.getCell(2).toString();
				}
				String age = null;
				if (row.getCell(3) != null) {
					age = row.getCell(3).toString();
				}
				String state = null;
				if (row.getCell(4) != null) {
					state = row.getCell(4).toString();
				}
				String emailId = null;
				if (row.getCell(5) != null) {
					emailId = row.getCell(5).toString();
				}
				String date = null;
				if (row.getCell(6) != null) {
					date = row.getCell(6).toString();
				}
				String noOfPeople = null;
				if (row.getCell(7) != null) {
					noOfPeople = row.getCell(7).toString();
				}
				String specialEntry = null;
				if (row.getCell(8) != null) {
					specialEntry = row.getCell(8).toString();
				}
				String prasad = null;
				if (row.getCell(9) != null) {
					prasad = row.getCell(9).toString();
				}
				String idCardType = null;
				if (row.getCell(10) != null) {
					idCardType = row.getCell(10).toString();
				}
				String poojaType = null;
				if (row.getCell(11) != null) {
					poojaType = row.getCell(11).toString();
				}
				TempleRegistrationDTO dto = new TempleRegistrationDTO();
				dto.setName(name);
				dto.setMobileNumber(mobileNumber);
				dto.setAddress(address);
				dto.setAge(Double.parseDouble(age));
				dto.setState(state);
				dto.setEmailId(emailId);
				dto.setDate(date);
				dto.setNoOfPeople(Double.parseDouble(noOfPeople));
				dto.setSpecialEntry(specialEntry);
				dto.setPrasad(prasad);
				dto.setIdCardType(idCardType);
				dto.setPoojaType(poojaType);
				list.add(dto);
				System.out.println("Data is : "+dto);
				
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	public void saveIntoExcel(TempleRegistrationDTO dto, String fileName) {
		System.out.println("Invoked saveIntoExcel() from the converter");
		System.out.println("Start : saveIntoExcel() method");
		FileInputStream fileInput = null;
		XSSFWorkbook workbook = null;
		FileOutputStream fileOutput = null;
		try {

			fileInput = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row;
			int j = sheet.getLastRowNum();
			row = sheet.createRow(j + 1);

			row.createCell(0).setCellValue(dto.getName());
			row.createCell(1).setCellValue(dto.getMobileNumber());
			row.createCell(2).setCellValue(dto.getAddress());
			row.createCell(3).setCellValue(dto.getAge());
			row.createCell(4).setCellValue(dto.getState());
			row.createCell(5).setCellValue(dto.getEmailId());
			row.createCell(6).setCellValue(dto.getDate());
			row.createCell(7).setCellValue(dto.getNoOfPeople());
			row.createCell(8).setCellValue(dto.getSpecialEntry());
			row.createCell(9).setCellValue(dto.getPrasad());
			row.createCell(10).setCellValue(dto.getIdCardType());
			row.createCell(11).setCellValue(dto.getPoojaType());

			fileOutput = new FileOutputStream(fileName);
			workbook.write(fileOutput);
			System.out.println("End : saveIntoExcel() method");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
