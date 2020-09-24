package com.Library;

public class Bluray extends Movie {
	public char region;
	public Bluray	(char region, Genre genre, String id, String name, boolean b,Person borrower, double d) {
		super( genre, id, name, b, borrower, d);
		this.region = region;
	}

}
