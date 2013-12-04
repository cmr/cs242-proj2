package brickettes;

import java.io.Serializable;

/**
 * A bean representing a song.
 */
public class SongBean implements Serializable, Comparable, Cloneable {
	private static final long serialVersionUID = 1L;

	/**
	 * Title of the song
	 */
	private String title = "The Safety Dance";

	/**
	 * Creator of the song
	 */
	private String artist = "Men Without Hats";

	/**
	 * Length of the song in seconds
	 */
	private double duration = 165.84;

	/**
	 * Type of the audio file, as a mime-type (see RFC2046)
	 */
	private String audioFiletype = "audio/mpeg";

	/**
	 * Name of the song's filename
	 */
	private String audioFilename = "Men_Without_Hats-The_Safety_Dance.mp3";

	public SongBean() { }

	/**
	 * Create a SongBean with the given data.
         *
         * @param title Name of the song
         * @param artist Creator of the song
         * @param duration Length of the song (in seconds)
         * @param audioFiletype Mime-type of the file
         * @param audioFilename Name of the audio file
	 */
	public SongBean(String title, String artist, double duration, String audioFiletype, String audioFilename) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.audioFiletype = audioFiletype;
		this.audioFilename = audioFilename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getAudioFiletype() {
		return audioFiletype;
	}

	public void setAudioFiletype(String audioFiletype) {
		this.audioFiletype = audioFiletype;
	}

	public String getAudioFilename() {
		return audioFilename;
	}

	public void setAudioFilename(String audioFilename) {
		this.audioFilename = audioFilename;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof SongBean))
			return false;
		SongBean other = (SongBean) obj;
		return other.title == this.title && other.artist == this.artist && other.duration == this.duration && other.audioFiletype == this.audioFiletype && other.audioFilename == this.audioFilename;
	}

	//This implementation of compareto will have issues if the object incorporated cannot be cast to SongBean. Not sure what we should assign for default behavior in that instance.
	@Override
	public int compareTo(Object obj){
		SongBean other == (SongBean) obj;
		if (this.equals(other))
			return 0;
		else if (this.duration < other.duration)
			return -1;
		else
			return 1;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + duration;
		hash = hash / 2;
		hash = 31 * hash + artist.length();
		hash = hash / 2;
		hash = 31 * hash + title.length();
		hash = hash / 2;
		return hash;
}	}
