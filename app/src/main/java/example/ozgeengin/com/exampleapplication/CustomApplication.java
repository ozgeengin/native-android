package example.ozgeengin.com.exampleapplication;

import android.app.Application;
import example.ozgeengin.com.exampleapplication.di.AppComponent;
import example.ozgeengin.com.exampleapplication.di.AppModule;
import example.ozgeengin.com.exampleapplication.di.DaggerAppComponent;

/**
 *  Created by Özge Engin on 16.06.2018
 *  Custom application class for dependency injection settings
 */
public class CustomApplication  extends Application {

    //Dagger 2 app component
    private static AppComponent appComponent;

    /**
     * Setup for dependency injection and context
     */
    @Override
    public void onCreate () {
        super.onCreate();
        appComponent = initDagger(this);
        appComponent.inject(this);
    }


    public static AppComponent getAppComponent() {
        return appComponent;
    }

    /**
     * Initialize Dagger module and component
     * @param application object
     * @return App Component
     */
    protected AppComponent initDagger(Application application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}