package dao;

import models.Departments;
import models.User;

import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oUserDao implements UsersDao{
    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (name, userPosition, userDepartment, role, userId) VALUES(:name, :userPosition, :userDepartment, :role :userId)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
//
//    @Override
//    public void addUserToDepartment(User user, Departments department){
//        String sql = "INSERT INTO user_departments (user_Id, department_Id) VALUES (:user_Id, :department_Id)";
//        try(Connection con = sql2o.open()){
//            con.createQuery(sql)
//                    .addParameter("user_Id", user.getId())
//                    .addParameter("department_Id", department.getId())
//                    .executeUpdate();
//        } catch(Sql2oException ex){
//            System.out.println(ex);
//        }
//    }

//    @Override
//    public List<Departments> getAllUsersInDepartment(int user_Id){
//        ArrayList<Departments> department = new ArrayList<>();
//        String joinQuery = "SELECT department_Id FROM user_departments WHERE user_Id = :user_Id";
//        try( Connection con = sql2o.open()) {
//            List<Integer> allDepartments = con.createQuery(joinQuery)
//                    .addParameter("user_Id", user_Id)
//                    .executeAndFetch(Integer.class);
//            for (Integer department_Id : allDepartments) {
//                String departmentQuery = "SELECT * FROM department WHERE id = :department_Id";
//                department.add(
//                        con.createQuery(departmentQuery)
//                                .addParameter("departmet_Id", department_Id)
//                                .executeAndFetchFirst(Departments.class));
//            }
//        } catch (Sql2oException ex){
//            System.out.println(ex);
//        }
//        return department;
//    }

    @Override
    public List<User> getAll() {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * from users")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User findById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE * from users WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
//                    .addParameter("id", id)
                    .executeUpdate();
        }  catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE * from users";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }
}
