package example.ozgeengin.com.exampleapplication.logger;

import android.os.Environment;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Settings for log4j logger
 */
class CustomLogger {
    private final static Logger logger  ;

    static  {
        LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.setFileName(String.format("%s/log.txt", Environment.getExternalStorageDirectory().getPath()));
        logConfigurator.setRootLevel(Level.ALL);
        logConfigurator.setLevel("org.apache", Level.ALL);
        logConfigurator.setUseFileAppender(true);
        logConfigurator.setFilePattern("%d %-5p [%c{2}]-[%L] %m%n");
        logConfigurator.setMaxFileSize(1024 * 1024);
        logConfigurator.setImmediateFlush(true);
        logConfigurator.configure();
        logger = Logger.getLogger("CustomLogger");

    }

    Logger getLogger(){return logger;}
}
