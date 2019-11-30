package org.javacv.detect;

import org.javacv.detect.face.haar.HaarDetector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link DetectorFactory}.
 */
class DetectorFactoryTest {

    @Test
    @Tag("detector")
    @DisplayName("It should create an instance of a HaarDetector")
    void create_Haar() {
        Detectable result = DetectorFactory.create(DetectorFactory.DetectorType.HAAR);
        assertTrue(result instanceof HaarDetector);
    }

    @Test
    @Tag("detector")
    @DisplayName("It should throw an exception for unsupported type")
    void create_Unsupported() {
        assertThrows(UnsupportedOperationException.class, () -> DetectorFactory.create(DetectorFactory.DetectorType.DNN));
    }
}