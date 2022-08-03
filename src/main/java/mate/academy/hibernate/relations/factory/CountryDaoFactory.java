package mate.academy.hibernate.relations.factory;

import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.dao.impl.AbstractDao;
import mate.academy.hibernate.relations.dao.impl.CountryDaoImpl;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class CountryDaoFactory extends AbstractDao {
    private static CountryDao countryDao;

    protected CountryDaoFactory(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static CountryDao getInstance() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (countryDao == null) {
            countryDao = new CountryDaoImpl(sessionFactory);
        }
        return countryDao;
    }
}
