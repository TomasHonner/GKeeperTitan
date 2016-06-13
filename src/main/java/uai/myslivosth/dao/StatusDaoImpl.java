package uai.myslivosth.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import uai.myslivosth.model.Status;

/**
 *
 * @author Tomáš Honner
 */

@Repository("statusDao")
public class StatusDaoImpl extends AbstractDao implements StatusDao{

    @Override
    public List<Status> findAllStatuses() {
        Criteria criteria = getSession().createCriteria(Status.class);
        return (List<Status>) criteria.list();
    }

    @Override
    public void saveStatus(Status status) {
        persist(status);
    }

    @Override
    public void deleteStatusById(String id) {
        Query query = getSession().createSQLQuery("delete from status where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    @Override
    public Status getDefaultStatus() {
        Criteria criteria = getSession().createCriteria(Status.class);
        criteria.add(Restrictions.like("id", 1));
        return (Status) criteria.uniqueResult();
    }

    @Override
    public Status getStatusById(String id) {
        Integer i = Integer.parseInt(id);
        Criteria criteria = getSession().createCriteria(Status.class);
        criteria.add(Restrictions.like("id", i));
        return (Status) criteria.uniqueResult();
    }
    
}
