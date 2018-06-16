package example.ozgeengin.com.exampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.squareup.otto.Subscribe;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import example.ozgeengin.com.exampleapplication.events.BusProvider;
import example.ozgeengin.com.exampleapplication.events.PostsEvent;
import example.ozgeengin.com.exampleapplication.logger.ILog;
import example.ozgeengin.com.exampleapplication.models.Post;
import example.ozgeengin.com.exampleapplication.webServices.PostListRequest;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Simple activity which takes an api response value and adds into the listView
 */
public class MainActivity extends AppCompatActivity implements ILog {

    @BindView(R.id.postList)
    ListView postList;

    @Inject
    PostListRequest postListRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dependency injection
        CustomApplication.getAppComponent().inject(this);

        ButterKnife.bind(this);

        BusProvider.getInstance().register(this);

        logger.info(String.format("%s %s", MainActivity.class.getName(),"onCreate"));
        postListRequest.Run();
    }

    /**
     * /posts web api response event. Updates the listView.
     * @param event for adding markers
     */
    @Subscribe
    public void onGetPostsEvent(PostsEvent event){
        logger.info(String.format("%s %s", MainActivity.class.getName(),"onGetPostsEvent"));
        String[] result=new String[event.result.length];
        for(int i=0;i<event.result.length;i++)
            result[i]=event.result[i].getTitle();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, result);
        postList.setAdapter(adapter);
    }
}
