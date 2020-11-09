package example;

import example.container.Container;
import example.controller.ArticleController;
import example.controller.Controller;
import example.controller.MemberController;
import example.service.ArticleService;
import example.service.MemberService;

public class App {

	private MemberController memberController;
	private ArticleController articleController;

	public App() {
		memberController = Container.memberController;
		articleController = Container.articleController;
		
		testData();
		init();
		
	}

	private void init() {
		ArticleService articleService = Container.articleService;
		Container.session.selectBoardId = articleService.getDefaultBoardId();
		
	}

	private void testData() {
		MemberService memberService = Container.memberService;
		int firstMemberId = memberService.join("aaa", "aaa", "aaa");
		int secondMemberId = memberService.join("bbb", "bbb", "bbb");
		
		ArticleService articleService = Container.articleService;
		int noteBoardId = articleService.makeBoard("공지사항");
		int freeBoardId = articleService.makeBoard("자유");
		
		for (int i = 1; i <=5; i++) {
			articleService.add(firstMemberId, noteBoardId, "제목"+i, "내용"+i);
		}
		for (int i = 6; i <=10; i++) {
			articleService.add(secondMemberId, freeBoardId, "제목"+i, "내용"+i);
		}
	}

	public void run() {
		while (true) {
			System.out.printf("명령어) ");
			String cmd = Container.sc.nextLine();

			Controller controller = getControllerByCmd(cmd);
			controller.run(cmd);
		}
	}

	private Controller getControllerByCmd(String cmd) {
		if(cmd.startsWith("member ")) {
			return memberController;
		}
		if(cmd.startsWith("article ")) {
			return articleController;
		}
		return null;
	}

}
