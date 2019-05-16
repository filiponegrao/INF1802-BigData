package filiponegrao.twitter;

import java.util.Date;

public class Tweet {
	
    private String user;
    private String text;
    private Date date;

    public Tweet (String user, String text, Date date) {
      this.user = user;
      this.text = text;
      this.date = date;
    }

    public String getUser() {
        return this.user;
    }

    public String getText() {
        return this.text;
    }

    public Date getDate() {
        return this.date;
    }
}