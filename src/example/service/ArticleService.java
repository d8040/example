package example.service;

import java.util.List;

import example.container.Container;
import example.dao.ArticleDao;
import example.dto.Article;
import example.dto.Board;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int makeBoard(String name) {
		return articleDao.makeBoard(name);
	}

	public Board getBoardById(int boardId) {
		return articleDao.getBoardById(boardId);
	}

	public int add(int boardId, int memberId, String title, String body) {
		return articleDao.add(boardId, memberId, title, body);
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

	public int getDefaultBoardId() {
		List<Board> boards = articleDao.getBoards();
		return boards.get(1).id;
	}
}
