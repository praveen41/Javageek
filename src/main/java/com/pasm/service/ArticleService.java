/**
 * 
 */
package com.pasm.service;

import java.util.List;

import com.pasm.model.Article;

/**
 * @author Peter
 * 
 */
public interface ArticleService {

	public List<Article> listArticles(int intialRowValue);

}
