package main.java.com.xworkz.modules.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import main.java.com.xworkz.modules.dto.TempleDTO;
import main.java.com.xworkz.modules.dto.TempleRegistrationDTO;
import main.java.com.xworkz.modules.entity.PersonalInfoEntity;
import main.java.com.xworkz.modules.entity.TempleEntity;
import main.java.com.xworkz.modules.entity.VisitingInfoEntity;

@Component
public class TempleDAOImpl implements TempleDAO {

	private Logger logger = Logger.getLogger(TempleDAOImpl.class);

	private SessionFactory factory;

	public TempleDAOImpl() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<TempleDTO> fetchByType(String type) {
		logger.info("Start : DAOImpl");
		logger.info("Invoked fetchByType() method with parameter " + type + " from DAOImpl");
		Session session = factory.openSession();
		try {
			List<TempleDTO> list1 = new ArrayList<>();

			Query query = session.getNamedQuery("fetchByType");
			query.setString("type", type);
			List<TempleEntity> list = query.list();
			for (TempleEntity entity : list) {
				TempleDTO dto = new TempleDTO();
				BeanUtils.copyProperties(entity, dto);
				list1.add(dto);
			}

			System.out.println("list from entity: " + list);
			System.out.println("list from dto : " + list1);
			logger.info("End : DAOImpl");
			return list1;
		} catch (Exception e) {
			logger.error("Something went wrong in DAOImpl", e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void save(PersonalInfoEntity entity1, VisitingInfoEntity entity2) {
		logger.info("Invoked Save() method from DAIImpl");
		Session session = factory.openSession();
		try {
			logger.info("Start : Session");
			session.beginTransaction();
			session.save(entity1);
			session.save(entity2);
			session.getTransaction().commit();
			logger.info("End : Session");
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("something went wrong in save() mehod in DAOImpl", e);
		} finally {
			session.close();
		}

	}

	@Override
	public void save(VisitingInfoEntity vEntity, PersonalInfoEntity pEntity) {
		logger.info("Invoked save() method from DAOImpl");
		logger.info("Start : Save() method in DAOImpl");
		Session session = factory.openSession();
		try {
			logger.info("Start : Session");
			session.beginTransaction();
			session.save(vEntity);
			session.save(pEntity);
			session.getTransaction().commit();
			logger.info("End : Session");
			logger.info("End : Save() method in DAOImpl");
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Something went wrong in save() method in DAOImpl",e);
		} finally {
			session.close();
		}

	}

	@Override
	public long fetchEmailCount(String email) {
		logger.info("Invoked fetchEmailCount() method from DAOImpl");
		logger.info("Start : fetchEmailCount() method in DAOImpl");
		Session session=factory.openSession();
		try {
			logger.info("Start : Session");
			Query query=session.getNamedQuery("fetchEmailCount");
			query.setParameter("email", email);
			long emailCount=(long) query.uniqueResult();
			logger.info("Email Count ="+emailCount);
			logger.info("End : Session");
			logger.info("End : fetchEmailCount() method in DAOImpl");
			return emailCount;
		}catch (Exception e) {
			logger.error("Something went wrong in fetchEmailCount() method in DAOImpl",e);
		}finally {
			session.close();
		}
		return 0;
	}

	@Override
	public long fetchPhoneNumberCount(String phoneNumber) {
		logger.info("Invoked fetchPhoneNumberCount() method from DAOImpl");
		logger.info("Start : fetchPhoneNumberCount() method in DAOImpl");
		Session session=factory.openSession();
		try {
			logger.info("Start : Session");
			Query query=session.getNamedQuery("fetchPhoneNumberCount");
			query.setParameter("phone", phoneNumber);
			long numberCount=(long) query.uniqueResult();
			logger.info("PhoneNumber Count = "+numberCount);
			logger.info("End : Session");
			logger.info("End : fetchPhoneNumberCount() method in DAOImpl");
			return numberCount;
			
		}catch (Exception e) {
			logger.error("Something went wrong in fetchPhoneNumberCount() method in DAOImpl",e);
		}finally {
			session.close();
		}
		return 0;
	}

}
