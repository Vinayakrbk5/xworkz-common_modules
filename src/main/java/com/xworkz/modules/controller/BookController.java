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
import main.java.com.xworkz.modules.service.BookService;
import main.java.com.xworkz.modules.service.TempleService;

@Component
@RequestMapping("/")
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private TempleService templeService;
	private Logger logger = Logger.getLogger(BookController.class);
	
	private List<TempleDTO> seList;
	private List<TempleDTO> prList;
	private List<TempleDTO> idList;
	private List<TempleDTO> ptList;
	
	
	@PostConstruct
	public void init() {
		logger.info("Start : Initialization");
		logger.info("Invoked init() method");
		seList = templeService.validateAndFetchByType("SE");
		prList = templeService.validateAndFetchByType("PR");
		idList = templeService.validateAndFetchByType("ID");
		ptList = templeService.validateAndFetchByType("PT");
		logger.info("End : Initialization");
	}
	
	
	@RequestMapping("/onBooking.do")
	public String onBook(Model model,@RequestParam String email) {
		try {
			logger.info("Invoked onBook() method from BookcController");

			model.addAttribute("selist", seList);
			model.addAttribute("prlist", prList);
			model.addAttribute("idlist", idList);
			model.addAttribute("ptlist", ptList);
			model.addAttribute("email", email);
			
			System.out.println("List is : "+seList);

			return "Book";
		} catch (Exception e) {
			logger.error("Something went wrong in controller", e);
		}
		return null;
	}

	
	@RequestMapping(value="/book.do", method = RequestMethod.POST)
	public String bookVisit(Model model,TempleRegistrationDTO dto)
	{
		System.out.println("Start : bookVisit() method from Book controller");
		System.out.println("Email is : "+dto.getEmailId());
		int res=service.validateAndSaveVisitDetails(dto);
		if(res==1)
		{
			model.addAttribute("success", "You Successfully booked");
		}
		else
		{
			model.addAttribute("success", "failed to book");
			
		}
		System.out.println("Start : bookVisit() method from Book controller");
		return "LoginPage";
	}

}
