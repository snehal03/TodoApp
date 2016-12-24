package com.example.todo.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Interface defines some generic method that used in Hibernate database
 * opetations.
 * 
 * @author indmistry
 *
 * @param <T>
 */
public interface AbstractDao<T> {

	/**
	 * @Description Method save object data into database and returns its new
	 *              ID.
	 * @param object
	 * @return {@link Serializable}
	 */
	public Serializable insert(T object);

	/**
	 * @Description Method save given collection of objects data into database.
	 * @param collection
	 */
	public void insert(Collection<T> collection);

	/**
	 * @Description Method update object data into database.
	 * @param object
	 */
	public void update(T object);

	/**
	 * @Description Method update given collection of objects data into
	 *              database.
	 * @param collection
	 */
	public void update(Collection<T> collection);

	/**
	 * @Description Method removes object data from database.
	 * @param object
	 */
	public void delete(Serializable id);

	/**
	 * @Description Method removes object data from database.
	 * @param object
	 */
	public void delete(T object);

	/**
	 * @Description Method returns object for given ID.
	 * @param id
	 * @return {@link Object}
	 */
	public T getObjectById(Serializable id);

	/**
	 * method will return all list associated entity
	 * 
	 * @param collection
	 * @return {@link List}
	 */
	public List<T> loadAll();

	/**
	 * @Description Method create the session and return it.
	 * @return {@link Session}
	 */
	public Session getSession();

	/**
	 * @Description Method returnc Criteria for its assocaited entity.
	 * @param session
	 * @return {@link Criteria}
	 */
	public Criteria getCriteria(Session session);
	
	/**
	 * @Description Method returnc Criteria for its assocaited entity.
	 * @param session
	 * @return {@link Criteria}
	 */
	public Criteria getCriteria(Session session, String alias);

	/**
	 * @Description Method close the given Session.
	 * @param session
	 */
	public void closeSession(Session session);

	/**
	 * @Description Method used to update & save the object
	 * @param object
	 */
	public void saveUpdate(T object);
}
