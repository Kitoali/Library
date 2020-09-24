package com.Library;

public class Movie extends Item{
	public enum Genre{
		scifi, action, drama, romance
	}
	Genre genre;
	public Movie(Genre genre, String id, String name, boolean b,Person borrower, double d) {
		super( id, name, b, borrower, d);
		this.genre = genre;
	}
	public Movie(Genre genre) {
		this.genre = genre;
	}
	public Genre getGenre() {
		return genre;
	}
}
