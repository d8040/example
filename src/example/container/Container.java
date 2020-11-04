package example.container;

import java.util.Scanner;

import example.dao.ArticleDao;
import example.dao.MemberDao;
import example.service.ArticleService;
import example.service.MemberService;
import example.session.Session;

public class Container {

	public static Scanner sc;
	
	public static Session session;

	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	
	public static MemberService memberService;
	public static ArticleService articleService;

	static {
		sc = new Scanner(System.in);
		
		session = new Session();

		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		
		memberService = new MemberService();
		articleService = new ArticleService();
	}

}
