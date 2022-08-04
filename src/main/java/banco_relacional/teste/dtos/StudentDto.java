package banco_relacional.teste.dtos;

import banco_relacional.teste.entities.Course;

import java.util.List;

public class StudentDto {
    String name;
    String city;
    List<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
