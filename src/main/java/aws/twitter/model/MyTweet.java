package aws.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyTweet {
	@JsonProperty("ID")
	private String ID;
	private int nb;

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public MyTweet(){
	
	}

	public MyTweet(String ID, int nb) {
		this.ID = ID;
		this.nb = nb;

	}

}
