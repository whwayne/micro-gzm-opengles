package org.micro_gzm.v5.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.micro_gzm.v5.loaders.fbx.FBXLoader;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;


public class ResourceManager {
	
	private AssetManager manager;

	
	public ResourceManager(Context ctx) {

		manager = ctx.getAssets();
	}
	
	// TODO Finish the tutorial on loading images, 
	// translate the FBXLoader (and the related classes) from the flash version	
	public void loadFBXFile(String filePath) {
		
		
		FBXLoader loader = new FBXLoader();
		try {
			//new BufferedReader(new InputStreamReader(manager.open(filePath), "UTF8"));
			loader.loadFBX(new BufferedReader(new InputStreamReader(manager.open(filePath), "UTF8")));
		}
		catch (IOException e) {
			Log.d("MG", "Error: " + e.getMessage());
		}
	}

}
