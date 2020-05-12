package connplantsTest.connplantsTest;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<User> getResult() {
		return result;
	}
	public void setResult(List<User> result) {
		this.result = result;
	}
	List<User> result;

    //getters and setters

}