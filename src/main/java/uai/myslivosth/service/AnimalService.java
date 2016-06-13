package uai.myslivosth.service;

import java.util.List;
import uai.myslivosth.model.Animal;

/**
 *
 * @author Tomáš Honner
 */
public interface AnimalService {
    void saveAnimal(Animal animal);
     
    List<Animal> findAllAnimals();
    
    Animal findAnimalByID(String id);
     
    void deleteAnimalById(String id); 
    
    void updateAnimal(Animal animal);
}
