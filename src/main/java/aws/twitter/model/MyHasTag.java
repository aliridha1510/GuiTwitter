package aws.twitter.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyHasTag {
	@JsonProperty("hashtag")

	private String hashtag;
	private int htCount;
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public int getHtCount() {
		return htCount;
	}
	public void setHtCount(int htCount) {
		this.htCount = htCount;
	}
	public MyHasTag(String hashtag, int htCount) {
		
		this.hashtag = hashtag;
		this.htCount = htCount;
	}
	public MyHasTag() {
		
	}

	

}

