package org.javacv.ui.opencv;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.javacv.detect.DetectorFactory;
import org.javacv.detect.DetectorService;

import org.javacv.glue.ImageShowable;
import org.javacv.glue.Launcher;

/**
 * A demo which uses the provided {@link CanvasFrame}.
 *
 * @author spindizzy
 */
public class CanvasLauncher implements Launcher {

    private CanvasFrame canvas;
    
    private final ExecutorService executorService;
    
    private DetectorService detectorService;

    public CanvasLauncher() {
        executorService = Executors.newFixedThreadPool(3);
    }

    @Override
    public void launch(String ... args) {
        var detector = (args != null && args.length > 0) ? args[0] : "dnn";
        //Create canvas frame for displaying video.
        canvas = new CanvasFrame("Video Canvas");

        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setCanvasSize(300, 300);

        canvas.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                detectorService.stop();
                executorService.shutdown();
            }

        });

        var det = DetectorFactory.create(detector);
        detectorService = new DetectorService(new CanvasProxy(canvas), det);
        executorService.execute(detectorService);
    }

    private static class CanvasProxy implements ImageShowable {
        private final CanvasFrame canvas;

        CanvasProxy(CanvasFrame canvas) {
            this.canvas = canvas;
        }

        @Override
        public void setSize(int width, int height) {
            canvas.setCanvasSize(width, height);
        }

        @Override
        public void showImage(Frame image) {
            canvas.showImage(image);
        }
    }
}
