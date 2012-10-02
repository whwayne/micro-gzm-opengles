package org.micro_gzm.v5.loaders.fbx;

import java.io.BufferedReader;
import java.io.IOException;

import android.util.Log;

public class FBXLoader {

	
	public FBXLoader() {
		// TODO Auto-generated constructor stub
	}
	
	public void loadFBX(BufferedReader bufferIn) {
		

		BufferedReader buffer = bufferIn;
		String line;
		
		try {
			while (( line = buffer.readLine()) != null) Log.d("MG", line);
		}
		catch (IOException e) {

			Log.d("MG", "Error: " + e.getMessage());
		}
		
		
		
//		Resources.openRawResource(0);
//		try {
//			
//			
//			FileInputStream fstream = new FileInputStream(filePath);
//			
//			BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
//			String line = reader.readLine();
//
//			while (line != null) { Log.d("MG", line); }
//			
//			DataInputStream in = new DataInputStream(fstream);
//			BufferedReader br = new BufferedReader( new InputStreamReader(in) );
//			
//			String strLine;
//			
//			while( (strLine = br.readLine()) != null) {
//				
//
//				Log.d("MG", strLine);
//				
//			}
//			
//			in.close();
//			
//		}
//		catch (Exception e) {
//			
//			Log.d("MG","Error: " + e.getMessage());
//		 }
	}
}
