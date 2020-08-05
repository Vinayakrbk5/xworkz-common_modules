package main.java.com.xworkz.modules.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.xworkz.modules.converter.ExcelToDTOConverter;
import main.java.com.xworkz.modules.dao.TempleDAO;
import main.java.com.xworkz.modules.dto.TempleDTO;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;
import main.java.com.xworkz.modules.entity.PersonalInfoEntity;
import main.java.com.xworkz.modules.entity.VisitingInfoEntity;

@Service
public class TempleServiceImpl implements TempleService {
	private Logger logger = Logger.getLogger(TempleServiceImpl.class);

	@Autowired
	private TempleDAO dao;
	@Autowired
	private ExcelToDTOConverter converter;
	@Autowired
	private EmailService eService;

	@Override
	public List<TempleDTO> validateAndFetchByType(String type) {
		try {
			logger.info("Start : Serice");
			List<TempleDTO> list = null;
			if (Objects.nonNull(type) && !type.isEmpty()) {
				logger.info("type is valid");
				list = dao.fetchByType(type);
				logger.info("End : Service");
				return list;
			} else {
				logger.warn("type is invalid");
			}

		} catch (Exception e) {
			logger.error("Something went wrong in Service", e);
		}
		return null;
	}

	@Override
	public boolean validateAndSave(TempleRegistrationDTO dto) {
		try {
			logger.info("Start : validateAndSave() method in ServiceImpl");
			
			long emailCount = validateAndFetchEmailCount(dto.getEmailId());
			long phoneNumberCount = validateAndFetchPhoneNumberCount(dto.getMobileNumber());
			
			if (emailCount==0 && phoneNumberCount==0) {
				PersonalInfoEntity personEntity = new PersonalInfoEntity();
				VisitingInfoEntity visitingEntity = new VisitingInfoEntity();
				BeanUtils.copyProperties(dto, personEntity);
				BeanUtils.copyProperties(dto, visitingEntity);
				logger.info("Person Entity :" + personEntity);
				logger.info("Visiting entity :" + visitingEntity);
				personEntity.setEntity(visitingEntity);
				visitingEntity.setPersonEntity(personEntity);
				dao.save(personEntity, visitingEntity);
				logger.info("Now going to send details to email");
				eService.sendRegisterSuccessEmail(dto);
				logger.info("Sending to email is success");
				logger.info("End : validateAndSave() method in ServiceImpl");
				return true;
			}
			else
			{
				logger.info("EmailId or phone Number already Exists");
				return false;
			}
			
			
		} catch (Exception e) {
			logger.error("Something went wrong in validateAndSave() method in serviceImpl",e);
		}
		return false;

	}

	@Override
	public void validateAndSave(List<TempleRegistrationDTO> list) {

		try {
			for (TempleRegistrationDTO dto : list) {
				PersonalInfoEntity personEntity = new PersonalInfoEntity();
				VisitingInfoEntity visitingEntity = new VisitingInfoEntity();
				BeanUtils.copyProperties(dto, personEntity);
				BeanUtils.copyProperties(dto, visitingEntity);
				personEntity.setEntity(visitingEntity);
				visitingEntity.setPersonEntity(personEntity);
				dao.save(visitingEntity, personEntity);
			}
		} catch (Exception e) {
			logger.error("Something went wrong in validateAndSave(list) method in ServiceImpl",e);
		}
	}

	@Override
	public List<TempleRegistrationDTO> validateAndThenToDtoConvertion(String fileName) {
		try {
			logger.info("Invoked validateAndThenToDtoConvertion() method from ServiceImpl");
			List<TempleRegistrationDTO> list = new ArrayList<>();
			if (fileName != null && !fileName.isEmpty()) {
				logger.info("file name is valid, sio we can save");
				list = converter.dtoConvertion(fileName);
				return list;
			} else {
				logger.warn("file name is not valid, so we cannot save");
			}
		} catch (Exception e) {
			logger.error("Something went wrong in serviceImpl", e);
		}
		return null;
	}

	@Override
	public void validateAndSaveIntoExcel(TempleRegistrationDTO dto, String fileName) {
		try {
			if (Objects.nonNull(dto)) {
				logger.info("dto is valid");
				if (Objects.nonNull(fileName) && !fileName.isEmpty()) {
					logger.info("File name is valid ");
					converter.saveIntoExcel(dto, fileName);
				} else {
					logger.warn("File name is not valid , so we cannot save into excel sheet");
				}
			} else {
				logger.warn("dti is not valid, so we cannot save into excel sheet");
			}

		} catch (Exception e) {
			logger.error("Something went wrong in serviceImpl", e);
		}

	}

	@Override
	public long validateAndFetchEmailCount(String email) {
		try {

			if (Objects.nonNull(email)) {
				logger.info("Email is valid");
				long emailCount = dao.fetchEmailCount(email);
				return emailCount;
			} else {
				logger.warn("Email is not valid");
			}

		} catch (Exception e) {
			logger.error("Something went wrong in validateAndFetchEmailCount() method in ServiceImpl");;
		}
		return 0;
	}

	@Override
	public long validateAndFetchPhoneNumberCount(String phoneNumber) {
		try {
			if (Objects.nonNull(phoneNumber)) {
				logger.info("Phone Number is valid");
				long numberCount = dao.fetchPhoneNumberCount(phoneNumber);
				return numberCount;

			} else {
				logger.warn("Phone number is invalid");
			}

		} catch (Exception e) {
			logger.error("Something went wrong in validateAndFetchPhoneNumberCount() method ServiceImpl");
		}
		return 0;
	}

}