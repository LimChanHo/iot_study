package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.UserInfo;
import com.test.service.UserService;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		
		//request도 map을 가지고 있으며 
		//keyset의 iterator를 사용하여 while문(반복문)을 돌리게 되면
		//키값과 밸류값을 자동으로 받아 올 수 있다.
		Map<String, String[]> reqMap = req.getParameterMap();
		System.out.println(reqMap);
		Iterator<String> it = reqMap.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
//			System.out.println(key + "," + reqMap.get(key)[0]);
		}

		String userNum = req.getParameter("usernum");
		String userId = req.getParameter("userid");
		String userPwd = req.getParameter("userpwd");
		String userName = req.getParameter("username");
		String address = req.getParameter("address");
		String hp1 = req.getParameter("hp1");
		String hp2 = req.getParameter("hp2");
		String hp3 = req.getParameter("hp3");
		String age = req.getParameter("age");
		UserInfo ui = new UserInfo();
		if(userNum!=null){
			ui.setUserNum(Integer.parseInt(userNum));
		}
		ui.setUserId(userId);
		ui.setUserPwd(userPwd);
		ui.setUserName(userName);
		ui.setAddress(address);
		ui.setHp1(hp1);
		ui.setHp2(hp2);
		ui.setHp3(hp3);
		if(age!=null){
			ui.setAge(Integer.parseInt(age));
		}
		// html화면에서 던진 값을 각각 String 변수로 받기 시작
		String command = req.getParameter("command");
		if (command == null) {
			return;
		}
		// UserService에 있는 insertUser(HashMap hm)이라는 함수를 호출하기 위해
		// UserService로 us 레퍼런스 변수를 생성
		UserService us = new UserService();
		if (command.equals("LOGIN")){
			String result = us.loginUser(ui);
			doProcess(resq, result);
		}else if (command.equals("SIGNIN")) {
			// 위에서 생성한 us레퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
			// 위에서 생성하고 값을 저장한 HashMap인 hm레퍼런스 변수를 같이 던짐
			if (us.insertUser(ui)) {
				doProcess(resq, "저장 잘 됬꾸만!!!!");
			} else {
				doProcess(resq, "값 똑바로 입력 안하냐잉~");
			}
		} else if (command.equals("DELETE")) {
			boolean isDelete = us.deleteUser(ui);
			String result = "";
			if(isDelete){
				result = "삭제 됬다!!";
			}else{
				result = "안됬네 안됬어!!";
			}
			doProcess(resq, result);
		} else if (command.equals("UPDATE")) {
			boolean isUpdate = us.updateUser(ui);
			String result = "";
			if(isUpdate){
				result = "수정 됬다!!";
			}else{
				result = "수정 안됬네 안됬어!!";
			}
			doProcess(resq, result);
		} else if (command.equals("SELECT")) {
			System.out.println("이름 : " + userName);
			if (userName != null && !userName.equals("")) {
				ui.setUserName("%" + userName + "%");
			}
			List<UserInfo> userList  = us.selectUser(ui);
			String result="번호{/}이름{/}아이디{/}나이{+}";
			result+="dis{/}en{/}en{/}en{+}";
			for(UserInfo ui2 : userList){
				result += ui2.getUserNum() + "{/}" + ui2.getUserName() + "{/}" + ui2.getUserId() + "{/}" + ui2.getAge()+ "{+}"; 
			}
			result = result.substring(0, result.length()-3);
			doProcess(resq, result);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {
		System.out.println("1");
	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
		
		String str = "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>";
				str += "<html>";
				str += "<head>";
				out.print(str);
//<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
//<title>Insert title here</title>
//</head>
//<body>
//<%
//out.println('아마추어같이 왜이래??');
//%>
//</body>
//</html>'

	}
}