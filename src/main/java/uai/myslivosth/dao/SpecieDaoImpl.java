package uai.myslivosth.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import uai.myslivosth.model.Specie;

/**
 *
 * @author Tomáš Honner
 */

@Repository("specieDao")
public class SpecieDaoImpl extends AbstractDao implements SpecieDao{

    @Override
    public List<Specie> findAllSpecies() {
        Criteria criteria = getSession().createCriteria(Specie.class);
        return (List<Specie>) criteria.list();
    }

    @Override
    public void saveSpecie(Specie specie) {
        persist(specie);
    }

    @Override
    public void deleteSpecieById(String id) {
        Query query = getSession().createSQLQuery("delete from species where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    @Override
    public Specie getDefaultSpecie() {
        Criteria criteria = getSession().createCriteria(Specie.class);
        criteria.add(Restrictions.like("id", 1));
        return (Specie) criteria.uniqueResult();
    }

    @Override
    public Specie getSpecieById(String id) {
        Integer i = Integer.parseInt(id);
        Criteria criteria = getSession().createCriteria(Specie.class);
        criteria.add(Restrictions.like("id", i));
        return (Specie) criteria.uniqueResult();
    }
    
}
