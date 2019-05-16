package filiponegrao.twitter;

import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;
import java.io.Serializable;

public class TweetLifecycleManager implements LifecycleManager, Serializable {
	
    private ConfigurationBuilder configurationBuilder;
    private TwitterStream twitterStream;
    private TweetListener tweetListener;

    public TweetLifecycleManager() {
    	
       String _consumerKey = System.getenv().get("API_KEY");
       String _consumerSecret = System.getenv().get("API_SECRET");
       String _accessToken = System.getenv().get("ACCESS_TOKEN");
       String _accessTokenSecret = System.getenv().get("ACCESS_TOKEN_SECRET");


        this.configurationBuilder = new ConfigurationBuilder();
        this.configurationBuilder.setOAuthConsumerKey(_consumerKey)
            .setOAuthConsumerSecret(_consumerSecret)
            .setOAuthAccessToken(_accessToken)
            .setOAuthAccessTokenSecret(_accessTokenSecret);

        TwitterStreamFactory tf = new TwitterStreamFactory(this.configurationBuilder.build());

        this.twitterStream = tf.getInstance();
        this.tweetListener = new TweetListener();

    }

    public void start() {
        this.twitterStream.addListener(tweetListener);
        this.twitterStream.filter("BITCOIN");

    }

    public void stop() {
        this.twitterStream.shutdown();
    }

}