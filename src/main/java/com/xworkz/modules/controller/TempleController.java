package main.java.com.xworkz.modules.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import main.java.com.xworkz.modules.dto.TempleDTO;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;
import main.java.com.xworkz.modules.passwordgenerator.RandomPasswordGenerator;
import main.java.com.xworkz.modules.service.EmailService;
import main.java.com.xworkz.modules.service.TempleService;

@Component
@RequestMapping("/")
public class TempleController {

	private List<TempleDTO> seList;
	private List<TempleDTO> prList;
	private List<TempleDTO> idList;
	private List<TempleDTO> ptList;
	@Autowired
	private TempleService service;

	@Autowired
	private EmailService emailService;
	@Autowired
	private RandomPasswordGenerator passwordGenerator;

	private Logger logger = Logger.getLogger(TempleController.class);

	public TempleController() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@PostConstruct
	public void init() {
		logger.info("Start : Initialization");
		logger.info("Invoked init() method");
		seList = service.validateAndFetchByType("SE");
		prList = service.validateAndFetchByType("PR");
		idList = service.validateAndFetchByType("ID");
		ptList = service.validateAndFetchByType("PT");
		logger.info("End : Initialization");

	}

	@RequestMapping("/onLanding.do")
	public String onClick(Model model) {
		try {
			logger.info("Invoked onClick() method from controller");

			model.addAttribute("selist", seList);
			model.addAttribute("prlist", prList);
			model.addAttribute("idlist", idList);
			model.addAttribute("ptlist", ptList);

			return "Registration";
		} catch (Exception e) {
			logger.error("Something went wrong in controller", e);
		}
		return null;
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String onRegister(TempleRegistrationDTO dto, Model model, @RequestParam String file) {
		try {
			logger.info("Start : processing onRegister() method in controller");
			logger.info("Invoked onRegister() method from controller");
			logger.info("Information got from UI is :\n" + dto);
			logger.info("Now going to call service");

			// calling service method to save dto into DataBase
			Boolean check = service.validateAndSave(dto);
			if (check) {
				model.addAttribute("dto", dto);

				logger.info("File recieved from UI is : \"" + file + "\"");

				// saving data into Excel Sheet
//				service.validateAndSaveIntoExcel(dto, file);

				// reading data from Excel Sheet
//				List<TempleRegistrationDTO> list = service.validateAndThenToDtoConvertion(file);

				logger.info("data fetched from Excel data sheet is : ");
//				list.forEach(System.out::println);

				// calling service method to save dto data fetched from excel sheet into
				// DataBase
//				 service.validateAndSave(list);

				logger.info("End : processing onRegister() method in controller");
				model.addAttribute("success", "You have registerd successfully and Details sent to email Successfully");
				return "Registration";
			} else {
				model.addAttribute("unsuccess", "EmailId or Phone Number already Exists");
				return "Registration";
			}
		} catch (Exception e) {
			logger.error("Some thing went wrong in onRegister() method in controller", e);
		}
		return null;
	}

	@RequestMapping(value = "request.do", method = RequestMethod.POST)
	public String getVisitDetails(@RequestParam String email, Model model) {
		logger.info("Invoked getVisitDetails() method from Controller");
		logger.info("Start : processing getVisitDetails() from Controller");
		TempleRegistrationDTO dto = new TempleRegistrationDTO();
		dto = service.validateAndGetVisitDetailsByEmail(email);
		if (dto != null) {
			dto.setEmailId(email);
			emailService.sendRegisterSuccessEmail(dto);
			logger.info("Details sent to " + email + " successfully");
			model.addAttribute("success", "Details sent to " + email + " successfully");

		} else {
			logger.info("You have not entered or entered wrong email");
			model.addAttribute("fail", "You have not entered or entered wrong email");
		}
		logger.info("End : processing getVisitDetails() from Controller");
		return "Request";

	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String loginCheck(@RequestParam String email, @RequestParam String pwd, Model model) {
		try {
			String check = null;
			check = service.validateAndfetchDetailsByEmailAndPasswod(email, pwd);
			model.addAttribute("logMessage", check);

		} catch (Exception e) {
			logger.info("Something went wrong in loginCheck() from Controller", e);
		}
		return "LoginPage";
	}

	@RequestMapping(value = "generate.do", method = RequestMethod.POST)
	public String checkingPasswordExistance(@RequestParam String email, Model model) {
		logger.info("Invoked checkingPasswordExistance() method from Controller");
		try {
			Boolean check = false;
			// calling service to check whether password exist are not
			check = service.validateAndFetchPersonalDetailsByEmail(email);
			if (check) {
				// generating new password
				String newPassword = passwordGenerator.generatePassword(8);
				logger.info("New password is : " + newPassword);

				// Encrypted password

				// calling service to update password from PersonalInfoEntity
				service.validateAndUpdatePasswordByEmail(newPassword, email);

				// sending reset password to given email
				emailService.sendingNewPasswordToEmail(newPassword, email);
				logger.info("new password is sent to " + email + " successfully");
				model.addAttribute("password", "new password is sent to " + email + " successfully");

			} else {
				logger.info(email + "is not matching, please enter right email");
				model.addAttribute("wrong", email + "is not matching or password already exists");
			}
		} catch (Exception e) {
			logger.error("something went wrong in checkingPasswordExistance() in Controller", e);
		}

		return "FirstTimeLogin";
	}

}
