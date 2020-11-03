package example.container;

import java.util.Scanner;

import example.dao.MemberDao;
import example.service.MemberService;
import example.session.Session;

public class Container {

	public static Scanner sc;
	public static MemberService memberService;
	public static MemberDao memberDao;
	public static Session session;
	
	static {
		sc = new Scanner(System.in);
		memberService = new MemberService();
		memberDao = new MemberDao();
		session = new Session();
	}

}
