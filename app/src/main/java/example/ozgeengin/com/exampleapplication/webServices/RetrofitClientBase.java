package example.ozgeengin.com.exampleapplication.webServices;

import retrofit2.Retrofit;

/**
 * Created by Özge Engin on 16.06.2018.
 * Web service classes should be extended from this abstract class
 */
abstract class RetrofitClientBase {

    protected final WebService service;

    /**
     * Default constructor for retrofit settings
     */
    RetrofitClientBase() {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Retrofit retrofit = retrofitBuilder.CreateRetrofit();
        service = retrofit.create(WebService.class);
    }

    abstract void Run() ;
}
