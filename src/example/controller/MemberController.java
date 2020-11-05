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
		} else if (cmd.equals("member login")) {
			login(cmd);
		} else if (cmd.equals("member logout")) {
			logout(cmd);
		}else if (cmd.equals("member whoami")) {
			whoami(cmd);
		}
	}

	private void whoami(String cmd) {
		System.out.println("== 회원 정보 ==");
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요");
			return;
		}
		int loginedMemberId = Container.session.loginedMemberId;
		
		Member loginedMember = memberService.getMemberById(loginedMemberId);
		System.out.println("아이디: "+ loginedMember.loginId);
		System.out.println("이름: "+ loginedMember.name);
	}

	private void logout(String cmd) {
		System.out.println("== 로그아웃 ==");
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요");
			return;
		}
		Container.session.logout();
	}

	private void login(String cmd) {
		System.out.println("== 로그인 ==");

		System.out.printf("아이디: ");
		String loginId = Container.sc.nextLine().trim();

		Member member = memberService.getMemberByloginId(loginId);

		if (member == null) {
			System.out.println("로그인 아이디가 존재하지 않습니다.");
			return;
		}

		System.out.printf("비밀번호: ");
		String loginPw = Container.sc.nextLine().trim();

		if (member.loginPw.equals(loginPw) == false) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		Container.session.loginedMemberId = member.id;
		System.out.println(member.name + "님 반갑습니다.");
	}

	private void join(String cmd) {
		System.out.println("== 회원가입 ==");

		System.out.printf("아이디: ");
		String loginId = Container.sc.nextLine().trim();

		System.out.printf("비밀번호: ");
		String loginPw = Container.sc.nextLine().trim();

		System.out.printf("사용자이름: ");
		String name = Container.sc.nextLine().trim();

		int id = memberService.join(loginId, loginPw, name);
		System.out.println(id + "번 회원 가입");

	}

}
