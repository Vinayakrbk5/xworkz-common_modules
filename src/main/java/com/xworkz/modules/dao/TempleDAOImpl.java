package main.java.com.xworkz.modules.dao;

import java.util.ArrayList;
import java.util.Date;
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
			logger.error("Something went wrong in save() method in DAOImpl", e);
		} finally {
			session.close();
		}

	}

	@Override
	public long fetchEmailCount(String email) {
		logger.info("Invoked fetchEmailCount() method from DAOImpl");
		logger.info("Start : fetchEmailCount() method in DAOImpl");
		Session session = factory.openSession();
		try {
			logger.info("Start : Session");
			Query query = session.getNamedQuery("fetchEmailCount");
			query.setParameter("email", email);
			long emailCount = (long) query.uniqueResult();
			logger.info("Email Count =" + emailCount);
			logger.info("End : Session");
			logger.info("End : fetchEmailCount() method in DAOImpl");
			return emailCount;
		} catch (Exception e) {
			logger.error("Something went wrong in fetchEmailCount() method in DAOImpl", e);
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public long fetchPhoneNumberCount(String phoneNumber) {
		logger.info("Invoked fetchPhoneNumberCount() method from DAOImpl");
		logger.info("Start : fetchPhoneNumberCount() method in DAOImpl");
		Session session = factory.openSession();
		try {
			logger.info("Start : Session");
			Query query = session.getNamedQuery("fetchPhoneNumberCount");
			query.setParameter("phone", phoneNumber);
			long numberCount = (long) query.uniqueResult();
			logger.info("PhoneNumber Count = " + numberCount);
			logger.info("End : Session");
			logger.info("End : fetchPhoneNumberCount() method in DAOImpl");
			return numberCount;

		} catch (Exception e) {
			logger.error("Something went wrong in fetchPhoneNumberCount() method in DAOImpl", e);
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public VisitingInfoEntity fetchVisitDetailsByEmail(String email) {
		logger.info("Invoked fetchVisitDetailsByEmail() method from DAOImpl");
		logger.info("Start :  processing fetchVisitDetailsByEmail() from DAOImpl");
		Session session = factory.openSession();
		logger.info("Start : Session");
		try {
			String selectQuery = "select visit from VisitingInfoEntity visit"
					+ " where personid=(select personId from PersonalInfoEntity where emailId=:email)";

			Query query = session.createQuery(selectQuery);
			query.setParameter("email", email);
			VisitingInfoEntity vEntity = (VisitingInfoEntity) query.uniqueResult();
			logger.info("End :  Session");
			logger.info("End :  processing fetchVisitDetailsByEmail() from DAOImpl");
			return vEntity;
		} catch (Exception e) {
			logger.error("Something went wrong in fetchVisitDetailsByEmail() method in DAOImpl", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public PersonalInfoEntity fetchDetailsByEmailAndPassword(String email, String password) {
		logger.info("Invoked fetchDetailsByEmailAndPassword() method from DAOImpl");
		logger.info("Start : processing fetchDetailsByEmailAndPassword()");
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			logger.info("Start : Session");
			Query query = session.getNamedQuery("fetchDetailsByEmailAndPassword");
			query.setParameter("email", email);
			query.setParameter("pass", password);
			PersonalInfoEntity pEntity = (PersonalInfoEntity) query.uniqueResult();
			logger.info("End : session");
			logger.info("Start : processing fetchDetailsByEmailAndPassword()");
			return pEntity;

		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Some thing went wrong in fetchDetailsByEmailAndPassword() method in DAOImpl", e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public PersonalInfoEntity fetchPersonalDetailsByEmail(String email) {
		logger.info("Invoked fetchPersonalDetailsByEmail() method from DAOImpl");
		logger.info("Start : processing fetchPersonalDetailsByEmail()");
		Session session = factory.openSession();
		session.beginTransaction();
		PersonalInfoEntity pEntity = new PersonalInfoEntity();
		try {
			logger.info("Start :Session");
//			String hqlQuery = "select person from PersonalInfoEntity person where emailId=:email";
//			Query query = session.createQuery(hqlQuery);
			Query query = session.getNamedQuery("fetchPersonalDetailsByEmail");
			query.setParameter("email", email);
			pEntity = (PersonalInfoEntity) query.uniqueResult();
			logger.info("End :Session");
			logger.info("End : processing fetchPersonalDetailsByEmail()");
			return pEntity;

		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Some thing went wrong in fetchPersonalDetailsByEmail() from DAOImpl()");
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void updatePasswordByEmailId(String password, String emailId) {
		logger.info("Invoked updatePasswordByEmailId() method from DAOImpl");
		logger.info("Start : Processing updatePasswordByEmailId()");
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			logger.info("Start : Session");
//			String hqlQuery = "update PersonalInfoEntity set password=:password where emailId=:email";
//			Query query = session.createQuery(hqlQuery);
			Query query = session.getNamedQuery("updatePasswordByEmailId");
			query.setParameter("password", password);
			query.setParameter("email", emailId);
			int res = query.executeUpdate();
			session.getTransaction().commit();
			if (res > 0) {
				logger.info("Password is updated ");
			} else {
				logger.info("Password is not updated");
			}
			logger.info("End : Session");
			logger.info("Start : Processing updatePasswordByEmailId()");

		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Something went wrong in updatePasswordByEmailId() in DAOImpl", e);
		} finally {
			session.close();
		}

	}

	@Override
	public PersonalInfoEntity fetchByEmail(String email) {
		logger.info("Invoked fetchByEmail() from DAOImpl");
		logger.info("Start : Processing fetchByEmail()");
		Session session = factory.openSession();
		PersonalInfoEntity pEntity = new PersonalInfoEntity();
		try {
//			String hqlQuery = "select personal from PersonalInfoEntity personal where emailId=:email";
			Query query = session.getNamedQuery("fetchByEmail");
			query.setParameter("email", email);
			pEntity = (PersonalInfoEntity) query.uniqueResult();
			logger.info("End : Processing fetchByEmail()");
		} catch (Exception e) {
			logger.error("Something went wrong in fetchByEmail() method in DAOImpl");
		} finally {
			session.close();
		}
		return pEntity;

	}

	@Override
	public int fetchLoginCountByEmail(String email) {
		logger.info("Invoked fetchLoginCountByEmail() method from DAOImpl");
		logger.info("Start : Processing fetchLoginCountByEmail() from DAOImpl");
		int count = 10;
		Session session = factory.openSession();
		try {
//			String hqlQuery = "select loginCount from PersonalInfoEntity where emailId=:email";
			Query query = session.getNamedQuery("fetchLoginCountByEmail");
			query.setParameter("email", email);
			count = (int) query.uniqueResult();

			logger.info("End : Processing fetchLoginCountByEmail() from DAOImpl");

		} catch (Exception e) {
			logger.error("Something went wrong in DAOImpl",e);
		} finally {
			session.close();
		}
		return count;
	}

	@Override
	public void updateLoginCountByEmail(String email, Integer count) {
		logger.info("Invoked updateLoginCountByEmail() method from DAOImpl");
		logger.info("Start : processing updateLoginCountByEmail() in DAOImpl");
		Session session = factory.openSession();
		try {
			session.beginTransaction();
//			String hqlQuery = "update PersonalInfoEntity set loginCount=:count where emailId=:email";
			Query query = session.getNamedQuery("updateLoginCountByEmail");
			query.setParameter("email", email);
			query.setParameter("count", count);
			int res = query.executeUpdate();
			session.getTransaction().commit();
			if (res > 0) {
				logger.info("LoginCount is updated");
			} else {
				logger.info("failed to update logincount");
			}

			logger.info("End : processing updateLoginCountByEmail() in DAOImpl");
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Something went wrong in DAOImpl",e);
		} finally {
			session.close();
		}

	}
	
	@Override
	public Date fetchDateByEmail(String email) {
		logger.info("Invoked fetchDateByEmail() method from DAOImpl");
		logger.info("Start : processing fetchDateByEmail() in DAOImpl");
		Session session=factory.openSession();
		Date date=new Date();
		try {
			logger.info("Start : Session");
//			String hqlQuery="select person.loginDate from PersonalInfoEntity person where emailId=:email";
			Query query=session.getNamedQuery("fetchDateByEmail");
			query.setParameter("email", email);
			date=(Date) query.uniqueResult();
			logger.info("End : Session");
			logger.info("End : processing fetchDateByEmail() in DAOImpl");
			return date;
			
		}catch (Exception e) {
			logger.error("Something went wrong in fetchDateByEmail() method in DAOImpl",e); 
		}finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public void updateDateByEmail(String email, Date curDate) {
		Session session =factory.openSession();
		int res=0;
		try {
			session.beginTransaction();
//			String hqlQuery="Update PersonalInfoEntity set loginDate=:date where emailId=:email";
			Query query=session.getNamedQuery("updateDateByEmail");
			query.setParameter("date", curDate);
			query.setParameter("email", email);
			res=(int) query.executeUpdate();
			session.getTransaction().commit();
			if(res>0)
			{
				logger.info("Updated date");
			}else
			{
				logger.info("fail to update");
			}
			
			
		}catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Something went wrong in updateDateByEmail() method in DAOImpl",e); 
		}finally {
			session.close();
		}
		
	}

}
