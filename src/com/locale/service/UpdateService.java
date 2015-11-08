package com.locale.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.locale.hibernate.util.HibernateUtil;
import com.locale.model.UserData;

public class UpdateService
{

    @SuppressWarnings("unchecked")
    public void Update(Long id, UserData userData)
    {
	Session session = HibernateUtil.openSession();
	List<UserData> results = null;
	Transaction tx = null;
	try
	{
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("from UserData where id= ?");
	    query.setParameter(0, id);
	    results = query.list();
	    for (UserData userUpdate : results)
	    {
		userUpdate.setFirstName(userData.getFirstName());
		userUpdate.setLastName(userData.getLastName());
		userUpdate.setHouseName(userData.getHouseName());
		userUpdate.setFatherName(userData.getFatherName());
		userUpdate.setMotherName(userData.getMotherName());
		userUpdate.setMobile(userData.getMobile());
		session.saveOrUpdate(userUpdate);
		tx.commit();
	    }

	} catch (Exception e)
	{
	    if (tx != null)
	    {
		tx.rollback();
	    }
	    e.printStackTrace();
	} finally
	{
	    session.close();
	}
    }

}
