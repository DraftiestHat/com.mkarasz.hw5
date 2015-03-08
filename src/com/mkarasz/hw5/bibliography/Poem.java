package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public class Poem extends Bibliography{
	// NEEDS THREE CONSTRUCTORS
	protected String collection;
	protected String editor; //optional
	protected String publicationState;
	protected String publisher;
	protected int beginPage;
	protected int endPage;
	protected String medium;
	
	/**
	 * Default constructor
	 */
	Poem(){
		this(null, null, 0, null, null, null, 0, 0, null);
	}
	
	/**
	 * Sets up everything but without the editor
	 * @param authors the authors of the poem
	 * @param title the title of the poem
	 * @param year  the year the poem was published
	 * @param collection what the poem was published in 
	 * @param publicationState where the poem was published
	 * @param publisher who published the poem
	 * @param beginPage starting page of poem
	 * @param endPage ending page of the poem
	 * @param medium how it was published (print/online)
	 */
	Poem(String authors, String title, int year, String collection, String publicationState, String publisher, int beginPage, int endPage, String medium){
		this(authors, title, year, collection, null, publicationState, publisher, beginPage, endPage, medium);
	}
	
	/**
	 * Sets up everything and the editor
	 * @param authors the authors of the poem
	 * @param title the title of the poem
	 * @param year  the year the poem was published
	 * @param collection what the poem was published in
	 * @param editor the editor of the poem 
	 * @param publicationState where the poem was published
	 * @param publisher who published the poem
	 * @param beginPage starting page of poem
	 * @param endPage ending page of the poem
	 * @param medium how it was published (print/online)
	 */
	Poem(String authors, String title, int year, String collection, String editor, String publicationState, String publisher, int beginPage, int endPage, String medium){
		this.editor = editor;
		this.authors = setAuthors(authors, this.authors);
		this.title = title;
		this.year = year;
		this.collection = collection;
		this.publicationState = publicationState;
		this.publisher = publisher;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.medium = medium;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		String sRet = null;
		
		if(list == null){
			System.out.println("ERROR: No author list.");
			return null;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			sRet = printName(currentAuthor) + ". ";
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			sRet = printName(currentAuthor) + " AND ";
			currentAuthor = list.get(1);sRet = printName(currentAuthor) + ". ";
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				sRet = printName(currentAuthor) + ", ";
			}
			System.out.print("AND ");
			currentAuthor = list.get(list.size() - 1);
			sRet = printName(currentAuthor) + ". ";
		}
		
		sRet += "\"" + this.title + "\" "+ this.collection + " ";
		
		if(editor != null){
			sRet += "Ed. " + this.editor + ". ";
		}
		
		sRet += this.publicationState + ": " + this.publisher + ", " + this.year + ". " + this.beginPage + "-" + this.endPage + ". " + this.medium + ".";
		
		return sRet;
	}
	
	/** Returns a string that prints the name correctly.
	 * @param currentAuthor the author to print
	 * @return the name in the right format
	 */
	private String printName(Author currentAuthor){
		String s = null;
		if(currentAuthor.getInitials() == null){
			s = currentAuthor.getLastName() + ", " + currentAuthor.getFirstName();
		}
		else
			s = currentAuthor.getLastName() + ", " + currentAuthor.getFirstName() + " " + currentAuthor.getInitials();
		return s;
	}
}
