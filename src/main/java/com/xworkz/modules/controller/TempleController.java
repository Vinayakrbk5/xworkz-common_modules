package main.java.com.xworkz.modules.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import main.java.com.xworkz.modules.dto.TempleDTO;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;
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
//			logger.info("Special Entrance :" + seList);
//			logger.info("Prasad List : "+ prList);

			model.addAttribute("selist", seList);
			model.addAttribute("prlist", prList);
			model.addAttribute("idlist", idList);
			model.addAttribute("ptlist", ptList);

			return "registration";
		} catch (Exception e) {
			logger.error("Something went wrong in controller", e);
		}
		return null;
	}

	@RequestMapping("/register.do")
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
				service.validateAndSaveIntoExcel(dto, file);

				// reading data from Excel Sheet
				List<TempleRegistrationDTO> list = service.validateAndThenToDtoConvertion(file);

				logger.info("data fetched from Excel data sheet is : ");
				list.forEach(System.out::println);

				// calling service method to save dto data fetched from excel sheet into DataBase
	     	    // service.validateAndSave(list);

				logger.info("End : processing onRegister() method in controller");
				model.addAttribute("success", "Details sent to email Successfully");
				return "success";
			} else {
				model.addAttribute("unsuccess", "EmailId or Phone Number already Exists");
				return "registration";
			}
		} catch (Exception e) {
			logger.error("Some thing went wrong in onRegister() method in controller", e);
		}
		return null;
	}

}
