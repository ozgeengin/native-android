package example.ozgeengin.com.exampleapplication.webServices;

import com.squareup.otto.Produce;
import example.ozgeengin.com.exampleapplication.events.BusProvider;
import example.ozgeengin.com.exampleapplication.events.PostsEvent;
import example.ozgeengin.com.exampleapplication.logger.ILog;
import example.ozgeengin.com.exampleapplication.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Web api response class for /posts
 */
public class PostListWebService implements Callback<Post[]>, ILog {

    @Override
    public void onResponse(Call<Post[]> call, Response<Post[]> response) {
        if(response.code()==200)
            BusProvider.getInstance().post(produceGetPostsEvent(response.body()));

        logger.info(String.format("%s %s", PostListWebService.class.getName(), "Success"));
    }

    @Override
    public void onFailure(Call<Post[]> call, Throwable t) {
        logger.error(String.format("%s %s",PostListWebService.class.getName(),t.getMessage()));
    }

    /**
     * Produce PostsEvent for MainActivity
     * @param posts
     * @return event
     */
    @Produce
    private PostsEvent produceGetPostsEvent(Post[] posts){
        return new PostsEvent(posts);
    }

}