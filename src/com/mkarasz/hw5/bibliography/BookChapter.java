package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public class BookChapter extends Book{
	protected ArrayList<Author> chapterAuthors;
	protected String chapterTitle;
	protected int beginPage;
	protected int endPage;
	
	/**
	 * Default constructor
	 */
	public BookChapter(){
		this(null, 0, null, null, null, null, null, null, 0, 0);
	}
	
	/** Constructor that sets everything
	 * @param authors the authors of the book
	 * @param year the year the book was published
	 * @param title the title of the book
	 * @param publisher the publisher of the book
	 * @param publicationCity city where the book was published
	 * @param publicationState state where book was published
	 * @param chapterAuthors author of the chapter
	 * @param chapterTitle title of the chapter
	 * @param beginPage page the chapter starts on
	 * @param endPage page chapter ends on
	 */
	public BookChapter(String authors, int year, String title, String chapterAuthors, String chapterTitle, String publisher, String publicationCity, String publicationState, int beginPage, int endPage){
		super.authors = super.setAuthors(authors, this.authors);
		super.setTitle(title);
		super.setYear(year);
		super.publicationCity = publicationCity;
		super.publisher = publisher;
		super.publicationState = publicationState;
		super.numberOfPages = numberOfPages;
		this.chapterAuthors = super.setAuthors(chapterAuthors, this.chapterAuthors);
		this.chapterTitle = chapterTitle;
		this.beginPage = beginPage;
		this.endPage = endPage;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.mkarasz.hw5.bibliography.Book#toString()
	 */
	@Override
	public String toString(){
		ArrayList<Author> list = this.chapterAuthors;
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
			retString += printName(currentAuthor);
			retString += " AND ";
			currentAuthor = list.get(1);
			retString += printName(currentAuthor);
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				retString += printName(currentAuthor) + ", ";
			}
			System.out.print("AND ");
			currentAuthor = list.get(list.size() - 1);
			retString += printName(currentAuthor);
		}
		
		retString += " " + this.year + ". " + this.chapterTitle + ". In " + this.title + ", ";
		
		list = this.authors;
		if(list == null){
			System.out.println("ERROR: No author list.");
			return null;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			retString += printAltName(currentAuthor);
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			retString += printAltName(currentAuthor) + " AND ";
			currentAuthor = list.get(1);
			retString += printAltName(currentAuthor);
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				retString += printAltName(currentAuthor) + ", ";
			}
			currentAuthor = list.get(list.size() - 1);
			retString += "AND " + printAltName(currentAuthor);
		}
		
		retString += ", ";
		if(list.size() > 1){
			retString += "Eds. ";
		}
		else
			retString += "Ed. ";
		
		retString += this.publisher + ", " + this.publicationCity + ", " + this.publicationState + ". pp. " + this.beginPage + "-" + this.endPage;
		return retString;
	}
	
	/** Returns a string that prints the name correctly.
	 * @param currentAuthor the author to print
	 * @return the name in the right format
	 */
	private String printName(Author currentAuthor){
		String s = null;
		if(currentAuthor.getInitials() == null){
			s = "" + currentAuthor.getLastName().toUpperCase() + ", " + currentAuthor.getFirstName().substring(0, 1).toUpperCase() +".";
		}
		else
			s = currentAuthor.getLastName().toUpperCase() + ", " + currentAuthor.getFirstName().substring(0, 1).toUpperCase() + "." + currentAuthor.getInitials().toUpperCase();
		return s;
	}
	
	/** Returns a string that prints the name in another way.
	 * @param currentAuthor the author to print
	 * @return the name in the right format
	 */
	private String printAltName(Author currentAuthor){
		String s = null;
		if(currentAuthor.getInitials() == null){
			s = "" + currentAuthor.getFirstName().substring(0, 1).toUpperCase() + ". " + currentAuthor.getLastName().toUpperCase() + ".";
		}
		else
			s = "" + currentAuthor.getFirstName().substring(0, 1).toUpperCase() + "." + currentAuthor.getInitials().toUpperCase() + " " + currentAuthor.getLastName().toUpperCase();
		return s;
	}
	
	
	
}
