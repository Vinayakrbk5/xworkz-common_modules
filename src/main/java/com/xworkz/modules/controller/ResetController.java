package main.java.com.xworkz.modules.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.xworkz.modules.dao.TempleDAOImpl;
import main.java.com.xworkz.modules.service.TempleService;

@Component
@RequestMapping("/")
public class ResetController {
	private Logger logger = Logger.getLogger(TempleDAOImpl.class);
	@Autowired
	private TempleService service;
	
	public ResetController() {
	}
	
	@RequestMapping(value="reset.do", method = RequestMethod.POST)
	public String resetPassword(@RequestParam String email,Model model)
	{
		logger.info("Invoked resetPassword() from ResetController");
		logger.info("Start : Processing resetPassword()");
		String check=null;
		check=service.validateAndFetchByEmail(email);
		logger.info("Value recieved from service is : "+check);
		model.addAttribute("message", check);
		logger.info("End : Processing resetPassword()");
		return "ResetPassword";
	}
	

}
