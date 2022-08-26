package com.github.cornerstonews.persistence.jpa.controller;

import com.github.cornerstonews.persistence.jpa.entity.EdgeTable;
import com.github.cornerstonews.persistence.jpa.entity.Example;
import com.github.cornerstonews.persistence.jpa.entity.MiddleTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomPredicateProviderTest {
    private EntityManagerFactory emf;
    private ExampleJpaController controller;

    private List<Example> examples;
    private List<EdgeTable> edgeTables;
    private List<MiddleTable> middleTables;

    @BeforeEach
    void beforeEach() {
        examples = new ArrayList<>();
        edgeTables = new ArrayList<>();
        middleTables = new ArrayList<>();

        emf = Persistence.createEntityManagerFactory("test-persistence-unit");
        controller = new ExampleJpaController(emf);

        final var em = emf.createEntityManager();
        final var transaction = em.getTransaction();

        transaction.begin();
        try {
            for (var i = 0; i < 5; i++) {
                final var example = new Example("example-" + i, i);
                em.persist(example);
                examples.add(example);

                final var edge = new EdgeTable("edge-" + i);
                em.persist(edge);
                edgeTables.add(edge);

                for (var k = 0; k < 5; k++) {
                    final var middle = new MiddleTable("middle-" + i, example, edge);
                    em.persist(middle);
                    middleTables.add(middle);
                }
            }
            transaction.commit();
        } finally {
            em.close();
        }

    }

    @AfterEach
    void afterEach() {
        final var em = emf.createEntityManager();
        final var cb = em.getCriteriaBuilder();
        final var transaction = em.getTransaction();

        transaction.begin();
        try {
            em.createQuery(cb.createCriteriaDelete(MiddleTable.class)).executeUpdate();
            em.createQuery(cb.createCriteriaDelete(EdgeTable.class)).executeUpdate();
            em.createQuery(cb.createCriteriaDelete(Example.class)).executeUpdate();
            transaction.commit();
        } finally {
            em.close();
        }

        emf.close();
    }

    @Test
    void testFindByEdgeTable() {
        assertEquals(examples.subList(0, 1), controller.findBy(new Example(null, null), edgeTables.get(0)));
    }

    @Test
    void testFindByCountEdgeTable() {
        assertEquals(1, controller.findByCount(new Example(null, null), edgeTables.get(0)));
    }

    @Test
    void testFindByCountEdgeTableNonDistinct() {
        assertEquals(5, controller.findByCount(new Example(null, null), edgeTables.get(0), false));
    }

}
