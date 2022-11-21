package com.github.cornerstonews.persistence.jpa.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Example.class)
public class Example_ {
    public static volatile SingularAttribute<Example, Integer> id;
    public static volatile SingularAttribute<Example, String> someString;
    public static volatile SingularAttribute<Example, Integer> someNumber;
    public static volatile ListAttribute<Example, MiddleTable> middleTables;
}
