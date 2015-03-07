package com.mkarasz.hw5.playTone;

/**
 * A class to generate linear pcm data based on
 * the MIDI class you developed in HW 4. 
 * 
 * Creates a byte stream for playback by the Tone class.
 * 
 */

public class Note {

	private byte[] note;
	private int sampleRate;
	private static final int KILO_HERTZ = 1024;


	/**
	 * Default Constructor. 
	 * 
	 * Sets the sampling rate to 8 KHz
	 */
	public Note() {
		this(8); //default sample rate of 8 Khz
	}

	/**
	 * Constructor. 
	 * 
	 * Set the sampling rate of the note to sampleRate
	 * 
	 * @param sampleRate set the sampling rate of the note to this value in KHz.
	 */
	public Note(int sampleRate) {
		this.sampleRate = sampleRate * Note.KILO_HERTZ;
	}
	
	/**
	 * @return the sampling rate of the note
	 */
	public int getSampleRate() {
		return this.sampleRate;
	}

	/**
	 * @param sampleRate set the sampling rate to sampleRate. Units of sampleRate are KHz 
	 */
	public void setSampleRate(int sampleRate) {
		this.sampleRate = sampleRate * Note.KILO_HERTZ;
	}

	
	/** 
	 * Generate an array of bytes in linear pcm format for playback.
	 * 
	 * @param midi the note to play
	 * @param tempo how long the note lasts
	 */
	public void setNote(MIDI midi, Tempo tempo) {

		//how many samples will the note hold
		note = new byte[(int)((tempo.getDuration(NoteValue.HALF)) * this.getSampleRate())];

		//sample_rate / frequency determines the number of samples
		double numberOfSamples = this.getSampleRate() / midi.getFrequency();
		double sampleAngle = 2 * Math.PI /numberOfSamples;

		for (int i = 0; i < note.length; i++) {
			//determine the value of the sine wave at sample points
			double sampleAt = i * sampleAngle; 

			//multiply by 127.0 to transform sine value to a byte value
			note[i] = (byte)(Math.sin(sampleAt) * 127.0);   	   
		}
	}

	/**
	 * @return the note byte array 
	 */
	public byte[] getNote() {
		return this.note;
	}

	/**
	 * @return the length of the array or how many samples in note
	 */
	public int getLength() {
		return this.note.length;
	}
}
