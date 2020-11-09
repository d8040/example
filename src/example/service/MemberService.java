package example.service;

import example.container.Container;
import example.dao.MemberDao;
import example.dto.Member;

public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		memberDao = Container.memberDao;
	}

	public int join(String loginId, String loginPw, String name) {
		return memberDao.join(loginId, loginPw, name);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int loginedId) {
		return memberDao.getMemberById(loginedId);
	}

}
