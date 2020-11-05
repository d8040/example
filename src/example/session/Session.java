package example.session;

public class Session {

	public int loginedMemberId;
	public int articledId;

	public boolean isLogined() {
		if(loginedMemberId != 0) {
			return true;
		}
		return false;
	}

	public void logout() {
		loginedMemberId = 0;
	}

}
