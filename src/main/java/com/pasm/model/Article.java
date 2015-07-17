/**
 * 
 */
package com.pasm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Peter
 *
 */
@Entity
@Table(name = "Article")
public class Article {

	@Id
	@Column(name = "Articleid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	
	private String articleName;
	
	private int articleUserId;
	
	private String articleCreatedBy;
	
	private Date articleCreatedDate;
	
	private String articleUpdatedBy;
	
	private Date articleUpdatedDate;
	
	private String articleDescription;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public int getArticleUserId() {
		return articleUserId;
	}

	public void setArticleUserId(int articleUserId) {
		this.articleUserId = articleUserId;
	}

	public String getArticleCreatedBy() {
		return articleCreatedBy;
	}

	public void setArticleCreatedBy(String articleCreatedBy) {
		this.articleCreatedBy = articleCreatedBy;
	}

	public Date getArticleCreatedDate() {
		return articleCreatedDate;
	}

	public void setArticleCreatedDate(Date articleCreatedDate) {
		this.articleCreatedDate = articleCreatedDate;
	}

	public String getArticleUpdatedBy() {
		return articleUpdatedBy;
	}

	public void setArticleUpdatedBy(String articleUpdatedBy) {
		this.articleUpdatedBy = articleUpdatedBy;
	}

	public Date getArticleUpdatedDate() {
		return articleUpdatedDate;
	}

	public void setArticleUpdatedDate(Date articleUpdatedDate) {
		this.articleUpdatedDate = articleUpdatedDate;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
	
}
