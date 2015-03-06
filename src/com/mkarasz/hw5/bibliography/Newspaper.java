package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Newspaper extends Bibliography {
	ArrayList<Author> authors;
	GregorianCalendar date;
	String Newspaper;
	
	public Newspaper(){
		this(null, null, null, null);
	}
	
	public Newspaper(String authors, String title, GregorianCalendar date, String Newspaper){
		this.authors = setAuthors(authors);
		this.date = date;
		this.title = title;
		this.Newspaper = Newspaper;
	}
	
	
	public void print(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		if(list == null){
			System.out.println("ERROR: No author list.");
			return;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			printName(currentAuthor);
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			printName(currentAuthor);
			System.out.print(" AND ");
			currentAuthor = list.get(1);
			printName(currentAuthor);
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				printName(currentAuthor);
				System.out.print(", ");
			}
			System.out.print("AND ");
			currentAuthor = list.get(list.size() - 1);
			printName(currentAuthor);
		}
	
			
		System.out.println(" " + months[this.date.get(Calendar.MONTH)] + " " + this.date.get(Calendar.DAY_OF_MONTH) + ", " + this.date.get(Calendar.YEAR) + ". " + this.title + ". " + this.Newspaper + ".");
		
	}
	
	
	
	
	
	
	
	
	private void printName(Author currentAuthor){
		if(currentAuthor.initials == null){
			System.out.printf("%s, %s.", currentAuthor.lastName.toUpperCase(), currentAuthor.firstName.substring(0, 1).toUpperCase());
		}
		else
			System.out.printf("%s, %s.%s.", currentAuthor.lastName.toUpperCase(), currentAuthor.firstName.substring(0, 1).toUpperCase(), currentAuthor.initials.toUpperCase());
	}
}
