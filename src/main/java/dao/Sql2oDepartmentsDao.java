package dao;

import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentsDao implements DepartmentsDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentsDao(Sql2o sql2o) {
        this.sql2o =sql2o;
    }

    @Override
    public void add(Departments department) {
        String sql = "INSERT INTO departments (names, description, members) VALUES (:names, :description, :members)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


    @Override
    public List<Departments> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public Departments findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE  id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
            String sql = "DELETE * FROM departments";
            try (Connection con = sql2o.open()){
                con.createQuery(sql)
                        .executeUpdate();
            } catch (Sql2oException ex){
                System.out.println(ex);
            }
    }
}
