package example.ozgeengin.com.exampleapplication.di;

import javax.inject.Singleton;
import dagger.Component;
import example.ozgeengin.com.exampleapplication.CustomApplication;
import example.ozgeengin.com.exampleapplication.MainActivity;
import example.ozgeengin.com.exampleapplication.storage.Storage;
import example.ozgeengin.com.exampleapplication.webServices.RetrofitBuilder;

/**
 * Created by Özge Engin on 16.06.2018.
 * Dagger 2 component interface for dependency injection
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(CustomApplication application);
    void inject(RetrofitBuilder retrofitBuilder);
    void inject(Storage storage);
}