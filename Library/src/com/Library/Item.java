package com.Library;
public class Item {
	public String id;
	public String name;
	public boolean loaned = false;
	public Person borrower = null;
	public double cost;
	public String retieved=null;
	
	public Item(String id, String name, boolean b,Person borrower, double d) {
		super();
		this.id = id;
		this.name = name;
		this.loaned = b;
		this.borrower = borrower;
		this.cost = d;
	}
	public Item(String id,Person borrower) {
		this.id = id;
		this.borrower = borrower;
	}
	public Item(String id) {
		super();
		this.id = id;
	}
	public Item() {
		this("","",false,null,0.00);
	}
	
	public String finditem(Item target) {
    	  		return "Not Found";
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public double getCost() {
		return cost;
	}
	public Person getBorrower() {
		return borrower;
	}
	public boolean isLoaned() {
		return loaned;
	}
	public void setBorrower(Person person) {
		this.borrower = person;
	}
	public void setCost(float cost) {
		this.cost = cost;		
	}
	public void setLoaned(boolean b) {
		this.loaned = b;
	}
	public void setName(String n) {
		this.name = n;
	}
    public String tostring(){
        String name1;
        name1=this.getClass().getSimpleName();
        if (borrower!=null)
        {
            name1=name1+'['+"region"+'='+name+','+'='+"Movie"+'['+"genre"+'='+name+','+"Item"+'['+"id"+'='+id+','+"name"+'='+name+"loaned"+'='+loaned+','+"borrower"+borrower.name+','+"cost"+cost+']'+']'+']';
        }
        else {
            name1=name1+'['+"region"+'='+name+','+'='+"Movie"+'['+"genre"+'='+name+','+"Item"+'['+"id"+'='+id+','+"name"+'='+name+"loaned"+'='+loaned+','+"borrower"+borrower+','+"cost"+cost+']'+']'+']';
        }
        return name1;
    }
}
