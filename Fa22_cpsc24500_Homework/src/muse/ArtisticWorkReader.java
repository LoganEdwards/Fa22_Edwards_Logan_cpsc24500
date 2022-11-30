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
			while (fsc.hasNextLine()) {
			//not done yet
				line = fsc.nextLine();
				parts = line.split("\t");
				type = parts[0];
				if(type.equals("poem")) {
					works.add(new Poem(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]));
				}
				else if (type.equalsIgnoreCase("song")) {
					works.add(new Song(parts[1],parts[2],parts[3],parts[4], Integer.parseInt(parts[5]), parts[6], Double.parseDouble(parts[7]), Integer.parseInt(parts[8]), parts[9]));
				}
				else if (type.equalsIgnoreCase("movie")) {
					works.add(new Movie(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]), parts[6], Double.parseDouble(parts[7]), Integer.parseInt(parts[8]), parts[9]));
				}
				else if (type.equalsIgnoreCase("short story")) {
					works.add(new ShortStory(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]));
				}
//				else if (type.equalsIgnoreCase("comment")) {
//				
//				}
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
//			FileInputStream fis = new FileInputStream(new File(fName));
//			BufferedInputStream bis = new BufferedInputStream(fis);
//			XMLDecoder dec = new XMLDecoder(bis);
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(new File(fName))));
			ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)dec.readObject();
			dec.close();
			return works;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
