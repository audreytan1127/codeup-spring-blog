//package edu.codeup.codeupspringblog.models;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="contacts")
//public class Contact {
//    @Id
////    This will auto increment the primary ID key which is indicated through ID annotation
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    @Column(nullable = false, length = 50, unique = true)
//    private String name;
//    @Column(nullable = false, length = 100, unique = true)
//    private String email;
//
//    public Contact(){}
//    public Contact(long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
