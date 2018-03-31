package com.library.dao;

import com.library.models.Book;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibraryDao {
    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList bookProjection;

    public LibraryDao() {
     bookProjection= Projections.projectionList();
     bookProjection.add(Projections.property("id"),"id");
     bookProjection.add(Projections.property("name"),"name");
     bookProjection.add(Projections.property("image"),"image");
     bookProjection.add(Projections.property("genre"),"genre");
     bookProjection.add(Projections.property("pageCount"),"pageCount");
     bookProjection.add(Projections.property("isbn"),"isbn");
     bookProjection.add(Projections.property("publisher"),"publisher");
     bookProjection.add(Projections.property("author"),"author");
     bookProjection.add(Projections.property("publishYear"),"publishYear");
     bookProjection.add(Projections.property("descr"),"descr");
     bookProjection.add(Projections.property("rating"),"rating");
     bookProjection.add(Projections.property("voteCount"),"voteCount");
    }

    public List getBooks() {
        DetachedCriteria bookCriteria = DetachedCriteria.forClass(Book.class, "b");
        createAliases(bookCriteria);

        return createBookList(bookCriteria);
    }

    private List createBookList(DetachedCriteria detachedCriteria) {
        Criteria criteria = detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name")).setProjection(bookProjection)
                .setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }

    private void createAliases(DetachedCriteria bookCriteria) {
        bookCriteria.createAlias("b.author","author");
        bookCriteria.createAlias("b.genre","genre");
        bookCriteria.createAlias("b.publisher","publisher");
    }
}
