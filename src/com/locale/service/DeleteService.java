package com.locale.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.locale.hibernate.util.HibernateUtil;
import com.locale.model.UserData;

public class DeleteService
{


    @SuppressWarnings("unchecked")
    public void Delete(Long id)
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
	    for (UserData userDelete : results)
	    {
		session.delete(userDelete);
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
