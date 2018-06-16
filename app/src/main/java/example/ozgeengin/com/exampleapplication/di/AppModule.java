package example.ozgeengin.com.exampleapplication.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import example.ozgeengin.com.exampleapplication.R;
import example.ozgeengin.com.exampleapplication.storage.Storage;
import example.ozgeengin.com.exampleapplication.webServices.PostListRequest;

/**
 * Created by Özge Engin on 16.06.2018
 * Dagger 2 module class for dependency injection
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context getContext(){return this.application.getApplicationContext();}

    @Provides
    @Singleton
    SharedPreferences getSharedPreferences() {
        return getContext().getSharedPreferences(getContext().getString(R.string.SharedPreference), Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences.Editor getEditor(){
        return getSharedPreferences().edit();
    }

    @Provides
    @Singleton
    Storage getStorage(){ return new Storage();}

    @Provides
    @Singleton
    PostListRequest GetPostListRequest() {
        return new PostListRequest();
    }
}
