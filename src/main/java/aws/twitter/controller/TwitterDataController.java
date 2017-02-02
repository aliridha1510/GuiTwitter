package aws.twitter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import aws.twitter.model.AllTweetsInfo;
import aws.twitter.model.MapTwitter;
import aws.twitter.model.MyHasTag;
import aws.twitter.model.MyTweet;

@RestController
public class TwitterDataController {

	@RequestMapping(value = "/twitterData")

	public MyTweet[] getMyTweet() {
		try {
			final String uri = "https://ai5p678uyi.execute-api.us-west-2.amazonaws.com/Read_Data/readlocation/readtweets/readhashtag";

			RestTemplate restTemplate = new RestTemplate();
			MyTweet[] result = restTemplate.getForObject(uri, MyTweet[].class);

			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/twitterDataHashtag")

	public MyHasTag[] getMyHashTag() {
		try {
			final String uri = "https://4a15y34hk0.execute-api.us-west-2.amazonaws.com/GetData/gethashtag";

			RestTemplate restTemplate = new RestTemplate();
			MyHasTag[] result = restTemplate.getForObject(uri, MyHasTag[].class);

			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/twitterDataMap")
	public MapTwitter[] getMapTwitter() {
		try {
			final String uri = "https://4a15y34hk0.execute-api.us-west-2.amazonaws.com/GetData/getlocation";

			RestTemplate restTemplate = new RestTemplate();
			MapTwitter[] result = restTemplate.getForObject(uri, MapTwitter[].class);

			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/twitterDataAll")

	public AllTweetsInfo[] getAllTweetsInfo() {
		try {
			final String uri = "https://ai5p678uyi.execute-api.us-west-2.amazonaws.com/Read_Data/readlocation/readtweets";

			RestTemplate restTemplate = new RestTemplate();
			AllTweetsInfo[] result = restTemplate.getForObject(uri, AllTweetsInfo[].class);

			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
