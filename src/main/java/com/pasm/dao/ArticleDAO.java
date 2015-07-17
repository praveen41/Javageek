/**
 * 
 */
package com.pasm.dao;

import java.util.List;

import com.pasm.model.Article;

/**
 * @author Peter
 * 
 */
public interface ArticleDAO {

	public List<Article> listArticles(int intialRow);

}
