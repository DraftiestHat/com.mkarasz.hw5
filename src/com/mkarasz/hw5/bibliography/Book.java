package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public class Book extends Bibliography {
	protected String publisher;
	protected String publicationCity;
	protected String publicationState;
	protected int numberOfPages;
	
	/**
	 * Default constructor.
	 */
	public Book(){
		this(null, 0, null, null, null, null, 0);
	}
	
	/** Constructor that sets everything
	 * @param authors the authors of the book
	 * @param year the year the book was published
	 * @param title the title of the book
	 * @param publisher the publisher of the book
	 * @param publicationCity city where the book was published
	 * @param publicationState state where book was published
	 * @param numberOfPages number of pages in the book
	 */
	public Book(String authors, int year, String title, String publisher, String publicationCity, String publicationState, int numberOfPages){
		this.authors = super.setAuthors(authors, this.authors);
		super.setTitle(title);
		super.setYear(year);
		this.publicationCity = publicationCity;
		this.publisher = publisher;
		this.publicationState = publicationState;
		this.numberOfPages = numberOfPages;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		String retString = "";
		
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
		
		retString += " " + this.year + ". " + this.title + ". " + this.publisher + ", " + this.publicationCity + ", " + this.publicationState + ". " + this.numberOfPages + " pp.";
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
