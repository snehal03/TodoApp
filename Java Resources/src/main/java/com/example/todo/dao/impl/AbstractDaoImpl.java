package com.example.todo.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.dao.AbstractDao;
import com.example.todo.exceptions.DBException;

/**
 * Interface defines some generic method that used in Hibernate database
 * opetations.
 *
 * @param <T>
 */
@Transactional
public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

	private Class<T> classType;

	@Autowired
	private SessionFactory sessionFactory;

	protected AbstractDaoImpl(Class<T> type) {
		this.classType = type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Serializable insert(T object) {
		Session session = getSession();
		try {
			Serializable newId = session.save(object);
			return newId;
		} catch (ConstraintViolationException cve) {
			throw cve;
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(Collection<T> collection) {
		Session session = getSession();
		try {
			for (T object : collection) {
				session.save(object);
			}
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T object) {
		Session session = getSession();
		try {
			session.update(object);
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Collection<T> collection) {
		Session session = getSession();
		try {
			for (T object : collection) {
				session.update(object);
			}
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Serializable id) {
		try {
			T object = getObjectById(id);
			if (object != null)
				delete(object);
		} catch (ConstraintViolationException cve) {
			throw cve;
		} catch (DBException s2e) {
			throw s2e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T object) {
		Session session = getSession();
		try {
			session.delete(object);
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> loadAll() {
		Session session = getSession();
		try {
			Criteria criteria = session.createCriteria(getClassType());
			return criteria.list();
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T getObjectById(Serializable id) {
		T object = null;
		Session session = getSession();
		try {
			object = (T) session.get(getClassType(), id);
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
		return object;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Criteria getCriteria(Session session) {
		return session.createCriteria(getClassType());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Criteria getCriteria(Session session, String alias) {
		return session.createCriteria(getClassType(), alias);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void closeSession(Session session) {
		/*
		 * implements session close methods. Not required as of now because
		 * sessoin is managed by Spring Contrainer.
		 */
	}

	/**
	 * Method return the class of associated Entity.
	 * 
	 * @return {@link Class}
	 */
	protected Class<T> getClassType() {
		return classType;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUpdate(T object) {
		Session session = getSession();
		try {
			session.saveOrUpdate(object);
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

}
