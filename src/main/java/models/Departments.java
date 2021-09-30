package models;

public class Departments {
    private int id;
    private String names;
    private String description;
    private int members;

    public Departments(String names, String description, int members) {
        this.names = names;
        this.description = description;
        this.members = members;

    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
