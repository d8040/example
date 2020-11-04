package example;

import example.container.Container;
import example.controller.ArticleController;
import example.controller.Controller;
import example.controller.MemberController;

public class App {

	private MemberController memberController;
	private ArticleController articleController;

	public App() {		
		memberController = new MemberController();
		articleController = new ArticleController();
	
	}

	public void run() {
		while (true) {
			System.out.printf("명령어) ");
			String cmd = Container.sc.nextLine();

			if (cmd.equals("exit")) {
				System.out.println("== 시스템 종료 ==");
				break;
			}
			Controller controller = getControllerByCmd(cmd);
			controller.run(cmd);

		}
	}

	private Controller getControllerByCmd(String cmd) {

		if (cmd.startsWith("member ")) {
			return memberController;
		} else if (cmd.startsWith("article ")) {
			return articleController;
		}
		return null;
	}

}
