package com.locale.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.locale.hibernate.util.HibernateUtil;
import com.locale.model.UserData;

public class RegisterService
{
    public void register(UserData userData)
    {
	Session session = HibernateUtil.openSession();

	Transaction tx = null;
	try
	{
	    tx = session.getTransaction();
	    tx.begin();
	    session.saveOrUpdate(userData);
	    tx.commit();
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
