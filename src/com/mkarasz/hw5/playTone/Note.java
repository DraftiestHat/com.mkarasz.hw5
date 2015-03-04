package com.mkarasz.hw5.playTone;

/**
 * A class to generate linear pcm data based on
 * the MIDI class you developed in HW 4. 
 * 
 * Creates a byte stream for playback by the Tone class.
 * 
 * todo: You need to make setNote use the MIDI class you wrote in HW 4 and the Tempo class
 * 
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
	 * todo: use the frequency calculation from your MIDI class.
	 *     
	 * @param noteNumber the note's note number
	 * @return the frequency of the note
	 */
	public double getFrequency(int noteNumber) {
		//assumes notes are centered around middle A
		//no octaves 
		return 440.0 * Math.pow(2.0, noteNumber/12.0);
	}

	/**
	 * 
	 * todo: delete this method once you setNote to work with the Tempo class 
	 * this is just here to remind you to replace it in setNote
	 * 
	 * @param seconds
	 * @return the duration of the note in seconds.
	 */
	public double getDuration(double seconds) {
		return seconds;
	}


	/**
	 * todo: modify signature and body as necessary to work with MIDI and Tempo classes.
	 * 
	 * change the signature to:
	 * 
	 * setNote(MIDI midi, Tempo tempo)
	 * 
	 * Generate an array of bytes in linear pcm format for playback.
	 * 
	 * @param noteNumber the note's note number
	 * @param seconds the duration of the note.
	 */
	public void setNote(int noteNumber, double seconds) {

		//how many samples will the note hold
		note = new byte[(int)(this.getDuration(seconds) * this.getSampleRate())];

		//sample_rate / frequency determines the number of samples
		double numberOfSamples = this.getSampleRate() / this.getFrequency(noteNumber);
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
