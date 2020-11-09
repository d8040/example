package example.session;

public class Session {

	public int loginedId;
	public int selectBoardId;

	public void logout() {
		loginedId = 0;
	}

}
