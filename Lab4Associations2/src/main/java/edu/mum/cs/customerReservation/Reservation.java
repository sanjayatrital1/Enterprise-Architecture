package edu.mum.cs.customerReservation;

import edu.mum.cs.bookPublisher.Book;

import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
