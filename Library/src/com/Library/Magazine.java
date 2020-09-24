package com.Library;

public class Magazine extends Item {
	public enum Frequency{
		day,month,season,year
	}
	Frequency magazineFrequency;
	public String distributionCity;
	
	public Magazine(Frequency day, String dis, String id, String name, boolean b,Person borrower, double d) {
		super( id, name, b, borrower, d);
		this.magazineFrequency = day;
		this.distributionCity = dis;
	
	}

}
