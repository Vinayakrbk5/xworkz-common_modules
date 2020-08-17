package main.java.com.xworkz.modules.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.xworkz.modules.converter.ExcelToDTOConverter;
import main.java.com.xworkz.modules.dao.TempleDAO;
import main.java.com.xworkz.modules.dataencryptanddecrypt.EncryptAndDecryptData;
import main.java.com.xworkz.modules.datechecking.CalculateTotalHours;
import main.java.com.xworkz.modules.dto.TempleDTO;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;
import main.java.com.xworkz.modules.entity.PersonalInfoEntity;
import main.java.com.xworkz.modules.entity.VisitingInfoEntity;
import main.java.com.xworkz.modules.passwordgenerator.RandomPasswordGenerator;

@Service
public class TempleServiceImpl implements TempleService {
	private Logger logger = Logger.getLogger(TempleServiceImpl.class);

	@Autowired
	private TempleDAO dao;
	@Autowired
	private ExcelToDTOConverter converter;
	@Autowired
	private EmailService eService;

	@Autowired
	private EncryptAndDecryptData encAndDec;

	@Autowired
	private RandomPasswordGenerator generator;
	
	@Autowired
	private CalculateTotalHours totalHour;

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
			Date newDate = new Date();
			long emailCount = validateAndFetchEmailCount(dto.getEmailId());
			long phoneNumberCount = validateAndFetchPhoneNumberCount(dto.getMobileNumber());

			if (emailCount == 0 && phoneNumberCount == 0) {
				PersonalInfoEntity personEntity = new PersonalInfoEntity();
				VisitingInfoEntity visitingEntity = new VisitingInfoEntity();
				List<VisitingInfoEntity> list=new ArrayList<>();
				BeanUtils.copyProperties(dto, personEntity);
				BeanUtils.copyProperties(dto, visitingEntity);
				list.add(visitingEntity);
				logger.info("Person Entity :" + personEntity);
				personEntity.setLoginCount(0);
				personEntity.setLoginDate(newDate);
				logger.info("Visiting entity :" + visitingEntity);
				personEntity.setEntity(list);
				visitingEntity.setPersonEntity(personEntity);
				dao.save(personEntity, list.get(0));
				logger.info("Now going to send details to email");
				eService.sendRegisterSuccessEmail(dto);
				logger.info("Sending to email is success");
				logger.info("End : validateAndSave() method in ServiceImpl");
				return true;
			} else {
				logger.info("EmailId or phone Number already Exists");
				return false;
			}

		} catch (Exception e) {
			logger.error("Something went wrong in validateAndSave() method in serviceImpl", e);
		}
		return false;

	}

	@Override
	public void validateAndSave(List<TempleRegistrationDTO> list) {

		try {
			for (TempleRegistrationDTO dto : list) {
				PersonalInfoEntity personEntity = new PersonalInfoEntity();
				VisitingInfoEntity visitingEntity = new VisitingInfoEntity();
				List<VisitingInfoEntity> list1=new ArrayList<>();
				BeanUtils.copyProperties(dto, personEntity);
				BeanUtils.copyProperties(dto, visitingEntity);
				list1.add(visitingEntity);
				personEntity.setEntity(list1);
				visitingEntity.setPersonEntity(personEntity);
				dao.save(list1.get(0), personEntity);
			}
		} catch (Exception e) {
			logger.error("Something went wrong in validateAndSave(list) method in ServiceImpl", e);
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
			logger.error("Something went wrong in validateAndFetchEmailCount() method in ServiceImpl");
			;
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

	@Override
	public TempleRegistrationDTO validateAndGetVisitDetailsByEmail(String email) {
		logger.info("Invoked validateAndGetVisitDetailsByEmail() method from ServiceImpl");
		logger.info("Start : processing validateAndGetVisitDetailsByEmail() from ServiceImpl");
		TempleRegistrationDTO dto = new TempleRegistrationDTO();
		VisitingInfoEntity vEntity = new VisitingInfoEntity();
		try {
			if (Objects.nonNull(email) && !email.isEmpty()) {
				logger.info("Email is valid");
				vEntity = dao.fetchVisitDetailsByEmail(email);
				if (vEntity != null) {
					logger.info("Visiting entity is not null,so we can copy");
					BeanUtils.copyProperties(vEntity, dto);
				} else {
					logger.info("Visiting entity is null,so we cannot copy");
					dto = null;
				}

			} else {
				logger.info("Email is not valid");
				dto = null;
			}
			logger.info("End : processing validateAndGetVisitDetailsByEmail() from ServiceImpl");

		} catch (Exception e) {
			logger.error("Something went wrong in validateAndGetVisitDetailsByEmail() method in ServiceImpl", e);
			;
		}
		return dto;
	}

	@Override
	public String validateAndfetchDetailsByEmailAndPasswod(String email, String password) {
		int count = 0, reset = 0;
		String valid = null;
		try {
			PersonalInfoEntity pEntity = new PersonalInfoEntity();   // creating object of PersonalInfoEntity class
			
			if (Objects.nonNull(email) && !email.isEmpty() && Objects.nonNull(password) && !password.isEmpty()) {
				logger.info("Both password and email are valid");
				String encPassword = encAndDec.encryptData(password);  // getting encrypted password for a given password
				logger.info("Password is : " + password);
				logger.info("Encrypted password is : " + encPassword);
				pEntity = dao.fetchPersonalDetailsByEmail(email);  //  fetching personal details by Email
				
				if (pEntity != null) {
					count = validateAndFetchLoginCountByEmail(email);  // fetching loginCount from DB
					Date getDate = new Date();
					getDate = dao.fetchDateByEmail(email);    //  fetching login date and time saving into getDate
					Date curDate = new Date();  // this is current Date

//					int hourDiff = (curDate.getDate() - 1) * 24 + curDate.getHours()  // calculating total hour difference between
//					- ((getDate.getDate() - 1) * 24 + getDate.getHours()); 			  // curdate and getdate
					
					int hourDiff=totalHour.retunTotalHour(curDate)-totalHour.retunTotalHour(getDate);
					
					if (hourDiff >= 24) {
						validateAndUpdateLoginCountByEmail(email, reset);        // resetting count to '0' in DB
						valid = returnLoginStatusByEmailAndPassword(email, encPassword, count);       // returning login status
																								 
						dao.updateDateByEmail(email, curDate);         // resetting date to current date in DB
					} 
					else if (hourDiff < 24 && count < 3) {
						valid = returnLoginStatusByEmailAndPassword(email, encPassword, count);     // returning login status
					} 
					else {
						logger.info(
								"Due to 3 wrong attempts, Your account has been locked, so try after 24 hours or go for password reset");
						valid = "Due to wrong attempts, Your account has been locked, so try after 24 hours or go for password reset";
						dao.updateDateByEmail(email, curDate);       // resetting date to current date in DB
					}
				} else {
					valid = "You have entered wrong email";
					logger.info("Wrong email");
				}

			} else {
				valid = "You have not entered email or password";
				logger.info("not entered email or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

	@Override
	public Boolean validateAndFetchPersonalDetailsByEmail(String email) {
		logger.info("Invoked validateAndFetchPersonalDetailsByEmail() method from ServiceImpl");
		logger.info("Start : processing validateAndFetchPersonalDetailsByEmail()");
		PersonalInfoEntity pEntity = new PersonalInfoEntity();
		boolean valid = false;
		try {
			pEntity = dao.fetchPersonalDetailsByEmail(email);  //  fetching Personal Information by email
			if (Objects.nonNull(pEntity) && pEntity.getPassword() == null) {
				logger.info("Object is not null or password doesnot exists");
				valid = true;
			}
			logger.info("End : processing validateAndFetchPersonalDetailsByEmail()");
		} catch (Exception e) {
			logger.error("Something went wrong in validateAndFetchPersonalDetailsByEmail() in ServiceImpl", e);
		}
		return valid;
	}

	@Override
	public void validateAndUpdatePasswordByEmail(String password, String email) {
		logger.info("Invoked validateAndUpdatePasswordByEmail() method from ServiceImpl");
		logger.info("Start : Processing validateAndUpdatePasswordByEmail()");
		try {
			if (email != null && !email.isEmpty()) {
				logger.info("Email is valid");
				if (password != null && !password.isEmpty()) {
					logger.info("Password is not null");
					logger.info("Password before Encryption : " + password);
					String encPassword = encAndDec.encryptData(password);  //  getting encrypted password for a given password
					logger.info("Encrypted password : " + encPassword);
					dao.updatePasswordByEmailId(encPassword, email);  // updating password by email
				} else {
					logger.info("Password is null");
				}
			} else {
				logger.info("email is null");
			}

			logger.info("End : Processing validateAndUpdatePasswordByEmail()");
		} catch (Exception e) {
			logger.error("Something went wrong in validateAndUpdatePasswordByEmail() in ServiceImpl");
		}

	}

	@Override
	public String validateAndFetchByEmail(String email) {
		logger.info("Invoked validateAndFetchByEmail() method from ServiceImpl");
		logger.info("Start : processing validateAndFetchByEmail() in Service Impl");
		String valid = null;
		int count = 0;
		Date curDate = new Date();
		try {
			if (Objects.nonNull(email) && !email.isEmpty()) {
				logger.info("Email is valid");
				PersonalInfoEntity pEntiy = dao.fetchByEmail(email);
				if (Objects.nonNull(pEntiy)) {
					logger.info("Object is not null");
					if (pEntiy.getPassword() != null) {
						// generating new password
						String newPassword = generator.generatePassword(8);
						logger.info("New Password : " + newPassword);
						// updating password
						validateAndUpdatePasswordByEmail(newPassword, email);
						// updating login count
						validateAndUpdateLoginCountByEmail(email, count);
						// updating Date means setting date to current date after resetting password
						dao.updateDateByEmail(email, curDate);
						valid = "password is resetted successfully and is sent to " + email;
						// sending reset password to an email
						eService.sendingNewPasswordToEmail(newPassword, email);
						logger.info("Password already exists, it is resetted and sent to email");
					} else {
						valid = "Password doesnot exist before, so go for first time login";
						logger.info("password is null, so go to first time password generation");
					}
				} else {
					valid = "Email is not matching, Enter right Email";
					logger.info("Object is null");
				}

			} else {
				valid = "You have not entered an Email";
				logger.info("Email is not valid");
			}
			logger.info("End : processing validateAndFetchByEmail() in Service Impl");
			;

		} catch (Exception e) {
			logger.error("Something went wrong in validateAndFetchByEmail() method in ServiceImpl", e);
		}
		return valid;

	}

	@Override
	public int validateAndFetchLoginCountByEmail(String email) {
		logger.info("Invoked validateAndFetchLoginCountByEmail() method from ServiceImpl");
		logger.info("Start : processing validateAndFetchLoginCountByEmail in ServiceImpl");
		int count = 10;
		try {

			if (Objects.nonNull(email) && !email.isEmpty()) {
				logger.info("email is valid");
				count = dao.fetchLoginCountByEmail(email);

			} else {
				logger.info("email is not valid");
			}
			logger.info("End : processing validateAndFetchLoginCountByEmail in ServiceImpl");

		} catch (Exception e) {
			logger.error("Something went wrongh in validateAndFetchLoginCountByEmail() method in ServiceImpl", e);
		}
		return count;
	}

	@Override
	public void validateAndUpdateLoginCountByEmail(String email, Integer count) {
		logger.info("Invoked validateAndUpdateLoginCountByEmail() method from ServiceImpl");
		logger.info("Start : processing validateAndUpdateLoginCountByEmail() in ServiceImpl");
		try {
			if (count >= 0) {
				logger.info("Count is valid");
				dao.updateLoginCountByEmail(email, count);

			} else {
				logger.info("Count is not valid");
			}
			logger.info("End : processing validateAndUpdateLoginCountByEmail() in ServiceImpl");
			;
		} catch (Exception e) {
			logger.error("Something went wrong in validateAndUpdateLoginCountByEmail() method in ServiceImpl", e);
		}

	}

	@Override
	public String returnLoginStatusByEmailAndPassword(String email, String encPassword, int count) {
		String name = null;
		try {
			logger.info("Invoked calculateResetTime() method from ServiceImpl");
			logger.info("Start : processing validateAndUpdateLoginCountByEmail() in ServiceImpl");
			if (Objects.nonNull(email) && !email.isEmpty() && Objects.nonNull(encPassword) && !encPassword.isEmpty()
					&& count >= 0) {
				logger.info("Email, encPassword and count are valid");
				PersonalInfoEntity pEntity2 = new PersonalInfoEntity();
				pEntity2 = dao.fetchDetailsByEmailAndPassword(email, encPassword);
				if (pEntity2 != null) {
					name = "You have loggedIn Successfully";
					logger.info("Object is not null");
				} else {
					name = "You have entered wrong password";
					logger.info("Object is null");
					count = count + 1;
					validateAndUpdateLoginCountByEmail(email, count);
				}
				logger.info("End : processing validateAndUpdateLoginCountByEmail() in ServiceImpl");
			} else {
				logger.info("Email, encPassword and count are invalid");
			}
		} catch (Exception e) {
			logger.error("Something went wrong in calculateResetTime() method from ServiceImpl", e);
		}
		return name;

	}

}
