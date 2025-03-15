package org.example.entity;

public class Technology {

    private int id;
    private String name;
    private ProgrammingLanguage programmingLanguage;

    public Technology(int id, String name, ProgrammingLanguage programmingLanguage) {
        this.id = id;
        this.name = name;
        this.programmingLanguage = programmingLanguage;
    }

    public Technology() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", programmingLanguage=" + programmingLanguage +
                '}';
    }
}
