package com.mycompany.Student.students;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "College_name")
    private String college;

    @Column(name = "Email")
    private String email;

    @Column(name = "Branch")
    private String branch;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", College='" + college + '\'' +
                ", Email='" + email + '\'' +
                ", Branch='" + branch + '\'' +
                '}';
    }
}
