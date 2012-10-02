package org.micro_gzm.v5;

import org.micro_gzm.v5.core.GZMRenderer;
import org.micro_gzm.v5.core.ResourceManager;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity {
	
	private GZMRenderer renderer;
	private ResourceManager mng;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        renderer = new GZMRenderer();
        
        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(renderer);
        
        setContentView(view);
        
        initialize();
    }
    
    private void initialize() {
    	
    	Log.d("MG", "start");
    	
    	mng = new ResourceManager(this);
    	mng.loadFBXFile("models/off.fbx");
    	
    	renderer.addModel(mng.getModel());
    	
    	Log.d("MG", "end");
    }
}
