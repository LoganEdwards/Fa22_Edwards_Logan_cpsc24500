package muse;

import java.io.Serializable;

public class Comment implements Serializable{
    private String postedBy;
    private String dateTime;
    private String content;
    public String getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getContent() {
        return content;
    }
    public String getType() {
    	return "comment";
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Comment() {
        postedBy = "";
        dateTime = "";
        content = "";
    }
    public Comment(String postedBy, String dateTime, String content) {
        setPostedBy(postedBy);
        setDateTime(dateTime);
        setContent(content);
    }
    @Override
    public String toString() {
        return String.format("On %s, %s commented ...\n\t\"%s\"", dateTime, postedBy, content);
    }
    public String getTabbedString() {
		return String.format("%s\t%s\t%s\t%s",getType(),getPostedBy(),getDateTime(),getContent());
	}
}