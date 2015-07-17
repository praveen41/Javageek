/**
 * 
 */
package com.pasm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pasm.model.Article;

/**
 * @author Peter
 *
 */
@Repository
public class ArticleDAOImpl implements ArticleDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public List<Article> listArticles(int intialRow) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query =session.createQuery("from Article");
		query.setFirstResult(intialRow);
		query.setMaxResults(intialRow+10);
		List<Article> articlesList = query.list();
		return articlesList;
	}

}
