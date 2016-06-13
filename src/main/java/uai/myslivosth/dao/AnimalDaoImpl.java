package uai.myslivosth.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import uai.myslivosth.model.Animal;

/**
 *
 * @author Tomáš Honner
 */

@Repository("animalDao")
public class AnimalDaoImpl extends AbstractDao implements AnimalDao{
    
    @Override
    public void saveAnimal(Animal animal) {
        persist(animal);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Animal> findAllAnimals() {
        Criteria criteria = getSession().createCriteria(Animal.class);
        return (List<Animal>) criteria.list();
    }
    
    @Override
    public void updateAnimal(Animal animal)
    {
        getSession().update(animal);
    }

    @Override
    public Animal findAnimalByID(String id) {
        Criteria criteria = getSession().createCriteria(Animal.class);
        Integer i = new Integer(id);
        criteria.add(Restrictions.like("id", i));
        return (Animal) criteria.uniqueResult();
    }

    @Override
    public void deleteAnimalById(String id) {
        Query query = getSession().createSQLQuery("delete from animal where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }
    
    
}
