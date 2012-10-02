package org.micro_gzm.v5.loaders.fbx;

import java.io.BufferedReader;
import java.io.IOException;

import com.eaio.stringsearch.StringSearch;

import android.util.Log;

public class FBXLoader {
	
	protected final String NAME = "FBXLoader";
	
	protected String fbxData = "";
	
	protected FBXHeaderExtension fbxHeaderExtension;
	protected FBXDefinitions fbxDefinitions;

	
	public FBXLoader() {
		// TODO Auto-generated constructor stub
	}
	
	public void loadFBX(BufferedReader bufferIn) {
		

		BufferedReader buffer = bufferIn;
		String line;
		
		try {
			while (( line = buffer.readLine()) != null) fbxData += line;
			
			initialize();
		}
		catch (IOException e) {

			Log.d("MG", "Error: " + e.getMessage());
		}
		
	}
	
	private void initialize() {
		
		//fbxHeaderExtension = new FBXHeaderExtension(getBlock(fbxData, FBXHeaderExtension.NAME));
		fbxDefinitions = new FBXDefinitions(getBlock(fbxData, FBXDefinitions.NAME));
		
		
		Log.d("MG", fbxHeaderExtension.getData());
		
	}
	
	protected String getBlock(String dataIn, String blockName) {
		
		Log.d("MG", "getting block");
		
		String block = "";
		int begin = dataIn.indexOf(blockName);
		
		Log.d("MG", Integer.toString(begin));
		
		if(begin != -1) {
			
			int i;
			int bracks = 0;
			boolean started = false;
			
			for( i = begin; i < dataIn.length(); i++) {
				
				if(String.valueOf(dataIn.charAt(i)) == "{") {
					
					started = true;
					bracks++;
				}
				if(String.valueOf(dataIn.charAt(i)) == "}") bracks--;
				
				block += String.valueOf(dataIn.charAt(i));
				
				if(bracks == 0 && started) break;
				
			}
		}
		Log.d("MG", "DONE");
		
		
//		Log.d("MG", Integer.toString(a));
		
		return block;
	}
	
	protected int search(String dataIn, String str) {
		
		return -1;
	}
}
