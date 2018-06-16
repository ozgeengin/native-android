package example.ozgeengin.com.exampleapplication.webServices;

import example.ozgeengin.com.exampleapplication.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Web service interface for retrofit
 */
interface WebService {
    @GET("posts")
    Call<Post[]> GetPostList();

}
