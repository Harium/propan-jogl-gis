package com.harium.propan.loader.gis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.harium.propan.gis.GISInfo;

/**
 * Tfw file loader
 * 
 * @author yuripourre
 *
 */
public class TFWLoader implements GISFileLoader {

	/*
	 * Reference: http://testdrive.mapinfo.com/TechSupp/MIProd.nsf/05edbd1e930f8d4d8525712500748199/61409cb5b20c23f28525771a0054558a?OpenDocument
     * Line 1: A: pixel size in the x-direction in map units/pixel
     * Line 2: D: rotation about y-axis
     * Line 3: B: rotation about x-axis
     * Line 4: E: pixel size in the y-direction in map units, almost always negative
     * Line 5: C: x-coordinate of the center of the upper left pixel
     * Line 6: F: y-coordinate of the center of the upper left pixel
	 */
	private static final int TFW_LINES = 6;
	
	public GISInfo loadGISInfo(File file) throws IOException {
		
		GISInfo info = new GISInfo();
		
		int countLines = 0;
		
		BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
                
        while((line = buffer.readLine()) != null) {
        	countLines++;
        	if(countLines>TFW_LINES) {
            	break;
            }
        	buildInfo(info, line, countLines);
        }
		
		return info;
	}
	
	private void buildInfo(GISInfo info, String data, int index) {
		
		double value = Double.parseDouble(data);
		
		switch (index) {
		case 1:
			info.setPixelSizeX(value);
			break;
		case 2:
			info.setRotationX(value);
			break;
		case 3:
			info.setRotationY(value);
			break;
		case 4:
			info.setPixelSizeY(value);
			break;
		case 5:
			info.setTopLeftX(value);			
			break;
		case 6:
			info.setTopLeftY(value);			
			break;
		default:
			break;
		}		
	}
	
}
