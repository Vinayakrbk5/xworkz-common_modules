package main.java.com.xworkz.modules.controller;

import java.util.List;
import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.com.xworkz.modules.entity.TempleEntity;
import main.java.com.xworkz.modules.service.TempleService;

@Component
@RequestMapping("/")
public class TempleController {
	
	private List<TempleEntity> seList;
	private List<TempleEntity> prList;
	private List<TempleEntity> idList;
	private List<TempleEntity> ptList;
	@Autowired
	private TempleService service;
	
	private Logger logger=Logger.getLogger(TempleController.class);
	
	public TempleController() {
		logger.info("Created "+this.getClass().getSimpleName());
	}
	@PostConstruct
	public void init()
	{
		logger.info("Start : Initialization");
		logger.info("Invoked init() method");
		seList=service.validateFetchByType("SE");
		prList=service.validateFetchByType("PR");
		idList=service.validateFetchByType("ID");
		ptList=service.validateFetchByType("PT");
		logger.info("End : Initialization");
		
	}
	
	@RequestMapping("/onLanding.do")
	public String onClick(Model model)
	{
		
		logger.info("Invoked onClick() method");
		System.out.println("Special Entrance :"+seList);
		System.out.println(prList);
		model.addAttribute("selist", seList);
		model.addAttribute("prlist", prList);
		model.addAttribute("idlist", idList);
		model.addAttribute("ptlist", ptList);
		
		return "registration";
	}
	
	

}
