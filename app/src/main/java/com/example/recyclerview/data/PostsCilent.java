package com.example.recyclerview.data;

import com.example.recyclerview.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsCilent {
    private static final String BASE_URL ="https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static  PostsCilent INSTANCE;

    public PostsCilent() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface=retrofit.create(PostInterface.class);
    }

    public static PostsCilent getINSTANCE() {
        if (null==INSTANCE)
        {
            INSTANCE=new PostsCilent();
        }
        return INSTANCE;
    }
    public Call<List<PostModel>>getPosts(){
        return postInterface.getPosts();
    }
}
