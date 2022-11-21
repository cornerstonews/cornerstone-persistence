package com.github.cornerstonews.persistence.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "edge_table")
public class EdgeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 16)
    private String someString;

    @OneToMany(mappedBy = "edgeTable", fetch = FetchType.LAZY)
    private List<MiddleTable> middleTables;

    public EdgeTable() {
        // for JPA
    }

    public EdgeTable(final String someString) {
        this.someString = someString;
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

    public List<MiddleTable> getMiddleTables() {
        return middleTables;
    }

    public void setMiddleTables(final List<MiddleTable> middleTables) {
        this.middleTables = middleTables;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final EdgeTable edgeTable = (EdgeTable) o;
        return Objects.equals(id, edgeTable.id) && Objects.equals(someString, edgeTable.someString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, someString);
    }

    @Override
    public String toString() {
        return "EdgeTable{" +
                "id=" + id +
                ", someString='" + someString + '\'' +
                '}';
    }
}
