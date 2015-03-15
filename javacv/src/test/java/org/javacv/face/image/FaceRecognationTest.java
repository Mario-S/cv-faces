/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.javacv.face.image;

import java.net.URL;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author spindizzy
 */
public class FaceRecognationTest {
    
    /**
     * Test of predict method, of class SimpleFaceRecognation.
     */
    @Test
    public void testPredict_GrayScale() {
        String path = getClass().getResource("train").getPath();
        FaceRecognition classUnderTest = new FaceRecognition(new DefaultTrainer(path));
        
        String imgName = getClass().getResource("1_test.jpg").getFile();
        int result = classUnderTest.predict(imgName);
        assertEquals(1, result);
        
        imgName = getClass().getResource("2_test.jpg").getFile();
        result = classUnderTest.predict(imgName);
        assertEquals(2, result);
        
        imgName = getClass().getResource("3_test.jpg").getFile();
        result = classUnderTest.predict(imgName);
        assertEquals(3, result);
        
        imgName = getClass().getResource("3_salma_test.jpg").getFile();
        result = classUnderTest.predict(imgName);
        assertEquals(3, result);
    }
    
}
