package example.controller;

import java.util.List;

import example.container.Container;
import example.dto.Article;
import example.dto.Board;
import example.dto.Member;
import example.service.ArticleService;
import example.service.MemberService;

public class ArticleController extends Controller {

	private ArticleService articleService;
	private MemberService memberService;

	public ArticleController() {
		articleService = Container.articleService;
		memberService = Container.memberService;
	}

	public void run(String cmd) {
		if (cmd.equals("article makeBoard")) {
			makeBoard(cmd);
		} else if (cmd.startsWith("article selectBoard")) {
			selectBoard(cmd);
		} else if (cmd.startsWith("article add")) {
			add(cmd);
		} else if (cmd.startsWith("article list")) {
			list(cmd);
		}
	}

	private void list(String cmd) {
		int boardId = Container.session.selectBoardId;
		List<Article> articles = articleService.getArticles();

		Board board = articleService.getBoardById(boardId);
		System.out.printf("== %s 게시판 리스트 ==\n",board.name);
		
		for (Article article : articles) {
			if (boardId == article.boardId) {
				Member member = memberService.getMemberById(article.memberId);
				System.out.printf("%d / %s / %s\n", article.id, member.name, article.title);
			}
		}

	}

	private void add(String cmd) {
		System.out.println("== 게시물 등록 ==");

		System.out.printf("제목: ");
		String title = Container.sc.nextLine().trim();

		System.out.printf("내용: ");
		String body = Container.sc.nextLine().trim();

		int boardId = Container.session.selectBoardId;
		int memberId = Container.session.loginedId;

		int id = articleService.add(boardId, memberId, title, body);
		System.out.println(id + "번 게시물이 생성되었습니다.");
	}

	private void selectBoard(String cmd) {
		int boardId = Integer.parseInt(cmd.split(" ")[2]);

		Board board = articleService.getBoardById(boardId);

		if (board == null) {
			System.out.println("게시판이 존재하지 않습니다.");
			return;
		}

		System.out.printf("%s 게시판으로 변경합니다.\n", board.name);
		Container.session.selectBoardId = board.id;
	}

	private void makeBoard(String cmd) {
		System.out.println("== 게시판 등록 ==");

		System.out.printf("게시판이름: ");
		String name = Container.sc.nextLine().trim();

		int id = articleService.makeBoard(name);

		System.out.printf("%s(%d번)게시판이 생성 되었습니다.\n", name, id);
	}

}
