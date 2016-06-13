package uai.myslivosth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uai.myslivosth.dao.AnimalDao;
import uai.myslivosth.model.Animal;

/**
 *
 * @author Tomáš Honner
 */

@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    AnimalDao dao;
    
    @Override
    public void saveAnimal(Animal animal) {
        dao.saveAnimal(animal);
    }

    @Override
    public List<Animal> findAllAnimals() {
       return dao.findAllAnimals();
    }
    
    @Override
    public Animal findAnimalByID(String id)
    {
        return dao.findAnimalByID(id);
    }

    @Override
    public void deleteAnimalById(String id) {
        dao.deleteAnimalById(id);
    }
    
    @Override
    public void updateAnimal(Animal animal)
    {
        dao.updateAnimal(animal);
    }
    
}
