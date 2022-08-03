package mate.academy.hibernate.relations.factory;

import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.dao.impl.AbstractDao;
import mate.academy.hibernate.relations.dao.impl.MovieDaoImpl;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class MovieDaoFactory extends AbstractDao {
    private static MovieDao movieDao;

    protected MovieDaoFactory(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static MovieDao getInstance() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (movieDao == null) {
            movieDao = new MovieDaoImpl(sessionFactory);
        }
        return movieDao;
    }
}
