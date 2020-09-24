package com.Library;
/**
 * 异常
 * @author 轩宇
 */
@SuppressWarnings("serial")
public class ItemNotFoundException extends Exception {
	public ItemNotFoundException(String message) {
		super(message);
		System.out.println("异常！未找到物品");
	}
}
