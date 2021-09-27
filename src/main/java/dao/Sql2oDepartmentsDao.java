package dao;

import models.Departments;
import models.User;
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
        String sql = "INSERT INTO departments (name, userDepartment, userPosition, role, departmentId) VALUES (:name, :userDepartment, :userPosition, :role, :departmentId)";
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

//    @Override
//    public void assignUsersSDepartments(Departments department, User user) {
//        String sql = "INSERT INTO user_departments (user_Id, department_Id) VALUES (:user_Id, :department_Id)";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("user_Id", user.getId())
//                    .addParameter("department_Id", department.getId())
//                    .executeUpdate();
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }


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


//    @Override
//    public List<User> getAllUsersInDepartment(int User_Id) {
//        return null;
//    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
//                    .addParameter("id", id)
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
