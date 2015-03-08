package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Newspaper extends Bibliography {
	protected GregorianCalendar date;
	protected String Newspaper;
	
	/** Default constructor
	 * 
	 */
	public Newspaper(){
		this(null, null, 0, 0, 0, null);
	}
	
	/** Sets up newspaper.
	 * @param authors the authors to print
	 * @param title title of the article
	 * @param month the month the article was published
	 * @param day the day the article was published
	 * @param year the year the article was published
	 * @param Newspaper the newspaper that published the article
	 */
	public Newspaper(String authors, String title, int month, int day, int year, String Newspaper){
		this.authors = setAuthors(authors, this.authors);
		this.date = new GregorianCalendar(year, month, day);
		this.title = title;
		this.Newspaper = Newspaper;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		String retString = "";
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		if(list == null){
			System.out.println("ERROR: No author list.");
			return null;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			retString += printName(currentAuthor);
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			retString += printName(currentAuthor) + " AND ";
			currentAuthor = list.get(1);
			retString += printName(currentAuthor);
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				retString += printName(currentAuthor) + ", ";
			}
			retString += "AND ";
			currentAuthor = list.get(list.size() - 1);
			retString += printName(currentAuthor);
		}
	
			
		retString += " " + months[this.date.get(Calendar.MONTH)] + " " + this.date.get(Calendar.DAY_OF_MONTH) + ", " + this.date.get(Calendar.YEAR) + ". " + this.title + ". " + this.Newspaper + ".";
		return retString;
	}
	
	
	/** Returns a string that prints the name correctly.
	 * @param currentAuthor the author to print
	 * @return the name in the right format
	 */
	private String printName(Author currentAuthor){
		String s = null;
		if(currentAuthor.getInitials() == null){
			s = "" + currentAuthor.getLastName().toUpperCase() + ", " + currentAuthor.getFirstName().substring(0, 1).toUpperCase() + ".";
			
		}
		else
			s = currentAuthor.getLastName().toUpperCase() + ", " + currentAuthor.getFirstName().substring(0, 1).toUpperCase() + "." + currentAuthor.getInitials().toUpperCase();
		return s;
	}
}
