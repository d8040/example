package example.controller;

import example.container.Container;
import example.member.Member;
import example.service.MemberService;

public class MemberController extends Controller {

	private MemberService memberService;

	public MemberController() {
		memberService = Container.memberService;
	}

	public void run(String cmd) {
		if (cmd.equals("member join")) {
			join(cmd);
		} else if (cmd.equals("member login")) {
			login(cmd);
		} else if (cmd.equals("member whoami")) {
			whoami(cmd);
		} else if (cmd.equals("member logout")) {
			logout(cmd);
		}
	}

	private void logout(String cmd) {
		if(Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요");
			return;
		}
		Container.session.logout();
		System.out.println("로그아웃 되었습니다.");
	}

	private void whoami(String cmd) {
		System.out.println("== 로그인 정보 ==");
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요");
			return;
		}
		int loginedMemberId = Container.session.loginedMemberId;

		Member loginedMember = memberService.getMemberById(loginedMemberId);
		System.out.println("아이디: " + loginedMember.loginId);
		System.out.println("이름: " + loginedMember.name);
	}

	String loginId;
	String loginPw;
	String name;

	private void login(String cmd) {
		System.out.println("== 로그인 ==");

		if (Container.session.isLogined()) {
			System.out.println(loginId + "님은 이미 로그인 중 입니다.");
			return;
		}
		int loginIdMaxCount = 3;
		int loginIdCount = 0;
		boolean loginIdIsValid = false;
		int loginPwMaxCount = 3;
		int loginPwCount = 0;
		boolean loginPwIsValid = false;

		Member member = null;

		while (true) {
			if (loginIdMaxCount <= loginIdCount) {
				System.out.println("로그인을 취소힙니다.");
				break;
			}
			System.out.printf("아이디: ");
			loginId = Container.sc.nextLine().trim();

			member = memberService.getMemberByloginId(loginId);

			if (loginId.length() == 0) {
				loginIdCount++;
				System.out.println("아이디를 입력해 주세요.");
				continue;
			}
			if (member == null) {
				loginIdCount++;
				System.out.println("등록된 아이디가 없습니다.");
				continue;
			}
			loginIdIsValid = true;
			break;
		}
		if (loginIdIsValid == false) {
			return;
		}
		while (true) {
			if (loginPwMaxCount <= loginPwCount) {
				System.out.println("로그인을 취소힙니다.");
				break;
			}
			System.out.printf("비밀번호: ");
			loginPw = Container.sc.nextLine().trim();
			if (loginPw.length() == 0) {
				loginPwCount++;
				System.out.println("비밀번호를 입력해 주세요.");
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
		System.out.println(member.name + "회원님, 반갑습니다.");
		Container.session.loginedMemberId = member.id;
	}

	private void join(String cmd) {
		System.out.println("== 회원가입 ==");

		System.out.printf("아이디: ");
		loginId = Container.sc.nextLine().trim();

		boolean isJoinableLoginId = memberService.isJoinableLoginId(loginId);

		if (isJoinableLoginId == false) {
			System.out.println(loginId + "(은)는 이미 사용중인 아이디입니다.");
			return;
		}

		System.out.printf("비밀번호: ");
		loginPw = Container.sc.nextLine().trim();

		System.out.printf("사용자이름: ");
		name = Container.sc.nextLine().trim();

		int id = memberService.join(loginId, loginPw, name);
		System.out.println(id + "번 회원님, 회원가입이 완료 되었습니다.");
	}

}
