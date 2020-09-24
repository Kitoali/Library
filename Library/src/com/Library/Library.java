package com.Library;
import java.util.ArrayList;
import java.util.Iterator;

 /* @author 计算机1802李杨
 *Version 1.0
 *date 2020-04-15
 */
@SuppressWarnings("serial")
public class Library extends ArrayList<Item>{       
    private int count=size();//记录所有物品的数量   
    Library(){    	    }
    /**
     *将新项目添加到库项目列表中。   
     * @param target 要添加到列表中的新项目。
     * @throws DuplicateItemException thrown 如果项目已经在列表中.
     */
	public void addItem(Item target) throws DuplicateItemException
	{
		if(contains(target))
			try {
				throw new DuplicateItemException("异常！物品已存在");
			}
		catch(DuplicateItemException e) {}
		else {
		super.add(target);
		}
	}
	/**
	 * @param id  传入物品id
	 * @throws ItemNotFoundException
	 * 要删除的物品 在列表中删除物品，首先判断列表中是否有此物品， 若有则调用父类remove函数
	 */
	public void deleteItem(String id) throws ItemNotFoundException 	{
		Item target = findItem(id);
		if (target != null){
			remove(position(target));
			setCount(getCount() - 1);
		}

	}

    /**
     * 将命名项目的状态更改为借用，并将人员添加到借用
     * 
     * @param id 借用物品的ID
     * @param newPerson 物品的借方
     * @throws ItemNotFoundException thrown if the id is not found.
     */
	public void loanItem(String id, Person newPerson) throws ItemNotFoundException
	{
		Item target = findItem(id);
		System.out.println(target);
		if (target != null)	{
			if (target.isLoaned()) {
				System.out.println("物品已被借出");
			}
			else
			{			 
		    		target.setLoaned(true);
		    		target.setBorrower(newPerson);
		    		if(target instanceof Book) {Book temp = (Book) target;set(position(target),temp);}
		    		else if(target instanceof Magazine) {Magazine temp = (Magazine) target;set(position(target),temp);;}
		    		else if(target instanceof DVD) {DVD temp = (DVD) target;set(position(target),temp);}
		    		else if(target instanceof Bluray) {Bluray temp = (Bluray) target;set(position(target),temp);}
		    		else if(target instanceof MusicCD) {MusicCD temp = (MusicCD) target;set(position(target),temp);}		    				
			}
		}
	}

    /**
     * changes the status of the named item to not borrowed and removes the user from the item.
     * The borrower (person) is returned to the caller
     * 将命名物品的状态更改为未借用，并将用户从项目中删除。借方（人）返回给呼叫者
     * @param id 物品id
     * @throws ItemNotFoundException thrown if the id is not found.
     */
    public void returnItem(String id) throws ItemNotFoundException {
    	Item target = findItem(id);
		System.out.println(target);
		if (target != null)	{
			if (target.isLoaned()) {		
		    		target.setLoaned(false);		
		    		target.setBorrower(null);
		    		if(target instanceof Book) {Book temp = (Book) target;set(position(target),temp);}
		    		else if(target instanceof Magazine) {Magazine temp = (Magazine) target;set(position(target),temp);;}
		    		else if(target instanceof DVD) {DVD temp = (DVD) target;set(position(target),temp);}
		    		else if(target instanceof Bluray) {Bluray temp = (Bluray) target;set(position(target),temp);}
		    		else if(target instanceof MusicCD) {MusicCD temp = (MusicCD) target;set(position(target),temp);}
			}
			else
				System.out.println("该物品未被借出");				
		}
    }
    /**
     * 通过给定的ID查找项目并返回该项目
     * @param id 返回的项目
     * @return 寻找的项目.
     * @throws ItemNotFoundException thrown if the id is not found.
     */
    public Item findItem(String id) throws ItemNotFoundException {
    	Item target = new Item(id);
    	if(searchItem(target)) {
    		Item item=super.get(position(target));
    		if(item instanceof Book) {Book temp = (Book) item;return temp;}
    		else if(item instanceof Magazine) {Magazine temp = (Magazine) item;return temp;}
    		else if(item instanceof DVD) {DVD temp = (DVD) item;return temp;}
    		else if(item instanceof Bluray) {Bluray temp = (Bluray) item;return temp;}
    		else if(item instanceof MusicCD) {MusicCD temp = (MusicCD) item;return temp;}
    	}
		return null;    	   	
    }

    /**
     * 获取项目的借方。如果找不到该项目，则抛出ItemNotFoundException。
     * @param id 项目的ID
     * @return 项目借方. 如果项目存在未借出返回null
     * @throws ItemNotFoundException thrown if the id is not found
     */
    public Person getBorrower(String id) throws ItemNotFoundException {
    	Item target = findItem(id);    	
             return target.getBorrower();
    }   
    /**
     * 检查是否借用了特定的图书馆物品。     * 
     * @param id 要检查的商品的ID。
     * @return 项目的状态，无论是否借用。
     * @throws ItemNotFoundException thrown if the id is not found.
     */
    public boolean isBorrowed(String id) throws ItemNotFoundException {    
    	Item target = findItem(id);
      return target.isLoaned();
    }
    
    /**
     * 根据给定的ID查找库项目的名称。
     * @param id 项目ID
     * @return 项目名称/未找到的项目名称为空白。
     * @throws ItemNotFoundException
     * 没有找到抛出异常
     */
    public String nameForID(String id) throws ItemNotFoundException {
     	Item target = findItem(id);
     	return 	target.getName();
    }    
    /**
     * 根据给定的名称返回库项目的ID。 
     * @param name 项目名称
     * @return 物品Id
     */
    public String IDForName(String name) {
     	Item target = new Item(name);
     	return 	target.getId();
    }
           
    /**
     * 将整个库转换为字符串。这应该调用ArrayList中每个项目的适当的toString方法。
     * 应采用以下格式
	 *Items.txt      
     */
     public String toString() {
          Iterator<Item> it=iterator();
          Item temp=new Item();
          String our=new String();
          String temp1=new String();
          our=null;
          while(it.hasNext()) {
              temp=it.next();
              temp1=temp.tostring();
              our=our+'\n'+temp1;
          }
          return our;
      }
         
    /**
     * 返回借出的项目总数。     * 
     * @return 该数字代表当前正在借出的物品数
     */
	public int countBorrowed() {
		int count=0;
		for (int i = 0; i < super.size(); i++) {
			Item current = super.get(i);
			if(current.isLoaned())
				count++;
		}
		return count;		
	}
    /**
     * 借出的项目数的百分比。表示为借出占项目总数的百分比。
     * @return the percentage borrowed.
     */
    public double percentageBorrowed() {
    	int count =super.size();
		System.out.println(count);
    	float percentage;
    	percentage = ((float)countBorrowed()/(float)count)*100;
      return percentage;
    }
    
    /**
     * @return 返回Blurays或DVD的项目数     * 
     */
    public int countMovies() {    	
	    int count=0;
	    for (int i = 0; i < super.size(); i++) {
			Item item = super.get(i);
			if(item instanceof Movie)
				count++;
		}
		return count;
	}
    
    
	/**
	 * @param target
	 *            要查找的物品
	 * @return true|false 是否包含该物品 遍历父类链表，若找到该物品，返回真，找不到则返回假
	 */
	private boolean contains(Item target) 
	{
		for (int i = 0; i < super.size(); i++) 
		{
			Item current = super.get(i);
			if (current.getId().equals(target.getId()))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * @param target
	 *            要寻找的物品
	 * @return true|false 是否找到该物品
	 * @throws ItemNotFoundException
	 *             没有找到的一场 在列表中查找物品 ，调用contains函数，若没有找到则抛出异常
	 */
	public boolean searchItem(Item target) throws ItemNotFoundException
	{
		if (this.contains(target))
		{
			return true;
		} 
		else 
		{
			try 
			{
				throw new ItemNotFoundException("没有找到物品");
			} 
			catch (ItemNotFoundException e) {	}
		}
		return false;
	}
	/**
	 * @param target
	 *            要查找位置的物品
	 * @return position 该物品的位置 遍历父类链表，标记某物品所在的位置
	 */
	protected int position(Item target)
	{
		for (int position = 0; position < super.size(); position++)
		{
			Item current = super.get(position);
			if (current.getId().equals(target.getId()))
			{
				return position;
			}
		}
		return -1;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
    
}

