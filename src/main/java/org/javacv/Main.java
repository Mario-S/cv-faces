package org.javacv;

import org.javacv.ui.CanvasDemo;
import org.javacv.ui.VideoWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.IVersionProvider;
import picocli.CommandLine.Option;

/**
 * Main Entry point for the demo application.
 */
@Command(name = "video", mixinStandardHelpOptions = true,
        description = "Java application which uses OpenCV",
        versionProvider = Main.class)
public class Main implements Runnable, IVersionProvider {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    @Option(names = "-c", description = "use canvas frame from OpenCV library")
    boolean canvas;

    public static void main(String[] args) {
        Main main = new Main();
        CommandLine cmd = new CommandLine(main);
        int exitCode = cmd.execute(args);
        System.exit(exitCode);
    }

    private void join() {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            LOG.warn(e.getMessage(), e);
        }
    }

    @Override
    public void run() {
        if (canvas) {
            CanvasDemo.launch();
        } else {
            VideoWindow.launch();
        }
        join();
    }

    @Override
    public String[] getVersion() throws Exception {
        return new String[] {"201911"};
    }
}
