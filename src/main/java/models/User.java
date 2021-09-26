package models;

public class User {
    private String name;
    private String userPosition;
    private String userDepartment;
    private String role;
    private int id;

    public User(String name, String userPosition, String userDepartment, String role) {
        this.name = name;
        this.userPosition = userPosition;
        this.userDepartment = userDepartment;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
