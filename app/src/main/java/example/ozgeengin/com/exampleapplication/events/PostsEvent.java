package example.ozgeengin.com.exampleapplication.events;

import example.ozgeengin.com.exampleapplication.models.Post;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * post response event for event bus.
 */
public class PostsEvent {
    public Post[] result;

    public PostsEvent(Post[] result){
        this.result = result;
    }
}
