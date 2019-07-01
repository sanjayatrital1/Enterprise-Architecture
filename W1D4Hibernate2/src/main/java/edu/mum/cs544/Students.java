package edu.mum.cs544;

import java.sql.*;
import java.util.Objects;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "edu.mum.cs544.Students")
@Table(name = "students")
public class Students {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"name\"", nullable = true)
  private String name;
  @Column(name = "\"email\"", nullable = true)
  private String email;
  @Column(name = "\"password\"", nullable = true)
  private String password;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Students students = (Students) o;
    return Objects.equals(id, students.id) &&
            Objects.equals(name, students.name) &&
            Objects.equals(email, students.email) &&
            Objects.equals(password, students.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password);
  }
}