package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public abstract class Bibliography {
	protected ArrayList<Author> authors;
	protected int year;
	protected String title;
	
	
	/** Sets up the arrayList of authors
	 * @param authors - the authors to split up
	 * @param authorsArray the array to put the authors into
	 * @return the array the authors are in.
	 */
	protected ArrayList<Author> setAuthors(String authors, ArrayList<Author> authorsArray) {
		if(authors == null){
			return null;
		}
		
		ArrayList<Author> list = null;
		
		if(authorsArray == null){
			list = new ArrayList<Author>();
		}
		else
			list = authorsArray;
		
		 String[] s = authors.split(", ");
		 String[] hold;
		 
		 
		 if(s[0].equals(authors)){
			 s = authors.split(" and ");
			 if(s[0].equals(authors)){
				 list.add(new Author(s[0]));
			 }
			 else {
				 list.add(new Author(s[0]));
				 list.add(new Author(s[1]));
			 }
		 }
		 else {
			 for(int i = 0; i < s.length - 1; i++){
				 list.add(new Author(s[i]));
			 }
			 hold = s[s.length - 1].split("and ");
			 //System.out.println(hold[0] + " CHECK ME MOFO " + hold [1]);
			 list.add(new Author(hold[1]));
		 }
		 
		 return list;
	}
	
	/** Returns the year
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**Sets the year
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/** Returns the title
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**sets the title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}
