package com.mkarasz.hw5.bibliography;

public class Author {
	private String firstName;
	private String lastName;
	private String initials;
	
	public Author(String author){
			
		String[] s = author.split(" ");
		this.firstName = s[0];
		if (s.length > 2){
			for (int i = 1; i < s.length - 1; i++){
				if(i == 1){
					this.initials = s[i].substring(0, 1) + ".";
				}
				else
					this.initials = (this.initials + s[i].substring(0, 1) + ".");
			}
		}
		this.lastName = s[s.length - 1];
		
	}	
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}


	/**
	 * @param initials the initials to set
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		if(initials == null){
			return (firstName + " " + lastName);
		}
		return (firstName + " " + initials + " " + lastName);
	}
}
