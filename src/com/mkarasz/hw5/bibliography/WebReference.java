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
	
	/**
	 * Default constructor
	 */
	public WebReference(){
		this(null, null, 0, 0, 0, 0, null);
	}
	
	/**
	 * Constructor to set everything except authors
	 * @param title title of webpage
	 * @param year year webpage was put up
	 * @param monthAccess month web site was accessed
	 * @param dayAccess day web site was accessed
	 * @param yearAccess year web site was accessed
	 * @param url the url of the website
	 */
	public WebReference(String title, int year,  int monthAccess, int dayAccess, int yearAccess, String url){
		this(title, null, year, monthAccess, dayAccess, yearAccess, url);
	}
	
	/**
	 * Constructor to set everything
	 * @param title title of webpage
	 * @param authors the authors of the webpage
	 * @param year year webpage was put up
	 * @param monthAccess month web site was accessed
	 * @param dayAccess day web site was accessed
	 * @param yearAccess year web site was accessed
	 * @param url the url of the website
	 */
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
	
	/** Returns a string that prints the name correctly.
	 * @param currentAuthor the author to print
	 * @return the name in the right format
	 */
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
