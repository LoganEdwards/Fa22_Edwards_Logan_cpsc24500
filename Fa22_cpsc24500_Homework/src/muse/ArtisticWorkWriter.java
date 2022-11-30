package muse;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ArtisticWorkWriter {

	public static boolean writeToText(ArrayList<ArtisticWork> works, String fName) {
		try {	
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fName))));
			for(ArtisticWork aw : works) {
				pw.println(aw.getTabbedString());
			}
			pw.close();
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static boolean writeToBinary(ArrayList<ArtisticWork> works, String fName) {
		try {	
			FileOutputStream fos = new FileOutputStream(new File(fName));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(works);
			oos.close();
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static boolean writeToXML(ArrayList<ArtisticWork> works, String fName) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(fName))));
			enc.writeObject(works);
			enc.close();
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
