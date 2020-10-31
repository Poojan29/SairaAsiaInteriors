package com.example.sairaasiainteriors;

public class EmployeeNames {

    public String name;
    public String indexno;

    public EmployeeNames() {
    }

    public EmployeeNames(String name, String indexno) {
        this.name = name;
        this.indexno = indexno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndexno() {
        return indexno;
    }

    public void setIndexno(String indexno) {
        this.indexno = indexno;
    }
}
