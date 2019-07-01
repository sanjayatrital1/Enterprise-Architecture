package edu.mum.cs.bookPublisher;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinTable(name = "book_publisher", joinColumns = {@JoinColumn(name = "publisher_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Publisher publisher;

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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
