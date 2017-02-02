package aws.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class MapTwitter {
	@JsonProperty("latitude")

	 private String latitude;
	 private int ftCount;
	private String longitude;
	private String full_name;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public int getFtCount() {
		return ftCount;
	}
	public void setFtCount(int ftCount) {
		this.ftCount = ftCount;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public MapTwitter(String latitude, int ftCount, String longitude, String full_name) {
		super();
		this.latitude = latitude;
		this.ftCount = ftCount;
		this.longitude = longitude;
		this.full_name = full_name;
	}
	public MapTwitter() {
		
	}

}
