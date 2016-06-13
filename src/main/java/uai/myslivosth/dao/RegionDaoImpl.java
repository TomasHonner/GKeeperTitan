package uai.myslivosth.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import uai.myslivosth.model.Region;

/**
 *
 * @author Tomáš Honner
 */

@Repository("regionDao")
public class RegionDaoImpl extends AbstractDao implements RegionDao{

    @Override
    public List<Region> findAllRegions() {
        Criteria criteria = getSession().createCriteria(Region.class);
        return (List<Region>) criteria.list();
    }

    @Override
    public void saveRegion(Region region) {
        persist(region);
    }

    @Override
    public void deleteRegionById(String id) {
        Query query = getSession().createSQLQuery("delete from region where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    @Override
    public Region getDefaultRegion() {
        Criteria criteria = getSession().createCriteria(Region.class);
        criteria.add(Restrictions.like("id", 1));
        return (Region) criteria.uniqueResult();
    }

    @Override
    public Region getRegionById(String id) {
        Integer i = Integer.parseInt(id);
        Criteria criteria = getSession().createCriteria(Region.class);
        criteria.add(Restrictions.like("id", i));
        return (Region) criteria.uniqueResult();
    }
    
}
