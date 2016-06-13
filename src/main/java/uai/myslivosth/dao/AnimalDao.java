package uai.myslivosth.dao;

import java.util.List;
import uai.myslivosth.model.Animal;

/**
 *
 * @author Tomáš Honner
 */
public interface AnimalDao {
    
    void saveAnimal(Animal animal);
     
    List<Animal> findAllAnimals();
    
    Animal findAnimalByID(String id);
     
    void deleteAnimalById(String id);
    
    void updateAnimal(Animal animal);
}
