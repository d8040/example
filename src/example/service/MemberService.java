package example.service;

import example.dao.MemberDao;
import example.dto.Member;

public class MemberService {

	MemberDao memberDao = new MemberDao();
	
	public int join(String loginId, String loginPw, String name) {
		return memberDao.join(loginId, loginPw, name);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

}
