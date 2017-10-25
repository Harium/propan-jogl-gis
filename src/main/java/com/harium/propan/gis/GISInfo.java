package com.harium.propan.gis;

public class GISInfo {

    /**
     * Pixel size in the x-direction in map units/pixel
     */
	private double pixelSizeX = 0;
    
	/**
	 * Pixel size in the y-direction in map units, almost always negative
	 */
    private double pixelSizeY = 0;
    
    /**
     * Rotation about x-axis
     */
    private double rotationX = 0;
    
    /**
     * Rotation about y-axis
     */
    private double rotationY = 0;
    
    /**
     * x-coordinate of the center of the upper left pixel
     */
    private double topLeftX = 0;
    
    /**
     * y-coordinate of the center of the upper left pixel
     */
    private double topLeftY = 0;

	public double getPixelSizeX() {
		return pixelSizeX;
	}

	public void setPixelSizeX(double pixelSizeX) {
		this.pixelSizeX = pixelSizeX;
	}

	public double getPixelSizeY() {
		return pixelSizeY;
	}

	public void setPixelSizeY(double pixelSizeY) {
		this.pixelSizeY = pixelSizeY;
	}

	public double getRotationX() {
		return rotationX;
	}

	public void setRotationX(double rotationX) {
		this.rotationX = rotationX;
	}

	public double getRotationY() {
		return rotationY;
	}

	public void setRotationY(double rotationY) {
		this.rotationY = rotationY;
	}

	public double getTopLeftX() {
		return topLeftX;
	}

	public void setTopLeftX(double topLeftX) {
		this.topLeftX = topLeftX;
	}

	public double getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(double topLeftY) {
		this.topLeftY = topLeftY;
	}
	
	public double getXProjection(double x, double y) {
		return pixelSizeX*x + rotationX*y + topLeftX;
	}
	
	public double getYProjection(double x, double y) {
		return rotationY*x + pixelSizeY*y + topLeftY;
	}   	
}
