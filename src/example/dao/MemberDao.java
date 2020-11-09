package example.dao;

import java.util.ArrayList;
import java.util.List;

import example.dto.Member;

public class MemberDao {

	private List<Member> members;
	private int lastId;

	public MemberDao() {
		members = new ArrayList<>();
		lastId = 0;
	}

	public int join(String loginId, String loginPw, String name) {
		Member member = new Member();
		member.id = lastId + 1;
		member.loginId = loginId;
		member.loginPw = loginPw;
		member.name = name;

		members.add(member);

		lastId = member.id;

		return member.id;
	}

	public Member getMemberByLoginId(String loginId) {
		for(Member member : members) {
			if(member.loginId.equals(loginId)) {
				return member;
			}
		}
		return null;
	}

	public Member getMemberById(int loginedId) {
		for(Member member : members) {
			if(member.id == loginedId) {
				return member;
			}
		}
		return null;
	}

}
