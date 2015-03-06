package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public abstract class Bibliography {
	//ArrayList<Author> authors;
	int year;
	String title;
	
	/*protected ArrayList<Author> getAuthors() {
		return this.authors;
		/*int i = 0;
		String s = null;
		while(i < this.authors.size()){
			//System.out.println(this.authors.size() + " ");
			if(s == null)
				s = this.authors.get(i).toString() + " "; 
			else
				s += this.authors.get(i).toString() + " ";
			i++;
		}
		
		return s;
	}*/
	protected ArrayList<Author> setAuthors(String authors) {
		 ArrayList<Author> list = new ArrayList<Author>();
		 
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
