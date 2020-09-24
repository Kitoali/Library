package com.Library;

public class Book extends Item {
		public String author;
		public Book(String author, String id, String name, boolean b,Person borrower, double d) {
			super( id, name, b, borrower, d);
			this.author = author;
		}

}
