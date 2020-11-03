package example;

import example.container.Container;
import example.controller.MemberController;

public class App {
	MemberController memberController = new MemberController();;

	public void run() {
		while (true) {
			System.out.printf("명령어) ");
			String cmd = Container.sc.nextLine();
			
			if (cmd.equals("exit")) {
				System.out.println("== 시스템 종료 ==");
				break;
			}
			else if (cmd.startsWith("member ")) {
				memberController.run(cmd);
			}
		}
	}
}
