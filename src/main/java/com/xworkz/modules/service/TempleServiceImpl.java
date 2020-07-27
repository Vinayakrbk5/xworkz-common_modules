package main.java.com.xworkz.modules.service;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.xworkz.modules.dao.TempleDAO;
import main.java.com.xworkz.modules.entity.TempleEntity;

@Service
public class TempleServiceImpl implements TempleService{
	private Logger logger=Logger.getLogger(TempleServiceImpl.class);
	
	@Autowired
	private TempleDAO dao;
	
	@Override
	public List<TempleEntity> validateFetchByType(String type) {
		try {
	 	logger.info("Start : Serice");
	 	List<TempleEntity> list = null;
		if(Objects.nonNull(type)&& !type.isEmpty())
		{
			logger.info("type is valid");
			list=dao.fetchByType(type);
		}
		else
		{
			logger.warn("type is invalid");
		}
		logger.info("End : Service");
		return list;
		}
		catch (Exception e) {
			logger.error("Something went wrong in Service",e);
		}
		return null;
	}

}
