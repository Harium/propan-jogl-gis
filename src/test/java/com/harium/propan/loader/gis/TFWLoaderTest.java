package com.harium.propan.loader.gis;

import java.io.File;
import java.io.IOException;

import com.harium.propan.gis.GISInfo;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TFWLoaderTest extends TestCase {
	
	private TFWLoader loader;
	
	@Before
	public void setUp() {
		loader = new TFWLoader();
	}
	
	@Test
	public void testLoad() {
		
		String path = System.getProperty("user.dir");
		path += "/assets/images/tile.tfw";
				
		GISInfo info = null;
		
		try {
			info = loader.loadGISInfo(new File(path));
			assertNotNull(info);
		} catch (IOException e) {
			fail();
		}
		
		assertEquals(0.2605915491, info.getPixelSizeX());
		assertEquals(0.0000000000, info.getRotationX());
		assertEquals(0.0000000000, info.getRotationY());
		assertEquals(-0.2605915491, info.getPixelSizeY());
		assertEquals(-5342633.9710490583, info.getTopLeftX());
		assertEquals(-1801272.9702671464, info.getTopLeftY());		
	}
	
}
