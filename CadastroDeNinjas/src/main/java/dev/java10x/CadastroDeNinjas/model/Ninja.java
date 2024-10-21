package dev.java10x.CadastroDeNinjas.model;


import jakarta.persistence.*;

//entity ele transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro")
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String age;
    @Column
    private String email;

    public Ninja() {

    }

    public Ninja(String age, String email, String name) {
        this.age = age;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
