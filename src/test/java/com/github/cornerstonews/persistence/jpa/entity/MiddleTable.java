package com.github.cornerstonews.persistence.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "middle_table")
public class MiddleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 16)
    private String someString;

    @ManyToOne
    @JoinColumn(name = "example", nullable = false)
    private Example example;

    @ManyToOne
    @JoinColumn(name = "edge_table", nullable = false)
    private EdgeTable edgeTable;


    public MiddleTable() {
        // for JPA
    }

    public MiddleTable(final String someString, final Example example, final EdgeTable edgeTable) {
        this.someString = someString;
        this.example = example;
        this.edgeTable = edgeTable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(final String someString) {
        this.someString = someString;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(final Example example) {
        this.example = example;
    }

    public EdgeTable getEdgeTable() {
        return edgeTable;
    }

    public void setEdgeTable(final EdgeTable edgeTable) {
        this.edgeTable = edgeTable;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MiddleTable that = (MiddleTable) o;
        return Objects.equals(id, that.id) && Objects.equals(someString, that.someString) && Objects.equals(example, that.example) && Objects.equals(edgeTable, that.edgeTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, someString, example, edgeTable);
    }

    @Override
    public String toString() {
        return "MiddleTable{" +
                "id=" + id +
                ", someString='" + someString + '\'' +
                ", example=" + example +
                ", edgeTable=" + edgeTable +
                '}';
    }
}

