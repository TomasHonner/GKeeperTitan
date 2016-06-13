package uai.myslivosth.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import uai.myslivosth.model.User;

/**
 *
 * @author Tomáš Honner
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{

    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @Override
    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    @Override
    public User findUserByID(String id) {
        Criteria criteria = getSession().createCriteria(User.class);
        Integer i = new Integer(id);
        criteria.add(Restrictions.like("id", i));
        return (User) criteria.uniqueResult();
    }

    @Override
    public void deleteUserById(String id) {
        Query query = getSession().createSQLQuery("delete from user where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Override
    public User finUserByUsername(String name) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.like("login", name));
        return (User) criteria.uniqueResult();
    }
    
}
