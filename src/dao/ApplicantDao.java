package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import util.DBUtil;
import model.HdzApplicant;
import model.HdzApplication;
import model.HdzEducation;
import model.HdzJob;
import model.HdzJobhistory;
import model.HdzReftable;


public class ApplicantDao {	
	public static void insert(HdzApplicant applicant) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(applicant);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static HdzApplicant getApplicantByName(String firstname, String lastname){
		 EntityManager em = DBUtil.getEmfFactory().createEntityManager();
	        HdzApplicant applicant = null;
	        String qString = "select a from HdzApplicant a "
	                + "where a.firstname = :firstname  and a.lastname= :lastname ";
	        
	        try{
	            TypedQuery<HdzApplicant> query = em.createQuery(qString,HdzApplicant.class);
	            query.setParameter("firstname",firstname);
	            query.setParameter("lastname", lastname);
	             applicant= query.getSingleResult();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return applicant;
		
	}
	public static void update(HdzApplicant applicant) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(applicant);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void insert(HdzApplication app) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(app);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void insert(HdzEducation edu) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(edu);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void insert(HdzJobhistory job) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(job);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void insert(HdzReftable ref) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(ref);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<HdzJob> getAllJobs (){
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        String qString = "select j from HdzJob j";
        
        List<HdzJob> jobs = null;
        try{
            TypedQuery<HdzJob> query = em.createQuery(qString,HdzJob.class);
            jobs = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return jobs;
    }
	
	public static List<HdzJob> searchJobs (String search)
    {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzJob> searchposts = null;
        String qString = "select j from HdzJob j "
                + "where j.position like :search";
        
        try{
            TypedQuery<HdzJob> query = em.createQuery(qString,HdzJob.class);
            query.setParameter("search", "%" + search + "%");
            searchposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchposts;
    }
	
	public static HdzJob getJobById (String id)
    {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        HdzJob searchposts = null;
        String qString = "select j from HdzJob j "
                + "where j.jobsid = :search";
        
        try{
            TypedQuery<HdzJob> query = em.createQuery(qString,HdzJob.class);
            query.setParameter("search", Long.parseLong(id));
            searchposts = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchposts;
    }
	
}
