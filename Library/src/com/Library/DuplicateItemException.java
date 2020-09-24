package com.Library;
@SuppressWarnings("serial")
public class DuplicateItemException extends Exception {
	public DuplicateItemException(String message) {
		super(message);
		System.out.println("异常！物品已存在");
	}
}
