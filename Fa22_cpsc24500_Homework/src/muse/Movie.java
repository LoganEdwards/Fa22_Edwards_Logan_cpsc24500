package muse;

import java.util.LinkedHashMap;
public class Movie extends RecordedArtisticWork {
    private int frameRate; // frames per second
    private String resolution;  // 720p, 1040p, 2048p, etc
    public int getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(int frameRate) {
        if (frameRate < 0) {
            frameRate = 0;
        } else {
            this.frameRate = frameRate;
        }
    }
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String res) {
        resolution = res;
    }
    public Movie() {
        frameRate = 30;
        resolution = "720p";
    }
    public Movie(String creator, String date, String title, String description,
            int duration, String fileName, double fileSize, int frameRate, String resolution) {
    	//call super constructor and add the framerate + resolution
        super(creator,date,title,description,duration,fileName,fileSize);
        setFrameRate(frameRate);
        setResolution(resolution);
    }
    public Movie(LinkedHashMap<String,String> settings) {
    	//call hashmap super constructor and add framerate + resolution
       super(settings);
       setFrameRate(Integer.parseInt(settings.get("framerate")));
       setResolution(settings.get("resolution"));
    }
    @Override
    public String getType() {
        return "movie";
    }
    @Override
    public String getSpecificInfoString() {
        return String.format("filmed with %s resolution at %d frames per second", resolution, frameRate);
    }
    public String getTabbedString() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
				getType(),getCreator(),getDate(),getTitle(),getDescription(),getDuration(),getFileName(),getFileSize(),getFrameRate(),getResolution());
	}
}