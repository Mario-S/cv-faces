package org.javacv.face.detection;

import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;

import java.io.File;
import java.net.URL;

/**
 * Factory for {@link CascadeClassifier}.
 * 
 * @author spindizzy
 */
public enum ClassifierFactory {

    Instance;

    public CascadeClassifier create(String fileName) {
        URL resource = getClass().getResource(fileName);
        var path = new File(resource.getPath()).getPath();
        return new CascadeClassifier(path);
    }
}
