package com.mkarasz.hw5.playTone;


public class Note {
		
	private enum NoteEnum { //made this to make switching easier
		C, CSHARP, D, DSHARP, E, F, FSHARP, G, GSHARP, A, ASHARP, B
	}
	
	NoteValue length;
	int midiNumber = 0;
	
	/**
	 * Sets the MIDI to the default stuff, as seen in default helper method below.
	 */
	public Note(){
		setNoteDefault();
	}
	
	/** Parses out the string note and sets the length
	 * @param note
	 * @param length
	 */
	public Note(String note, NoteValue length){
		this.length = length;
		NoteEnum noteEnum = NoteEnum.A;
		String letter;
		int octave = 0;
		
		if(note.matches("^[A-G]{1}[#]?[-]?[0-9]{1}$")) {
			if(note.matches("[A-G]{1}[#]?[-]+[2-9]{1}")){ //checking for octaves less than -1
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else if (note.matches("[A,B]{1}[#]?[9]{1}")) { //checking for A9, A#9, and B9
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else if (note.equals("G#9")){ //couldn't do above cause G9 is valid, but G#9 isn't 
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else{
				if(note.matches("[A-G]{1}[#]{1}.*")) {
					letter = note.substring(0, 1);
					if (letter.equals("A")){
						noteEnum = NoteEnum.ASHARP;
					}
					else if (letter.equals("C")){
						noteEnum = NoteEnum.CSHARP;
					}
					else if (letter.equals("D")){
						noteEnum = NoteEnum.DSHARP;
					}
					else if (letter.equals("F")){
						noteEnum = NoteEnum.FSHARP;
					}
					else
						noteEnum = NoteEnum.GSHARP;
					
					letter = note.substring(2);
					//System.out.println("" + letter + " what you entered.");
					octave = Integer.parseInt(letter);
				}
				else {
					letter = note.substring(0, 1);
					if (letter.equals("A")){
						noteEnum = NoteEnum.A;
					}
					else if (letter.equals("B")){
						noteEnum = NoteEnum.B;
					}
					else if (letter.equals("C")){
						noteEnum = NoteEnum.C;
					}
					else if (letter.equals("D")){
						noteEnum = NoteEnum.D;
					}
					else if (letter.equals("E")){
						noteEnum = NoteEnum.E;
					}
					else if (letter.equals("F")){
						noteEnum = NoteEnum.F;
					}
					else
						noteEnum = NoteEnum.G;
					
					letter = note.substring(1);
					octave = Integer.parseInt(letter);
				}
			}
		}
		else {
			System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
			setNoteDefault();
			return;
		}
		
		switch (noteEnum){//performs calulation with offset
		case A:
			this.midiNumber = (69 + 0) + (octave - 4) * 12;
			break;
		case ASHARP:
			this.midiNumber = (69 + 1) + (octave - 4) * 12;
			break;
		case B:
			this.midiNumber = (69 + 2) + (octave - 4) * 12;
			break;
		case C:
			this.midiNumber = (69 - 9) + (octave - 4) * 12;
			break;
		case CSHARP:
			this.midiNumber = (69 - 8) + (octave - 4) * 12;
			break;
		case D:
			this.midiNumber = (69 - 7) + (octave - 4) * 12;
			break;
		case DSHARP:
			this.midiNumber = (69 - 6) + (octave - 4) * 12;
			break;
		case E:
			this.midiNumber = (69 - 5) + (octave - 4) * 12;
			break;
		case F:
			this.midiNumber = (69 - 4) + (octave - 4) * 12;
			break;
		case FSHARP:
			this.midiNumber = (69 - 3) + (octave - 4) * 12;
			break;
		case G:
			this.midiNumber = (69 - 2) + (octave - 4) * 12;
			break;
		case GSHARP:
			this.midiNumber = (69 - 1) + (octave - 4) * 12;
			break;
		}
	}
	
	/** Sets the MIDI number of the note and its length
	 * @param midiNumber
	 * @param length
	 */
	public Note(int midiNumber, NoteValue length){
		this.midiNumber = midiNumber;
		this.length = length;
	}
	
	/** Sets the frequency of the note, and then the length
	 * @param frequency
	 * @param length
	 */
	public Note (double frequency, NoteValue length){
		setFrequency(frequency);
		this.length = length;
	}
	
	/**
	 * Sets the MIDI note to default stuff. Easier on me than writing same code 40 times.
	 */
	private void setNoteDefault(){
		this.midiNumber = 60;
		this.length = NoteValue.QUARTER;
	}
	
	/** Lets you set the frequency of the current MIDI note
	 * @param frequency to set
	 */
	public void setFrequency(double frequency){
		this.midiNumber = (int) (12 * (Math.log(frequency/440)/Math.log(2)) + 69);
	}
	
	/** Gets you the frequency of the current MIDI note
	 * @return frequency of the note
	 */
	public double getFrequency(){ //Hz
		return Math.pow(2, ((double)this.midiNumber - 69)/12) * 440;
	}
	
	/** Lets you set how long the note is
	 * @param length the enum'd length of the note
	 */
	public void setNoteValue(NoteValue length){
		this.length = length;
	}
	
	/** The length of the note
	 * @return NoteValue an enum to how long the note is
	 */
	public NoteValue getNoteValue(){
		return this.length; 
	}
	
	/** Lets you set the MIDI number of the current note
	 * @param midi the MIDI number to set
	 */
	public void setMidiNumber(int midi){
		this.midiNumber = midi;
	}
	
	/** gets you the MIDI number of the current note
	 * @return midi number of note
	 */
	public int getMidiNumber(){
		return this.midiNumber;
	}
	
	/** lets you set the octave of the note. Doesn't affect where it is in the scale.
	 * @param octave the octave the note should take
	 */
	public void setOctave(int octave){
		int last = this.midiNumber % 12;
		this.midiNumber = octave * 12 + 12 + last;
	}
	
	/** Gets you the octave of the current note.
	 * @return the octave from -1 to 9
	 */
	public int getOctave(){
		return (int) ((this.midiNumber / 12) - 1);
	}
	
	/** Sets the note to sharp if it can be, else prints error and does nothing.
	 * 
	 */
	public void setSharp(){
		int check = this.midiNumber % 12;
		switch(check){
		case 0:
		case 2:
		case 5:
		case 7:
		case 9:
			this.midiNumber++;
			break;
		default:
			System.out.println("The current midi number cannot be made sharper.");
		}
	}
	
	/** Returns whether or not the note is sharp.
	 * @return true - note is sharp, else false
	 */
	public boolean isSharp(){
		int check = this.midiNumber % 12;
		switch(check){
		case 1:
		case 3:
		case 6:
		case 8:
		case 10:
			return true;
		default:
			return false;
		}
	}
	
	/** Returns the note of the current MIDI note
	 * @return the note
	 */
	public String getNote(){
		int check = this.midiNumber % 12;
		switch(check){
		case 0:
			return "C";
		case 1:
			return "C#";
		case 2:
			return "D";
		case 3:
			return "D#";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "F#";
		case 7:
			return "G";
		case 8:
			return "G#";
		case 9:
			return "A";
		case 10:
			return "A#";
		default:
			return "B";
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "SPN: " + getNote() + getOctave() + ", Frequency: " + getFrequency() + ", MIDI Number: " + getMidiNumber(); 
	}


}
