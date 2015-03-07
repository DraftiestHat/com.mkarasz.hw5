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
		this.authors = setAuthors(authors, this.authors);
		this.retrievalDate = new GregorianCalendar(yearAccess, monthAccess, dayAccess);
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			System.out.println("Your URL is bad and you should feel bad!");
			System.exit(1);
		}
	}
	
	@Override
	public String toString(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		String sRet = "";
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		if(list == null){
			//System.out.println("ERROR: No author list.");
			//return;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			sRet += printName(currentAuthor) + " ";
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			sRet += printName(currentAuthor) + " AND ";
			currentAuthor = list.get(1);
			sRet += printName(currentAuthor) + ". ";
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				sRet += printName(currentAuthor) + ", ";
			}
			currentAuthor = list.get(list.size() - 1);
			sRet += "AND " + printName(currentAuthor) + ". ";
		}
		
		sRet += "" + this.title + ". (" + this.year + "). Retrieved " + months[this.retrievalDate.get(Calendar.MONTH)] + " " + this.retrievalDate.get(Calendar.DAY_OF_MONTH) + ", " + this.retrievalDate.get(Calendar.YEAR) + " from " + this.url.toString();
		return sRet;
		
		
	}
	
	private String printName(Author currentAuthor){
		String s = null;
		
		if(currentAuthor.getInitials() == null){
			s = currentAuthor.getLastName() + ", " + currentAuthor.getFirstName().substring(0, 1) + ".";
		}
		else
			s = currentAuthor.getLastName() + ", " + currentAuthor.getFirstName().substring(0, 1) + "." + currentAuthor.getInitials().toUpperCase();	
		
	
		return s;
	}
	
}
