package com.test.dto;

public class Test {

	private String num;
	private String name;
	private String command;
	private Struct struct;
	
	@Override
	public String toString() {
		return "Test [num=" + num + ", name=" + name + ", command=" + command + ", struct=" + struct + "]";
	}
	
	public Struct getStruct() {
		return struct;
	}

	public void setStruct(Struct struct) {
		this.struct = struct;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
}
