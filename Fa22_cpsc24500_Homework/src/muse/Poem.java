package muse;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Poem extends WrittenArtisticWork {
    private String meter;
    
    public String getMeter() {
        return meter;
    }
    public void setMeter(String meter) {
        this.meter = meter;
    }
    public Poem() {
    	//If there are no arguments then there is no meter, but it's still a poem
        meter = "N/A";
    }
    public Poem(String creator, String date, String title, String description,
            String language, String text, String meter) {
    	//Poem is the same as a Written Artistic Work + meter
        super(creator,date,title,description,language,text);
        setMeter(meter);
    }
    public Poem(LinkedHashMap<String,String> settings) {
    	//generate the settings from a linked hashmap written in the Artistic work class and add the meter
        super(settings);
        setMeter(settings.get("meter"));
    }
    @Override
    public String getType() {
        return "poem";
    }
    @Override
    public String getSpecificInfoString() {
    	//Take the specific info generated in Written Artistic Work + meter information
        return String.format("Meter: %s\n%s", meter, super.getSpecificInfoString());
    }
    @Override
    public String getTabbedString() {
    	String comments = "";
    	ArrayList<Comment> comms = new ArrayList<Comment>();
    	comms = getComments();
    	for(Comment c : comms) {
    		comments += String.format("\t%s\t%s\t%s",c.getPostedBy(),c.getDateTime(),c.getContent());
    	}
    	return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",getType(),getCreator(),getDate(),getTitle(),getDescription(),getLanguage(),getText(),getMeter()) + comments;
    }
}