package main.java.com.xworkz.modules.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.xworkz.modules.entity.PersonalInfoEntity;
import main.java.com.xworkz.modules.entity.VisitingInfoEntity;
import main.java.com.xworkz.modules.service.TempleServiceImpl;
@Component
public class BookDAOImpl implements BookDAO {
	
	private Logger logger = Logger.getLogger(BookDAOImpl.class);
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int saveVisitDetails(VisitingInfoEntity entity, String email) {
		logger.info("Start : saveVisitDetails() method from Book Dao");
		int personId;
		int count;
		Session session = factory.openSession();
		PersonalInfoEntity pEntity=new PersonalInfoEntity();
		try {
			session.beginTransaction();
			String getQuery = "select person from PersonalInfoEntity person where emailId=:email";
			Query query1 = session.createQuery(getQuery);
			query1.setParameter("email", email);
			pEntity =  (PersonalInfoEntity) query1.uniqueResult();
			personId=pEntity.getPersonId();
			logger.info("Person id is : "+personId);

			String countQuery = "select max(visitId)  from VisitingInfoEntity  where personId=:id";
			Query query2 = session.createQuery(countQuery);
			query2.setParameter("id", personId);
			count =  (int) query2.uniqueResult();
			logger.info("Count is : "+count);

			String insertQuery = "insert into VISITING_INFO_TABLE values(:vid,:date,:idtype,:people,:poojatype,:prasadtype,:entry,:personId)";
			Query query3=session.createSQLQuery(insertQuery);
			query3.setParameter("vid", count+1);
			query3.setParameter("date", entity.getDate());
			query3.setParameter("idtype", entity.getIdCardType());
			query3.setParameter("people", entity.getNoOfPeople());
			query3.setParameter("poojatype", entity.getPoojaType());
			query3.setParameter("prasadtype", entity.getPrasad());
			query3.setParameter("entry", entity.getSpecialEntry());
			query3.setParameter("personId", personId);

			int res = query3.executeUpdate();
			session.getTransaction().commit();
			if (res > 0) {
				logger.info("Inserted details");
			} else {
				logger.info("unable to insert");
			}
			System.out.println("End : saveVisitDetails() method from Book Dao");

		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Something went wrong in BookDAOImpl",e);
		} finally {
			session.close();
		}
		return 0;
	}

}
