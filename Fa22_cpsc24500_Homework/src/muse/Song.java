package muse;

import java.util.LinkedHashMap;
public class Song extends RecordedArtisticWork {
    private int bpm;  // beats per minute
    private String key;
    
    public int getBPM() {
        return bpm;
    }
    public void setBPM(int bpm) {
        if (bpm < 0) {
            this.bpm = 0;
        } else {
            this.bpm = bpm;
        }
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;   // could add checking for valid key
    }
    public Song() {
    	//default constructor for no arguments, defaults to Cmaj 120
        key = "Cmaj";
        bpm = 120;
    }
    public Song(String creator, String date, String title, String description,
            int duration, String fileName, double fileSize, int bpm, String key) {
    	//Constructor with all arguments of recorded artistic work + bpm and key
        super(creator,date,title,description,duration,fileName,fileSize);
        setBPM(bpm);
        setKey(key);
    }
    public Song(LinkedHashMap<String,String> settings) {
    	//calls super hashmap constructor and adds bpm and key
        super(settings);
        setBPM(Integer.parseInt(settings.get("bpm")));
        setKey(settings.get("key"));
    }
    @Override
    public String getType() {
        return "song";
    }
    @Override
    public String getSpecificInfoString() {
        return String.format("%d bpm, key of %s", bpm,key);
    }
}
