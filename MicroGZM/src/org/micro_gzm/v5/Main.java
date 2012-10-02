package org.micro_gzm.v5;

import org.micro_gzm.v5.core.GZMRenderer;
import org.micro_gzm.v5.core.Model3D;
import org.micro_gzm.v5.core.ResourceManager;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Main extends Activity {
	
	private Model3D model;
	private ResourceManager mng;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(new GZMRenderer());
        
        setContentView(view);
        
        initialize();
    }
    
    private void initialize() {
    	
    	model = new Model3D();
    	mng = new ResourceManager(this);
    	mng.loadFBXFile("models/cube.fbx");
    }
}
