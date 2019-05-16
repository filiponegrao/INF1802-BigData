package filiponegrao.twitter;
import java.util.Date;

import twitter4j.*;

public class TweetListener implements StatusListener {
	
    public void onStatus(Status status) {
    	
    	User user = status.getUser();
    	String name = user.getName();
    	String text = status.getText();
    	Date date = status.getCreatedAt();
    	
        Tweet tweet = new Tweet(name, text, date);
        
        System.out.println("\nUser: "+ tweet.getUser() + ": " + tweet.getText());
        System.out.println("Date: " + tweet.getDate().toString());
    }

    public void onException(Exception ex) {
        ex.printStackTrace();
    }

    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) { 
    	
    }

    public void onTrackLimitationNotice(int i) {
    	
    }

    public void onScrubGeo(long l, long l1) {
    	
    }

    public void onStallWarning(StallWarning stallWarning) {
    	
    }
}