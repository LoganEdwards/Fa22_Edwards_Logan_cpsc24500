package muse;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArtisticWorkReader {

	public static ArrayList<ArtisticWork> readFromText(String fName) {
		try {	
			ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();
			Scanner fsc = new Scanner(new File(fName));
			String line;
			String[] parts;
			while (fsc.hasNextLine()) {
			//not done yet
			
			
			
			
			}
			return works;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
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
