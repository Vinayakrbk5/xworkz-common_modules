package main.java.com.xworkz.modules.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.xworkz.modules.dao.BookDAO;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;
import main.java.com.xworkz.modules.entity.VisitingInfoEntity;
@Component
public class BookServiceImpl implements BookService{
	private Logger logger = Logger.getLogger(BookServiceImpl.class);
	@Autowired
	private BookDAO dao;
	@Override
	public int validateAndSaveVisitDetails(TempleRegistrationDTO dto) {
		logger.info("Start : validateAndSaveVisitDetails() method from BookServiceImpl");
		VisitingInfoEntity entity=new VisitingInfoEntity();
		BeanUtils.copyProperties(dto, entity);
		String email="vinay@gmail.com";
		int valid=0;
		try {
			if(Objects.nonNull(dto))
			{
				valid=1;
				System.out.println("Object is not null, so we can save");
				dao.saveVisitDetails(entity, email);
			}
			else
			{
				System.out.println("Object is null, so we cannot save");
			}
			logger.info("End : validateAndSaveVisitDetails() method from BookServiceImpl");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

}
