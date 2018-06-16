package example.ozgeengin.com.exampleapplication.logger;

import org.apache.log4j.Logger;

/**
 * Created by ozge on 16.06.2018.
 */

public interface ILog {
    Logger logger = new CustomLogger().getLogger();
}
