package main.java.com.xworkz.modules.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import main.java.com.xworkz.modules.entity.TempleEntity;
@Component
public class TempleDAOImpl implements TempleDAO{
	
	private Logger logger=Logger.getLogger(TempleDAOImpl.class);
	
	private SessionFactory factory;
	
	public TempleDAOImpl() {
		logger.info("Created "+this.getClass().getSimpleName());
	}
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<TempleEntity> fetchByType(String type) {
		logger.info("Start : DAOImpl");
		logger.info("Invoked fetchByType() method from DAOImpl");
		Session session=factory.openSession();
		try {
			String selectQuery="select temple from TempleEntity temple where type=:type";
			Query query=session.createQuery(selectQuery);
			query.setString("type", type);
			List<TempleEntity> list=query.list();
			logger.info("End : DAOImpl");
			return list;
		}catch (Exception e) {
			logger.error("Something went wrong in DAOImpl",e);
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
