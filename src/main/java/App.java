
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {


        sql2oDepartments departments;
        sql2oNews sql2oNew ;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departments = new sql2oDepartments(sql2o);
        sql2oNew = new sql2oNews(sql2o);
//        conn = sql2o.open();

        post("/department/new", "application/json", (req, res) -> {
            Departments department1 = gson.fromJson(req.body(), Departments.class);
            departments.create(department1);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department1);
        });

        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            sql2oNew.create(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

    }
}
