package muse;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ShortStory extends WrittenArtisticWork {
    public String setting;
    public String getSetting() {
        return setting;
    }
    public void setSetting(String setting) {
        this.setting = setting;
    }
    public ShortStory() {
        setting = "";
    }
    public ShortStory(String creator, String date, String title, String description,
            String language, String text, String setting) {
    	//call super constructor and add settings
        super(creator,date,title,description,language,text);
        setSetting(setting);
    }
    public ShortStory(LinkedHashMap<String,String> settings) {
    	//call hashmap super constructor and add settings
        super(settings);
        setSetting(settings.get("setting"));
    }
    @Override
    public String getType() {
        return "short story";
    }
    @Override
    public String getSpecificInfoString() {
        return String.format("Setting: %s\n%s", setting, super.getSpecificInfoString());
    }
    @Override
    public String getTabbedString() {
    	String comments = "";
    	ArrayList<Comment> comms = new ArrayList<Comment>();
    	comms = getComments();
    	for(Comment c : comms) {
    		comments += String.format("\t%s\t%s\t%s",c.getPostedBy(),c.getDateTime(),c.getContent());
    	}
    	return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",getType(),getCreator(),getDate(),getTitle(),getDescription(),getLanguage(),getText(),getSetting()) + comments;
    }
}