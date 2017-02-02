package aws.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AllTweetsInfo {
	@JsonProperty("id")

	private String id;
	private String user;
	private double latitude;
	private double longitude;
	private String date;

	private int retweet;
	private int nbRetweet;
	private int nbFavoris;

	public int getRetweet() {
		return retweet;
	}

	public void setRetweet(int retweet) {
		this.retweet = retweet;
	}

	public int getNbRetweet() {
		return nbRetweet;
	}

	public void setNbRetweet(int nbRetweet) {
		this.nbRetweet = nbRetweet;
	}

	public int getNbFavoris() {
		return nbFavoris;
	}

	public void setNbFavoris(int nbFavoris) {
		this.nbFavoris = nbFavoris;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public AllTweetsInfo(String id, String user, double latitude, double longitude, String date, int retweet,
			int nbRetweet, int nbFavoris) {
		super();
		this.id = id;
		this.user = user;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.retweet = retweet;
		this.nbRetweet = nbRetweet;
		this.nbFavoris = nbFavoris;
	}

	public AllTweetsInfo() {

	}

}