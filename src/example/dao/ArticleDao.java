package example.dao;

import java.util.ArrayList;
import java.util.List;

import example.container.Container;
import example.dto.Article;

public class ArticleDao {
	private List<Article> articles;
	private int lastId;
	
	public ArticleDao() {
		articles = new ArrayList<>();
		lastId = 0;
		
		testArticle();
	}

	private void testArticle() {
//		for(int i = 1; i <= 5; i++) {
//			add(1, "aaa"+i, "aaa"+i);
//		}
//		for(int i = 6; i <= 10; i++) {
//			add(2, "bbb"+i, "bbb"+i);
//		}
	}

	public int add(int memberId, String title, String body) {
		Article article = new Article();

		article.id = lastId + 1;
		article.title = title;
		article.body = body;
		article.memberId = memberId;

		articles.add(article);

		lastId = article.id;
		
		Container.session.articledId = article.id;
		
		return article.id;		
	}

	public List<Article> getArticles() {
		
		return articles;
	}

}
