package com.test.dto;

public class UserInfo {
/*
 * `usernum` INT(5) NOT NULL AUTO_INCREMENT,
	`userid` VARCHAR(30) NOT NULL,
	`username` VARCHAR(100) NOT NULL,
	`age` INT(1) NOT NULL,
	`address` VARCHAR(200) NOT NULL,
	`hp1` CHAR(4) NULL DEFAULT NULL,
	`hp2` CHAR(4) NULL DEFAULT NULL,
	`hp3` CHAR(4) NULL DEFAULT NULL,
	`userpwd` VARCHAR(100) NOT NULL,
 */
	private int userNum;
	private String userId;
	private String userName;
	private int age;
	private String address;
	private String hp1;
	private String hp2;
	private String hp3;
	private String userPwd;
	
	public int getUserNum(){
		return userNum;
	}
	
	public void setUserNum(int userNum){
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHp1() {
		return hp1;
	}

	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}

	public String getHp2() {
		return hp2;
	}

	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}

	public String getHp3() {
		return hp3;
	}

	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}
