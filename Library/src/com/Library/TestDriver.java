package com.Library;
/**
 * @author 计算机1802 李杨
 *Version1.0
 *date 2020-04-25
 */
public class TestDriver {

	public void runTestAddItem() {		
		System.out.println("***Testing addItem***");
		{
			System.out.println("-Test add an item and see if it is in the list-");
			String expected = "Found";
			System.out.println("Expected <"+expected+">");
			//Do the Test
			Library l1 = new Library();
			Item retrieved = null;
			String result = "";
			try {
				l1.addItem(new Magazine(Magazine.Frequency.day, "New York","ID001","Vanity Not So Faire", false, null, 5.95));
				retrieved = l1.findItem("ID001");
				//此处是为了完整性，以及是否有人编写其他测试并将其用作示例。
				//findItem绝不应该返回null，但是当库代码出现问题时，它将覆盖一个事件。
				result = retrieved != null? "Found":"Not Found";
			} catch (DuplicateItemException e) {
				result = "Failed Duplicate Found";
			} catch (Exception e) {
				result = "Failed Exception Thrown";
			}			
			System.out.println("Got <"+result+">");	
			if (result.equals(expected)) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}
		}

		{
			System.out.println("-Test add an item with a duplicate see if it throws an exception-");
			String expected = "Failed Duplicate Found";
			System.out.println("Expected <"+expected+">");
			//Do the Test
			Library l1 = new Library();
			Item retrieved = null;
			String result = "";
			try {
				l1.addItem(new Magazine(Magazine.Frequency.day, "New York","ID001","Vanity Not So Faire", false, null, 5.95));
				l1.addItem(new Magazine(Magazine.Frequency.day, "New Jersey","ID001","Vanity Not So Faire", false, null, 5.95));
				retrieved = l1.findItem("ID001");
				result = retrieved != null? "Found":"Not Found";
			} catch (DuplicateItemException e) {
				result = "Failed Duplicate Found";
			} catch (Exception e) {
				result = "Failed Exception Thrown";
			}			
			System.out.println("Got <"+result+">");	
			if (result.equals(expected)) {
				System.out.println("Success");
			} else {

				System.out.println("Failed");
			}
		}
		//You need to write lots of tests here. 
	}
	public void runTestAddBorrower() {
		System.out.println("***Testing addBorrower***");
		{
			System.out.println("-Test loan an item and see if borrower is in the list-");
			String expected = "Found";
			System.out.println("Expected <"+expected+">");
			//Do the Test
			Library l1 = new Library();
			Person retrieved = null;
			String result = "";
			try {
				l1.addItem(new Magazine(Magazine.Frequency.day, "New York","ID001","Vanity Not So Faire", false, null, 5.95));
				l1.loanItem("ID001",new Person("Stewart","Mawson Lakes"));
				retrieved = l1.findItem("ID001").borrower ;
					
				//此处是为了完整性，以及是否有人编写其他测试并将其用作示例。
				//findItem绝不应该返回null，但是当库代码出现问题时，它将覆盖一个事件。
				result = retrieved != null? "Loaned":"Not Loaned";
			} catch (ItemNotFoundException e) {
				result = "Failed Found Loaned";
			} catch (Exception e) {
				result = "Failed Exception Thrown";
			}			
			System.out.println("Got <"+result+">");	
			if (result.equals(expected)) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}
		}
	}
	public void runTestCountBorrowed() {
		System.out.println("***Testing countBorrowed***");
		{
			System.out.println("-Test loan an item and see if borrower is in the list-");
			String expected = "Found";
			System.out.println("Expected <"+expected+">");
			//Do the Test
			Library l1 = new Library();
			int retrieved = 0;
			String result = "";
			try {
				l1.addItem(new Magazine(Magazine.Frequency.day, "New York","ID001","Vanity Not So Faire", false, null, 5.95));
				l1.loanItem("ID001",new Person("Stewart","Mawson Lakes"));
				retrieved = l1.countBorrowed();
				//此处是为了完整性，以及是否有人编写其他测试并将其用作示例。
				//findItem绝不应该返回null，但是当库代码出现问题时，它将覆盖一个事件。
				result = retrieved != 0? "count":"Not count";
			} catch (ItemNotFoundException e) {
				result = "Failed count";
			} catch (Exception e) {
				result = "Failed Exception Thrown";
			}			
			System.out.println("Got <"+result+">");	
			if (result.equals(expected)) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}
		}
	}
	public static void main(String[] args) {
		TestDriver td = new TestDriver();

		td.runTestAddItem();
		td.runTestAddBorrower();
		td.runTestCountBorrowed();
		//添加更多测试方法
		td.arbitraryTestCode();
	}
	public void arbitraryTestCode() {
		Library l1 = new Library();
		Person p1 = null;
		try {
			p1 = new Person("Stewart","Mawson Lakes Blvd");
		}
		catch (Exception e1) {			
			e1.printStackTrace();
		}			
		int id=0;
		try {
			Item[] testSubjects = {
					new Magazine(Magazine.Frequency.day, "San Andreas", "ID00"+id++,"Vanity Not So Faire", false, null, 5.95),
					new Magazine(Magazine.Frequency.day,  "San Andreas", "ID00"+id++,"Click", false, null, 5.95),
					new Magazine(Magazine.Frequency.day,  "San Andreas", "ID00"+id++,"Renovate", false, null, 5.95),
					new Magazine(Magazine.Frequency.day,  "San Andreas","ID00"+id++,"Madrid", false, null, 5.95),
					new Magazine(Magazine.Frequency.day,  "San Andreas","ID00"+id++,"Bikes", false, null, 5.95),
					new MusicCD("Rudy Vale","Valen","ID00"+id++,"Gatewars Soundtrack",false,null,19.95),
					new MusicCD("Rudy Vale The Third","Valen","ID00"+id++,"Gatewars 2 Soundtrack",false,null,19.95),
					new MusicCD("Rudy Vale Sr","Valen","ID00"+id++,"Gatewars 3 Soundtrack",false,null,19.95),
					new MusicCD("Rudy Vale Jr","Valen","ID00"+id++,"Gatewars 4 Soundtrack",false,null,19.95),
					new MusicCD("Not Rudy Vale","Valen","ID00"+id++,"Gatewars 5 Soundtrack",false,null,19.95),
					new MusicCD("Rudy Vale","Not Valen","ID00"+id++,"Gatewars 6 Soundtrack",false,null,19.95),
					new Bluray('c',Bluray.Genre.drama,"ID00"+id++,"Gatewars 1 Revenge of the Fallen",false,null,29.95),
					new Bluray('c',Bluray.Genre.drama,"ID00"+id++,"Gatewars 2 Ponies Are Ridden",false,null,29.95),
					new Bluray('c',Bluray.Genre.drama,"ID00"+id++,"Gatewars 3 Sequels are Lame",false,null,29.95),
					new Bluray('c',Bluray.Genre.drama,"ID00"+id++,"Gatewars 3 But They Keep Making Them",false,null,29.95),
					new Bluray('c',Bluray.Genre.drama,"ID00"+id++,"Gatewars 5 They Make More Than is Reasonable",false,null,29.95),
					new DVD(1,DVD.Genre.scifi,"ID00"+id++,"Darth Yobbit and the Range Runners",false,null,29.95),
					new DVD(1,DVD.Genre.scifi,"ID00"+id++,"Darth Yobbit and the Long Jumpers",false,null,29.95),		
					new DVD(1,DVD.Genre.scifi,"ID00"+id++,"Darth Yobbit and the Domain Walkers",false,null,29.95),		
					new DVD(1,DVD.Genre.scifi,"ID00"+id++,"Darth Yobbit and the KiloByte",false,null,29.95),		
					new DVD(1,DVD.Genre.scifi,"ID00"+id++,"Darth Yobbit and the Rabbits",false,null,29.95),		
					new Book("Arthur C Clarke","ID00"+id++,"The City and The Stars",false,null,14.50),
					new Book("Arthur C Clarke","ID00"+id++,"Rendevous With Rama",false,null,14.50),
					new Book("Arthur C Clarke","ID00"+id++,"2001",false,null,14.50)
			};

			for (int i=0;i<testSubjects.length;i++) {
				try {
					l1.addItem(testSubjects[i]);
				} catch(DuplicateItemException ex) {
					System.err.println(ex);
				}
			}
			System.out.println("******");
		
			System.out.println(l1);
			System.out.println("Should say false "+l1.isBorrowed("ID0022"));
			l1.loanItem("ID0022", new Person("Stewart","Mawson Lakes"));
			System.out.println("Should say false "+l1.isBorrowed("ID0020"));
			System.out.println("Should say true "+l1.isBorrowed("ID0022"));//loanItem()未正常运行
			System.out.println("Should say Mawson Lakes " + l1.getBorrower("ID0022").getAddress());
			System.out.println("******");

			//Various get datas from items
			System.out.println(l1.findItem("ID0020").getName());
			System.out.println(l1.findItem("ID0020").getId());
			System.out.println(l1.findItem("ID0020").getCost());
			System.out.println(l1.findItem("ID0020").getBorrower());
			System.out.println("Should be false "+l1.findItem("ID0020").isLoaned());
			l1.findItem("ID0020").setBorrower(new Person("AAA","ADDRESS"));
			l1.findItem("ID0020").setLoaned(true);
			System.out.println("Should be true "+l1.findItem("ID0020").isLoaned());
		
			l1.findItem("ID0020").setCost(99.99f);
			l1.findItem("ID0020").setLoaned(false);
			l1.findItem("ID0020").setName("Changed Name");
			System.out.println(l1.findItem("ID0020"));
			System.out.println("******");

		try {
				System.out.println(l1.findItem("ID006"));
			} 
			catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("******");
			
			System.out.println("Number Borrowed "+l1.countBorrowed());
			System.out.printf("Percentage Borrowed %5.2f%% \n",l1.percentageBorrowed());
			try {
				l1.loanItem("ID001", p1);
				l1.loanItem("ID003", p1);
				l1.loanItem("ID004", p1);
				l1.loanItem("ID009", p1);
			}
			catch (ItemNotFoundException e) {
				e.printStackTrace();
			}			
			System.out.println("Should say true "+l1.isBorrowed("ID009"));
			System.out.println("Should say Mawson Lakes " + l1.getBorrower("ID009").getAddress());

			System.out.println("******");
			System.out.println("Number Borrowed Should say 5 "+l1.countBorrowed());
			System.out.printf("Percentage Borrowed %5.2f%% \n",l1.percentageBorrowed());
			System.out.println("Should say 10 "+l1.countMovies());
		} catch (Exception ex) {
			System.err.println("Exception Found in Input "+ex.getMessage());
		}
	}
	
}
