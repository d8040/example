package example.dao;

import java.util.ArrayList;
import java.util.List;

import example.dto.Article;

public class ArticleDao {
	private int lastId;
	private List<Article> articles;

	public ArticleDao() {
		lastId = 0;
		articles = new ArrayList<>();

		testArticle();
	}

	private void testArticle() {
		for (int i = 1; i <= 5; i++) {
			add(1, "aaa", "aaa");
		}
		for (int i = 6; i <= 10; i++) {
			add(2, "bbb", "bbb");
		}
	}

	public int add(int memberId, String title, String body) {
		Article article = new Article();
		article.id = lastId + 1;
		article.title = title;
		article.body = body;
		article.memberId = memberId;

		articles.add(article);
		lastId = article.id;

		return article.id;

	}

	public List<Article> getForPrintArticles() {
		return articles;
	}

}
