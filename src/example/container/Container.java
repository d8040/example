package example.container;

import java.util.Scanner;

import example.controller.ArticleController;
import example.controller.MemberController;
import example.dao.ArticleDao;
import example.dao.MemberDao;
import example.service.ArticleService;
import example.service.MemberService;
import example.session.Session;

public class Container {

	public static Scanner sc;
	public static Session session;
	public static MemberDao memberDao;
	public static ArticleDao articleDao;
	public static MemberService memberService;
	public static ArticleService articleService;
	public static MemberController memberController;
	public static ArticleController articleController;
	
	static {
		sc = new Scanner(System.in);
		session = new Session();
		memberDao = new MemberDao();
		articleDao = new ArticleDao();
		memberService = new MemberService();
		articleService = new ArticleService();
		memberController = new MemberController();
		articleController = new ArticleController();
	}

}
