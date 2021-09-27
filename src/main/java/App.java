
import com.google.gson.Gson;
import dao.Sql2oPostsDao;
import models.Departments;
import models.Post;
import dao.Sql2oDepartmentsDao;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        Sql2oDepartmentsDao departments;
        Sql2oPostsDao sql2opost;
        Connection con;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departments = new Sql2oDepartmentsDao(sql2o);
        sql2opost = new Sql2oPostsDao(sql2o);

        post("/department/new", "application/json", (req, res) -> {
            Departments department = gson.fromJson(req.body(), Departments.class);
            departments.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        post("/posts/new", "application/json", (req, res) -> {
            Post post = gson.fromJson(req.body(), Post.class);
            sql2opost.add(post);
            res.status(201);
            res.type("application/json");
            return gson.toJson(post);
        });

    }
}


