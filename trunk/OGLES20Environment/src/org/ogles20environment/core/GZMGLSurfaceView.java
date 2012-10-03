package org.ogles20environment.core;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class GZMGLSurfaceView extends GLSurfaceView {
	
	public GZMGLSurfaceView(Context context){
        super(context);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(new GZMRenderer());
    }

}
