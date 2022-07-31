package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.factory.ActorDaoFactory;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.service.ActorService;

public class ActorServiceImpl implements ActorService {
    private final ActorDao actorDao = ActorDaoFactory.getInstance();

    @Override
    public Actor add(Actor actor) {
        return actorDao.add(actor);
    }

    @Override
    public Actor get(Long id) {
        return actorDao.get(id).orElseThrow();
    }
}
