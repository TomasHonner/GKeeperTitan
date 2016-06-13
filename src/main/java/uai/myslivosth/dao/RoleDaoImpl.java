package uai.myslivosth.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import uai.myslivosth.model.Role;

/**
 *
 * @author Tomáš Honner
 */

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao implements RoleDao{

    @Override
    public List<Role> findAllRoles() {
        Criteria criteria = getSession().createCriteria(Role.class);
        return (List<Role>) criteria.list();
    }

    @Override
    public void saveRole(Role role) {
        persist(role);
    }

    @Override
    public void deleteRoleById(String id) {
        Query query = getSession().createSQLQuery("delete from role where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    @Override
    public Role getDefaultRole() {
        Criteria criteria = getSession().createCriteria(Role.class);
        criteria.add(Restrictions.like("id", 3));
        return (Role) criteria.uniqueResult();
    }

    @Override
    public Role getRoleByID(String id) {
        Integer i = Integer.parseInt(id);
        Criteria criteria = getSession().createCriteria(Role.class);
        criteria.add(Restrictions.like("id", i));
        return (Role) criteria.uniqueResult();
    }
    
    
}
