package org.micro_gzm.v5.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.util.Log;


public class Model3D extends Entity3D {
	
	static final int COORDS_PER_VERTEX = 3;
	private int vertexCount;
	private final int vertexStride = COORDS_PER_VERTEX * 4; // bytes per vertex

    private final String vertexShaderCode =
        "attribute vec4 vPosition;" +
        "void main() {" +
        "  gl_Position = vPosition;" +
        "}";

    private final String fragmentShaderCode =
        "precision mediump float;" +
        "uniform vec4 vColor;" +
        "void main() {" +
        "  gl_FragColor = vColor;" +
        "}";
	
//	public float[] vertices;
//	public short[] indices;
//	public float[] UVS;
	
	private FloatBuffer vertexBuffer;
	private ShortBuffer indexBuffer;
	

    private int program;
    private int mPositionHandle;
    private int mColorHandle;
    
    float color[] = { 0.63671875f, 0.76953125f, 0.22265625f, 1.0f };
	
	public Model3D() {

	}
	
	public void initialize(Object3D dataIn) {
		//vertices = dataIn.vertices;
		//indices = dataIn.indices;
		//UVS = dataIn.UVS;
		
		float verts[] = {-0.5f,-0.5f,0.5f,0.5f,-0.5f,0.5f,-0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,-0.5f,0.5f,-0.5f,0.5f,0.5f,-0.5f,-0.5f,-0.5f,-0.5f,0.5f,-0.5f,-0.5f};
		short inds[] = {0, 1, 2, 2, 1, 3, 2, 3, 4, 4, 3, 5, 4, 5, 6, 6, 5, 7, 6, 7, 0, 0, 7, 1, 1, 7, 3, 3, 7, 5, 6, 0, 4, 4, 0, 2};
		
//		vertexCount = dataIn.indices.length / COORDS_PER_VERTEX;
		vertexCount = verts.length / COORDS_PER_VERTEX;

//		ByteBuffer vbb = ByteBuffer.allocateDirect(dataIn.vertices.length * 4);
		ByteBuffer vbb = ByteBuffer.allocateDirect(verts.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer = vbb.asFloatBuffer();
		vertexBuffer.put(verts);
		vertexBuffer.position(0);

//		ByteBuffer ibb = ByteBuffer.allocateDirect(dataIn.indices.length * 2);
		ByteBuffer ibb = ByteBuffer.allocateDirect(inds.length * 2);
		ibb.order(ByteOrder.nativeOrder());
		indexBuffer = ibb.asShortBuffer();
		indexBuffer.put(inds);
		indexBuffer.position(1);
		
		// prepare shaders and OpenGL program
//        int vertexShader = GZMRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
//        int fragmentShader = GZMRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
//
//        program = GLES20.glCreateProgram();             // create empty OpenGL Program
//        GLES20.glAttachShader(program, vertexShader);   // add the vertex shader to program
//        GLES20.glAttachShader(program, fragmentShader); // add the fragment shader to program
//        GLES20.glLinkProgram(program);
	}
	
	public void setGL(GL10 glIn) {
	}
	
	public void rotate(float val, int x, int y, int z) {
	}

	public void translate(float x, float y, float z) {
	}
	
	public void draw(float[] mvpMatrix) {
		
		 GLES20.glEnableVertexAttribArray(0);
		 GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, vertexStride, vertexBuffer);
		 GLES20.glDrawElements(GL10.GL_TRIANGLES, 12, GL10.GL_UNSIGNED_SHORT, indexBuffer);
		
		 
		 Log.d("MG", "" + vertexStride);
//		 // Add program to OpenGL environment
//        GLES20.glUseProgram(program);
//
//        // get handle to vertex shader's vPosition member
//        mPositionHandle = GLES20.glGetAttribLocation(program, "vPosition");
//
//        // Enable a handle to the triangle vertices
//        GLES20.glEnableVertexAttribArray(mPositionHandle);
//
//        // Prepare the triangle coordinate data
//        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
//                                     GLES20.GL_FLOAT, false,
//                                     vertexStride, vertexBuffer);
//        
//        GLES20.glEna
//
//        // get handle to fragment shader's vColor member
//        mColorHandle = GLES20.glGetUniformLocation(program, "vColor");
//
//        // Set color for drawing the triangle
//        GLES20.glUniform4fv(mColorHandle, 1, color, 0);
//
//        // Draw the triangle
//        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);
//
//        // Disable vertex array
//        GLES20.glDisableVertexAttribArray(mPositionHandle);

//        GLES20.glUseProgram(program);
//        
//        Log.d("MG", "drawing " + mPositionHandle);
//        
//        // get handle to vertex shader's vPosition member
//        mPositionHandle = GLES20.glGetAttribLocation(program, "vPosition");
//
//        // Enable a handle to the triangle vertices
//        GLES20.glEnableVertexAttribArray(mPositionHandle);
//        
//        // Prepare the triangle coordinate data
//        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
//                                     GLES20.GL_FLOAT, false,
//                                     vertexStride, vertexBuffer);
//        
//     // get handle to fragment shader's vColor member
//        mColorHandle = GLES20.glGetUniformLocation(program, "vColor");
//        
//     // Set color for drawing the triangle
//        GLES20.glUniform4fv(mColorHandle, 1, color, 0);
//
//        // Draw the triangle
//        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);
//
//        // Disable vertex array
//        GLES20.glDisableVertexAttribArray(mPositionHandle);
//        
////		// Specifies the location and data format of an array of vertex
////		// coordinates to use when rendering.
////		
////		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
////
////		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
	}

}
