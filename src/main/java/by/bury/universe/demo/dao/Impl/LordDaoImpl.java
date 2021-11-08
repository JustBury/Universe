package by.bury.universe.demo.dao.Impl;

import by.bury.universe.demo.dao.LordDao;
import by.bury.universe.demo.entity.Lord;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LordDaoImpl implements LordDao {

    private static final String ID_LORD = "id_lord";
    private static final String SELECT_LORDS = "select L from Lord L";
    private static final String DELETE_LORD = "delete from Lord where id=:id_lord";
    private static final String SELECT_YOUNG_LORDS = "select L from Lord L order by L.age";
    private static final String SELECT_LORD_SLACKERS = "select L from Lord as L left join L.planets as P where P.id is null";

    @Autowired
    private EntityManager entityManager;

    @Override
    public void saveLord(Lord lord) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(lord);
    }

    @Override
    public List<Lord> getLords() {
        Session session = entityManager.unwrap(Session.class);
        Query<Lord> theQuery = session.createQuery(SELECT_LORDS, Lord.class);
        List<Lord> lords = theQuery.getResultList();
        return lords;
    }

    @Override
    public Lord getLord(int id) {
        Session session = entityManager.unwrap(Session.class);
        Lord lord = session.get(Lord.class,id);
        return lord;
    }

    @Override
    public void deleteLord(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery(DELETE_LORD);
        theQuery.setParameter(ID_LORD, id);
        theQuery.executeUpdate();
    }

    @Override
    public List<Lord> getTenYoungLords() {
        int quantityLords = 10;
        Session session = entityManager.unwrap(Session.class);
        Query<Lord> theQuery = session.createQuery(SELECT_YOUNG_LORDS, Lord.class);
        theQuery.setMaxResults(quantityLords);
        List<Lord> lords = theQuery.getResultList();
        return lords;
    }

    @Override
    public List<Lord> getLordSlackers() {
        Session session2 = entityManager.unwrap(Session.class);
        Query<Lord> theQuery = session2.createQuery(SELECT_LORD_SLACKERS, Lord.class);
        List<Lord> lords = theQuery.getResultList();
        return lords;
    }
}
