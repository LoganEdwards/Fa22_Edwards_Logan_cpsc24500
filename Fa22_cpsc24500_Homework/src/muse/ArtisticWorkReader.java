package muse;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtisticWorkReader {

	public static ArrayList<ArtisticWork> readFromText(String fName) {
		try {	
			ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();
			Scanner fsc = new Scanner(new File(fName));
			String line;
			String[] parts;
			String type = "";
			//temp variables for each type of media so I can add comments and add it to works
			Poem curPoem;
			Song curSong;
			Movie curMovie;
			ShortStory curShortStory;
			while (fsc.hasNextLine()) {
			//not done yet
				line = fsc.nextLine();
				parts = line.split("\t");
				type = parts[0];
				if(type.equals("poem")) {
					curPoem = new Poem(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
					//check for the comments by checking how many parts there are after the initial variables that created the poem/song/movie etc.
					if(parts.length > 7) {
						for (int i = 8; i < parts.length; i+=3) {
							//the 3 parts after the original 7 are the postedBy, DatePosted, and content
							curPoem.addComment(parts[i],parts[i+1],parts[i+2]);
						}
					}
					works.add(curPoem);
				}
				else if (type.equalsIgnoreCase("song")) {
					curSong = (new Song(parts[1],parts[2],parts[3],parts[4], Integer.parseInt(parts[5]), parts[6], Double.parseDouble(parts[7]), Integer.parseInt(parts[8]), parts[9]));
					//check for the comments by checking how many parts there are after the initial variables that created the poem/song/movie etc.
					if(parts.length > 9) {
						for (int i = 10; i < parts.length; i+=3) {
							//the 3 parts after the original 7 are the postedBy, DatePosted, and content
							curSong.addComment(parts[i],parts[i+1],parts[i+2]);
						}
					}
					works.add(curSong);
				}
				else if (type.equalsIgnoreCase("movie")) {
					curMovie = (new Movie(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), parts[6], Double.parseDouble(parts[7]), Integer.parseInt(parts[8]), parts[9]));
					//check for the comments by checking how many parts there are after the initial variables that created the poem/song/movie etc.
					if(parts.length > 9) {
						for (int i = 10; i < parts.length; i+=3) {
							//the 3 parts after the original 7 are the postedBy, DatePosted, and content
							curMovie.addComment(parts[i],parts[i+1],parts[i+2]);
						}
					}
					works.add(curMovie);
				}
				else if (type.equalsIgnoreCase("short story")) {
					curShortStory = (new ShortStory(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]));
					//check for the comments by checking how many parts there are after the initial variables that created the poem/song/movie etc.
					if(parts.length > 7) {
						for (int i = 8; i < parts.length; i+=3) {
							//the 3 parts after the original 7 are the postedBy, DatePosted, and content
							curShortStory.addComment(parts[i],parts[i+1],parts[i+2]);
						}
					}
					works.add(curShortStory);
				}

			}
			return works;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<ArtisticWork> readFromBinary(String fName){
		try {
			FileInputStream fis = new FileInputStream(new File(fName));
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)ois.readObject();
			ois.close();
			return works;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<ArtisticWork> readFromXML(String fName){
		try {
			//Could have shortened the decoder to 1 line but it is easier to read this way
			FileInputStream fis = new FileInputStream(new File(fName));
			BufferedInputStream bis = new BufferedInputStream(fis);
			XMLDecoder dec = new XMLDecoder(bis);
			ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)dec.readObject();
			dec.close();
			return works;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	
}
