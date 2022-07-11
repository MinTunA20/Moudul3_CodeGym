package model;

public class Department {
    private int id;
    private String nameDep;

    public Department(int id, String nameDep) {
        this.id = id;
        this.nameDep = nameDep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnameDep() {
        return nameDep;
    }

    public void setnameDep(String nameDep) {
        this.nameDep = nameDep;
    }
}