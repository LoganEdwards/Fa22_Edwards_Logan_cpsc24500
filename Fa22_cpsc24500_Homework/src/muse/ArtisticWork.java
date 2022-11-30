package muse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
public abstract class ArtisticWork implements Serializable{
    private String creator;
    private String date;
    private String title;
    private String description;
    private ArrayList<Comment> comments;
    
    public void setComments(ArrayList<Comment> c) {
    	//set comments
    	comments = c;
    }
    public ArrayList<Comment> getComments(){
    	return comments;
    }
    public Comment getComment(int x){
    	//get comment for specific index
    	return comments.get(x);
    }
    public void setComment(Comment c, int index) {
    	comments.set(index,c);
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArtisticWork() {
        date = "1/1/1900";
        title = "title";
        creator = "anonymous";
        description = "description";
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(String creator, String date, String title, String description) {
        setCreator(creator);
        setDate(date);
        setTitle(title);
        setDescription(description);
        comments = new ArrayList<Comment>();
    }
    public ArtisticWork(LinkedHashMap<String,String> settings) {
    	//accepts a Linked hash map and pulls the creator, date, title, and description from it
        this(settings.get("creator"),settings.get("date"),settings.get("title"),settings.get("description"));
    }
    public abstract String getType();
    public String getGeneralInfoString() {
        return String.format("%s, a %s by %s, posted on %s",title,getType(),creator,date);
    }
    public abstract String getSpecificInfoString();
    //added a method which returns the type followed by all other info separated by tabs
    public abstract String getTabbedString();
    public String getCommentsAsString() {
        String result = "";
        for (Comment comment : comments) {
            result = result + comment + "\n";
        }
        if (result.isBlank()) {
            return "No comments";
        }
        return result;
    }
    @Override
    public String toString() {
        return getGeneralInfoString() + "\n" + getSpecificInfoString() + "\nComments: \n" + getCommentsAsString();
    }
    public void addComment(String postedBy, String date, String content) {
        Comment comment = new Comment(postedBy, date, content);
        comments.add(comment);
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public String getShortString() {
        return String.format("\"%s\", a %s by %s", title, getType(), creator);
    }
}