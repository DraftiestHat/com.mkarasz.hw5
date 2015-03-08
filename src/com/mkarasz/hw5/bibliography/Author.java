package com.mkarasz.hw5.bibliography;

public class Author {
	private String firstName;
	private String lastName;
	private String initials;
	
	/** Takes a string with an author and splits it up
	 * @param author the author to split.
	 */
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
	
	
	/** Gets the first name of the author
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/** Sets the first name of the author
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**Gets the last name of the author
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/** Sets the lastName name of the author
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**Gets the initials of the author
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}


	/** Sets the initials of the author
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
