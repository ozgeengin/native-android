package example.ozgeengin.com.exampleapplication.webServices;

import example.ozgeengin.com.exampleapplication.models.Post;
import retrofit2.Call;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Web api request class for /posts
 */
public class PostListRequest extends RetrofitClientBase {

    public void Run() {
        Call<Post[]> call = service.GetPostList();
        call.enqueue(new PostListWebService());
    }

}