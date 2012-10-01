package org.micro_gzm.v5.core;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ResourceManager {
	
	public ResourceManager()
	{
		// TODO Auto-generated constructor stub
	}
	
	public void loadFBXFile(String filePath) {
		
		try {
			FileInputStream fstream = new FileInputStream(filePath);
			
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader( new InputStreamReader(in) );
			
			String strLine;
			
		}
		catch (Exception e) {
			
			  System.err.println("Error: " + e.getMessage());
		 }
		
	}

}
