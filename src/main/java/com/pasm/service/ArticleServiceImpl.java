/**
 * 
 */
package com.pasm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pasm.dao.ArticleDAO;
import com.pasm.model.Article;

/**
 * @author Peter
 * 
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDAO articleDAO;


	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	

	@Override
	@Transactional
	public List<Article> listArticles(int intialRow) {
		 return this.articleDAO.listArticles(intialRow);
	}

}
