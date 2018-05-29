/**
 * 
 */
package com.project.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.IBasicDao;
import com.project.util.PageBean;

/**
 * @author howroad
 * @Date 2018年4月26日
 * @version 1.0
 */
public abstract class BasicDaoAdapter<E, K extends Serializable> implements IBasicDao<E, K> {
	@Autowired
	protected SessionFactory sessionFactory;
	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	protected BasicDaoAdapter() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass = (Class<E>) pt.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public K add(E e) {
		return (K) sessionFactory.getCurrentSession().save(e);
	}

	@Override
	public boolean delete(E e) {
		boolean boo = false;
		try {
			sessionFactory.getCurrentSession().delete(e);
			boo = true;
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return boo;
		
	}

	@Override
	public boolean update(E e) {
		
		boolean boo = false;
		try {
			sessionFactory.getCurrentSession().update(e);
			boo = true;
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return boo;
	}

	@Override
	public E findById(K id) {
		return sessionFactory.getCurrentSession().get(entityClass, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageBean<E> findAllPage(int pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		List<E> list = session.createQuery("from " + entityClass.getSimpleName()).setMaxResults(pageSize)
				.setFirstResult((pageNo - 1) * pageSize).list();
		long totalRecord = (long) session.createQuery("select count(*) from " + entityClass.getSimpleName())
				.uniqueResult();
		
		
		return new PageBean<E>(list, pageNo, pageSize, new Long(totalRecord).intValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAllList() {
		return sessionFactory.getCurrentSession().createQuery("from " + entityClass.getSimpleName()).list();
	}

	@Override
	public boolean deleteByIds(Serializable... ids) {
		Session session = sessionFactory.getCurrentSession();
		boolean boo = true;
		for (Serializable id : ids) {
			
			try {
				session.delete(session.load(entityClass, id));
			} catch (Exception e2) {
				boo = false;
				break;
			}
		}
		return boo;

	}

	@SuppressWarnings("unchecked")
	@Override
	public E findEntityByHQL(String hql, Object... objs) {
		Query<E> query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objs.length; i++) {
			
			query.setParameter(i, objs[i]);
		}
		return (E) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findEntityBySQL(String sql, Object... objs) {
		Query<E> query = sessionFactory.getCurrentSession().createNativeQuery(sql);
		for (int i = 0; i < objs.length; i++) {
			query.setParameter(i, objs[i]);
		}
		return (E) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listByHQL(String hql, Object... objs) {
		Query<E> query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objs.length; i++) {
			query.setParameter(i, objs[i]);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listBySQL(String sql, Object... objs) {
		Query<E> query = sessionFactory.getCurrentSession().createNativeQuery(sql);
		for (int i = 0; i < objs.length; i++) {
			query.setParameter(i, objs[i]);
		}
		return query.list();
	}

	@Override
	public void addMany(Collection<E> collection) {
		Session session = sessionFactory.getCurrentSession();
		for (E e : collection) {
			session.save(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addMany(E... es) {
		Session session = sessionFactory.getCurrentSession();
		for(int i=0;i<es.length;i++) {
			session.save(es[i]);
		}
	}

	@Override
	public PageBean<E> findEntityBySome(String hql,String countHql,int pageNo, int pageSize, Object... objs) {
		Query<E> query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objs.length; i++) {
			query.setParameter(i, objs[i]);
		}
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<E> list = query.list();
		Query<E> query2 = sessionFactory.getCurrentSession().createQuery(countHql);
		for (int i = 0; i < objs.length; i++) {
			query2.setParameter(i, objs[i]);
		}
		long totalRecord = (long) query2.uniqueResult();
		return new PageBean<E>(list, pageNo, pageSize, new Long(totalRecord).intValue());
	}

	@Override
	public PageBean<E> findAllPage(String hql,String countHql, int pageNo, int pageSize) {
		
		List<E> list = sessionFactory.getCurrentSession().createQuery(hql)
				.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize).list();
		long totalRecord = (long) sessionFactory.getCurrentSession().createQuery(countHql)
				.uniqueResult();
		return new PageBean<E>(list, pageNo, pageSize, new Long(totalRecord).intValue());
	}

}
