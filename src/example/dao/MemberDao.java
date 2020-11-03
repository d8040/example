package example.dao;

import java.util.ArrayList;
import java.util.List;

import example.dto.Member;

public class MemberDao {
	private List<Member> members;
	private int lastId;
	
	public MemberDao(){
		members = new ArrayList<>();
		lastId = 0;
		
		for (int i = 0; i < 3; i++) {
			join("user"+i, "user"+i, "user"+i);
		}
	}
	
	public int join(String loginId, String loginPw, String name) {
		Member member = new Member();
		
		member.id = lastId +1;
		member.loginId = loginId;
		member.loginPw = loginPw;
		member.name = name;
		lastId = member.id;
		
		members.add(member);
		
		return member.id;
	}

	public Member getMemberByLoginId(String loginId) {
		for (Member member : members) {
			if(member.loginId.equals(loginId)) {
				return member;
			}
		}
		return null;
	}
}
