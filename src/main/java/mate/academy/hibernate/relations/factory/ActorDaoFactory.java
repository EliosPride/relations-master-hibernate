package mate.academy.hibernate.relations.factory;

import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.dao.impl.AbstractDao;
import mate.academy.hibernate.relations.dao.impl.ActorDaoImpl;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class ActorDaoFactory extends AbstractDao {
    private static ActorDao actorDao;

    protected ActorDaoFactory(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public static ActorDao getInstance() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if (actorDao == null) {
            actorDao = new ActorDaoImpl(sessionFactory);
        }
        return actorDao;
    }
}
