package com.harium.propan.loader.gis;

import java.io.File;
import java.io.IOException;

import com.harium.propan.gis.GISInfo;

public interface GISFileLoader {
	GISInfo loadGISInfo(File file) throws IOException;
}
