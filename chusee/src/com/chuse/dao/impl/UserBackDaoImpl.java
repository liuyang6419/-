package com.chuse.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.chuse.entity.Product;
import com.chuse.entity.User;

@Repository
public class UserBackDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	//后台----后台----后台----后台----后台----后台-----------------
	public User findByIdBack(Integer uid){	
		User user = (User)this.sessionFactory.getCurrentSession().
				createQuery("from User where uid = ?").
				setParameter(0, uid).uniqueResult();
		return user;
	}
		
	
	public void deleteByIdBack(User user,Integer uid){
		Session session=sessionFactory.openSession();
		System.out.print("dao快删啊");
		Transaction tran = session.beginTransaction() ;     
		String hql = "Delete FROM User Where uid=?" ;     
		Query q = session.createQuery(hql) ;     
		q.setInteger(0, uid) ;     
		q.executeUpdate() ;     
		tran.commit() ; 			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//后台-------------------------------------------------------
	//后-查-用户列表
	//分页查询数据	
	public List<User> findByPage(int pageNum, int pageSize){
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from "+User.class.getSimpleName());
			query.setFirstResult((pageNum-1)*pageSize);
			query.setMaxResults(pageSize);
			System.out.println("dao xiaomi");
			return query.list();
					
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//统计数据个数 
	public int findCountByPage(){
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("select count("+"*"+") from "+User.class.getSimpleName());
			return new Long((long)query.uniqueResult()).intValue();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
}
