/**
 * 
 */
package com.pasm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pasm.model.Article;
import com.pasm.service.ArticleService;

/**
 * @author Peter
 * 
 */
@Controller
public class ArticleController {

	private ArticleService articleService;

	@Autowired(required = true)
	@Qualifier(value = "articleService")
	public void setArticaleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String intialListArticles(Model model) {
		List<Article> articles = articleService.listArticles(0);
		model.addAttribute("listArticles", articles);
		model.addAttribute("rowValue", articles.size());
		return "index";
	}

	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public String listArticles(Model model,
			@RequestParam("rowValue") String param) {
		try {
			int rowValue = Integer.parseInt(param);
			List<Article> articles = articleService.listArticles(rowValue);
			model.addAttribute("listArticles", articles);
			model.addAttribute("rowValue", rowValue + articles.size());
			return "index";
		} catch (NumberFormatException e) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/articleDesc", method = RequestMethod.GET)
	public String articleDesc(Model model,
			@RequestParam("articleId") String param) {
		try {
/*			int rowValue = Integer.parseInt(param);
			List<Article> articles = articleService.listArticles(rowValue);
			model.addAttribute("listArticles", articles);
			model.addAttribute("rowValue", rowValue + articles.size());*/
			return "post";
		} catch (NumberFormatException e) {
			return "error";
		}
	}
	
	
	
}
