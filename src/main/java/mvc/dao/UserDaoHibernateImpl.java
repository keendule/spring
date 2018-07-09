package mvc.dao;

import mvc.model.User;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getUsers() {

        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery(
                "from User order by name",
                User.class);

        return query.getResultList();

    }

    @Override
    public void addUser(User User) {

        Session session = sessionFactory.getCurrentSession();

        session.save(User);

    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = getUser(id);
        session.delete(user);
    }
}

