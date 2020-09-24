package com.Library;

public class MusicCD extends Item {
	public String comeposer;
	public String arist;

	public MusicCD(String comeposer, String arist, String id, String name, boolean b,Person borrower, double d) {
		super( id, name, b, borrower, d);
		this.comeposer = comeposer;
		this.arist = arist;
	}

}
