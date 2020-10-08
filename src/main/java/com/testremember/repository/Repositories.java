package com.testremember.repository;

import com.testremember.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class Repositories{



    private final SessionFactory sessionFactory;

    public Repositories(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }





    /* Создаём пользователя */
    public final void createUser(final User user){

        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        entityManager.close();

    }








    public final User getUserByUsername(final String username){


        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteria = builder.createQuery( Object[].class );
        Root<User> root = criteria.from( User.class );

        Path<String> authUserId = root.get( "username" );
        Path<String> authPasswordId = root.get( "password" );

        criteria.multiselect( authUserId, authPasswordId );

        criteria.where( builder.equal( root.get( "username" ), username ) );

        List<Object[]> authLoginId = entityManager.createQuery( criteria ).getResultList();

        entityManager.close();

        Object[] objects = authLoginId.get(0);

        User user = new User();

        user.setUsername(objects[0].toString());
        user.setPassword(objects[1].toString());

        return user;
    }


}
