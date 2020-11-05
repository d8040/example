package example.service;

import java.util.List;

import example.container.Container;
import example.dao.ArticleDao;
import example.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int add(int loginedMemberId, String title, String body) {
		return articleDao.add(loginedMemberId, title, body);
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

}
