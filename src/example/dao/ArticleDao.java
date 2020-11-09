package example.dao;

import java.util.ArrayList;
import java.util.List;

import example.dto.Article;
import example.dto.Board;

public class ArticleDao {

	private int boardLastId;
	private List<Board> boards;
	private int lastId;
	private List<Article> articles;
	
	public ArticleDao() {
		boardLastId = 0;
		boards = new ArrayList<>();
		lastId = 0;
		articles = new ArrayList<>();
	}

	public int makeBoard(String name) {
		Board board = new Board();
		board.id = boardLastId + 1;
		board.name = name;

		boards.add(board);

		boardLastId = board.id;

		return board.id;
	}

	public Board getBoardById(int boardId) {
		for (Board board : boards) {
			if(board.id == boardId) {
				return board;
			}
		}
		return null;
	}

	public int add(int boardId, int memberId, String title, String body) {
		Article article = new Article();
		article.id = lastId + 1;
		article.title = title;
		article.body = body;
		article.boardId = boardId;
		article.memberId = memberId;

		articles.add(article);

		lastId = article.id;

		return article.id;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public List<Board> getBoards() {
		return boards;
	}

}
