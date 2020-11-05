package example;

import example.container.Container;
import example.controller.ArticleController;
import example.controller.MemberController;

public class App {

	private MemberController memberController;
	private ArticleController articleController;
	
	public App() {
		memberController = Container.memberController;
		articleController = Container.articleController;
	}

	public void run() {
		while(true) {
			System.out.printf("명령어) ");
			String cmd = Container.sc.nextLine();
			
			if (cmd.startsWith("member ")) {
				memberController.run(cmd);
			}
			else if (cmd.startsWith("article ")) {
				articleController.run(cmd);
			}
		}
	}

}
