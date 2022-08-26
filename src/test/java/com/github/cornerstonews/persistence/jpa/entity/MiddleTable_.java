package com.github.cornerstonews.persistence.jpa.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MiddleTable.class)
public class MiddleTable_ {
    public static volatile SingularAttribute<MiddleTable, Integer> id;
    public static volatile SingularAttribute<MiddleTable, String> someString;
    public static volatile SingularAttribute<MiddleTable, Example> example;
    public static volatile SingularAttribute<MiddleTable, EdgeTable> edgeTable;
}
