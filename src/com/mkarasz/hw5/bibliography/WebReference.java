package com.mkarasz.hw5.bibliography;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WebReference extends Bibliography {
	// NEEDS THREE CONSTRUCTORS
		
	protected GregorianCalendar retrievalDate;
	protected URL url;
	
	
	public WebReference(){
		this(null, null, 0, 0, 0, 0, null);
	}
	
	public WebReference(String title, int year,  int monthAccess, int dayAccess, int yearAccess, String url){
		this.title = title;
		this.year = year;
		this.retrievalDate = new GregorianCalendar(yearAccess, monthAccess, dayAccess);
		
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			System.out.println("Your URL is bad and you should feel bad!");
			System.exit(1);
		}
		this.authors = null;
	}
	
	public WebReference(String title, String authors, int year, int monthAccess, int dayAccess, int yearAccess, String url){
		this.title = title;
		this.year = year;
		this.authors = setAuthors(authors);
		this.retrievalDate = new GregorianCalendar(yearAccess, monthAccess, dayAccess);
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			System.out.println("Your URL is bad and you should feel bad!");
			System.exit(1);
		}
	}
	
	public void print(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		if(list == null){
			//System.out.println("ERROR: No author list.");
			//return;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			printName(currentAuthor);
			System.out.print(". ");
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			printName(currentAuthor);
			System.out.print(" AND ");
			currentAuthor = list.get(1);
			printName(currentAuthor);
			System.out.print(". ");
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
			System.out.print(". ");
		}
		
		System.out.println("" + this.title + "(" + this.year + "). Retrieved " + months[this.retrievalDate.get(Calendar.MONTH)] + " " + this.retrievalDate.get(Calendar.DAY_OF_MONTH) + ", " + this.retrievalDate.get(Calendar.YEAR) + " from " + this.url.toString());
		
		
	}
	
	private void printName(Author currentAuthor){
		if(currentAuthor.getInitials() == null){
			System.out.printf("%s, %s.", currentAuthor.getLastName().toUpperCase(), currentAuthor.getFirstName().substring(0, 1).toUpperCase());
		}
		else
			System.out.printf("%s, %s.%s", currentAuthor.getLastName().toUpperCase(), currentAuthor.getFirstName().substring(0, 1).toUpperCase(), currentAuthor.getInitials().toUpperCase());
	}
	
}
