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
	
	Poem(){
		this(null, null, 0, null, null, null, 0, 0, null);
	}
	
	Poem(String authors, String title, int year, String collection, String publicationState, String publisher, int beginPage, int endPage, String medium){
		this.editor = null;
		this.authors = setAuthors(authors);
		this.title = title;
		this.year = year;
		this.collection = collection;
		this.publicationState = publicationState;
		this.publisher = publisher;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.medium = medium;
	}
	
	Poem(String authors, String title, int year, String collection, String editor, String publicationState, String publisher, int beginPage, int endPage, String medium){
		this.editor = editor;
		this.authors = setAuthors(authors);
		this.title = title;
		this.year = year;
		this.collection = collection;
		this.publicationState = publicationState;
		this.publisher = publisher;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.medium = medium;
	}

	
	public void print(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		
		if(list == null){
			System.out.println("ERROR: No author list.");
			return;
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
		
		System.out.print("\"" + this.title + "\". "+ this.collection);
		
		if(editor != null){
			System.out.print("Ed. " + this.editor + ".");
		}
		
		System.out.println(this.publicationState + ": " + this.publisher + ", " + this.year + ". " + this.beginPage + "-" + this.endPage + ". " + this.medium + ".");
		
		
	}
	
	
	private void printName(Author currentAuthor){
		if(currentAuthor.getInitials() == null){
			System.out.printf("%s, %s", currentAuthor.getLastName(), currentAuthor.getFirstName());
		}
		else
			System.out.printf("%s, %s %s", currentAuthor.getLastName(), currentAuthor.getFirstName(), currentAuthor.getInitials());
	}
}
