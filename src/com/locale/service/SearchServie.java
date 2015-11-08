package com.locale.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.locale.hibernate.util.HibernateUtil;
import com.locale.model.UserData;

public class SearchServie
{
    @SuppressWarnings("unchecked")
    public List<UserData> Search(String name)
    {
	Session session = HibernateUtil.openSession();
	List<UserData> results = null;
	Transaction tx = null;
	try
	{
	    name = name + "%";
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("from UserData where firstName like ?");
	    query.setParameter(0, name);
	    results = query.list();
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
	return results;
    }
    
    @SuppressWarnings("unchecked")
    public List<UserData> SearchHouse(String name)
    {
	Session session = HibernateUtil.openSession();
	List<UserData> results = null;
	Transaction tx = null;
	try
	{
	    name = name + "%";
	    tx = session.getTransaction();
	    tx.begin();
	    Query query = session.createQuery("from UserData where houseName like ?");
	    query.setParameter(0, name);
	    results = query.list();
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
	return results;
    }
}
