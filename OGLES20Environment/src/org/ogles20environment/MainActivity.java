package org.ogles20environment;

import org.ogles20environment.core.GZMGLSurfaceView;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLView = new GZMGLSurfaceView(this);
        
        setContentView(mGLView);
    }
}
