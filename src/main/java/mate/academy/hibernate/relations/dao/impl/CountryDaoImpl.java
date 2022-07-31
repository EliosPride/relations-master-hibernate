package mate.academy.hibernate.relations.dao.impl;

import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.exception.DataProcessingException;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class CountryDaoImpl extends AbstractDao implements CountryDao {
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Country add(Country country) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(country);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save country to db", e);
        }
        return country;
    }

    @Override
    public Optional<Country> get(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        Country country;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            country = session.get(Country.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't get country from db", e);
        }
        return Optional.of(country);
    }
}
