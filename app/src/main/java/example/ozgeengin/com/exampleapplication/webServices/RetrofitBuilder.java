package example.ozgeengin.com.exampleapplication.webServices;

import android.content.Context;
import android.support.annotation.NonNull;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import example.ozgeengin.com.exampleapplication.CustomApplication;
import example.ozgeengin.com.exampleapplication.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Özge Engin on 16.06.2018.
 * Retrofit builder class for api calls
 */
public class RetrofitBuilder {

    @Inject
    Context context;

     RetrofitBuilder(){
        CustomApplication.getAppComponent().inject(this);
    }


    /**
     * Setup retrofit for api requests
     * @return retrofit object
     */
    Retrofit CreateRetrofit (){
        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.server_url))
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * Setup OkHttpClient for retrofit
     * @return OkHttpClient
     */
    @NonNull
    private OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        System.setProperty("http.keepAlive", "true");
        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(0, TimeUnit.DAYS)
                .readTimeout(0, TimeUnit.DAYS)
                .writeTimeout(0, TimeUnit.DAYS)
                .build();
    }
}