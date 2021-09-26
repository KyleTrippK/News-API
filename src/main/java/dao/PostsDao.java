package dao;

import models.Post;

import java.util.List;

public interface PostsDao {

        // create
        void add(Post post);

        // read
        List<Post> getAll();
        //Post findById(int id);

        //delete
        void deleteById(int id);
        void clearAll();
}
