package com.github.cornerstonews.persistence.jpa.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EdgeTable.class)
public class EdgeTable_ {
    public static volatile SingularAttribute<EdgeTable, Integer> id;
    public static volatile SingularAttribute<EdgeTable, String> someString;
    public static volatile ListAttribute<EdgeTable, MiddleTable> middleTables;
}
