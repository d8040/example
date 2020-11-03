package example.controller;

import example.container.Container;
import example.dto.Member;
import example.service.MemberService;

public class MemberController {
	private MemberService memberService;

	public MemberController() {
		memberService = Container.memberService;
	}

	public void run(String cmd) {
		if (cmd.equals("member join")) {
			join(cmd);
		}
		if (cmd.equals("member login")) {
			login(cmd);
		}
	}

	private void login(String cmd) {
		System.out.println("== 로그임 ==");

		if (Container.session.isLogined()) {
			System.out.println("이미 로그인 되었습니다.");
			return;
		}

		int loginIdMaxCount = 3;
		int loginIdCount = 0;
		boolean loginIdIsValid = false;

		Member member = null;

		while (true) {
			if (loginIdMaxCount <= loginIdCount) {
				System.out.println("로그인을 취소합니다.");
				break;
			}
			System.out.printf("아이디: ");
			String loginId = Container.sc.nextLine().trim();

			if (loginId.length() == 0) {
				loginIdCount++;
				continue;
			}

			member = memberService.getMemberByLoginId(loginId);

			if (member == null) {
				loginIdCount++;
				System.out.println("등록된 아이디가 존재하지 않습니다.");
				continue;
			}
			loginIdIsValid = true;
			break;
		}
		if (loginIdIsValid == false) {
			return;
		}
		int loginPwMaxCount = 3;
		int loginPwCount = 0;
		boolean loginPwIsValid = false;
		while (true) {
			if (loginPwMaxCount <= loginPwCount) {
				System.out.println("로그인을 취소합니다.");
				break;
			}
			System.out.printf("비밀번호: ");
			String loginPw = Container.sc.nextLine().trim();

			if (loginPw.length() == 0) {
				loginPwCount++;
				continue;
			}

			if (member.loginPw.equals(loginPw) == false) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				loginPwCount++;
				continue;
			}
			loginPwIsValid = true;
			break;
		}
		if (loginPwIsValid == false) {
			return;
		}
		System.out.println(member.name + " 회원님, 로그인 되었습니다.");
		Container.session.loginedMemberId = member.id;
	}

	private void join(String cmd) {
		System.out.println("== 회원가입 ==");

		System.out.printf("아이디: ");
		String loginId = Container.sc.nextLine().trim();

		System.out.printf("비밀번호: ");
		String loginPw = Container.sc.nextLine().trim();

		System.out.printf("이름: ");
		String name = Container.sc.nextLine().trim();

		int id = memberService.join(loginId, loginPw, name);

		System.out.println(id + "번 회원님 가입을 환영합니다.");

	}

}
