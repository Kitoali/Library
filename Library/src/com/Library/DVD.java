package com.Library;

public class DVD extends Movie {
	public int region;
	public DVD(int region, Genre genre, String id, String name, boolean b,Person borrower, double d) {
		super( genre, id, name, b, borrower, d);
		this.region = region;
	}

}
