
import com.google.gson.Gson;
import dao.Sql2oPostsDao;
import dao.Sql2oUserDao;
import models.Departments;
import models.Post;
import dao.Sql2oDepartmentsDao;
import models.User;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        Sql2oDepartmentsDao departments;
        Sql2oPostsDao sql2opost;
        Sql2oUserDao sql2ouser;
        Connection con;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/localhost.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departments = new Sql2oDepartmentsDao(sql2o);
        sql2opost = new Sql2oPostsDao(sql2o);
        sql2ouser = new Sql2oUserDao(sql2o);

        post("/department/new", "application/json", (req, res) -> {
            Departments department = gson.fromJson(req.body(), Departments.class);
            departments.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });
        get("department", "application/json", (req, res) -> {
           res.type("application/json");
           return gson.toJson(departments.getAll());
        });

        post("/posts/new", "application/json", (req, res) -> {
            Post post = gson.fromJson(req.body(), Post.class);
            sql2opost.add(post);
            res.status(201);
            res.type("application/json");
            return gson.toJson(post);
        });

        get("/posts", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(sql2opost.getAll());
        });

        post("users/new", "application/json", (req, res) -> {
           User user = gson.fromJson(req.body(), User.class);
            sql2ouser.add(user);
           res.status(201);
           res.type("application/json");
           return gson.toJson(user);
        });

        get("/users", "application/json", (req, res) -> {
           res.type("application/json");
           return gson.toJson(sql2ouser.getAll());
        });

    }
}


