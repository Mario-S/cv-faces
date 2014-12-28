package org.javacv.face.image;

import java.io.File;
import org.bytedeco.javacpp.opencv_core.Mat;
import static org.bytedeco.javacpp.opencv_highgui.imread;

/**
 *
 * @author spindizzy
 */
@FunctionalInterface
public interface ImageProvideable {
    
    Mat provide();
    
    static Mat read(File file) {
        return imread(file.getAbsolutePath());
    }
}