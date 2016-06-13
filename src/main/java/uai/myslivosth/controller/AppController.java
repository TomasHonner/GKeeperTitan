package uai.myslivosth.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uai.myslivosth.model.Animal;
import uai.myslivosth.model.Region;
import uai.myslivosth.model.Role;
import uai.myslivosth.model.Specie;
import uai.myslivosth.model.Status;
import uai.myslivosth.model.User;
import uai.myslivosth.service.AnimalService;
import uai.myslivosth.service.RegionService;
import uai.myslivosth.service.RoleService;
import uai.myslivosth.service.SpecieService;
import uai.myslivosth.service.StatusService;
import uai.myslivosth.service.UserService;

/**
 *
 * @author Tomáš Honner
 */

@Controller
@RequestMapping("/")
public class AppController {
    
    @Autowired
    AnimalService animalService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    RegionService regionService;
    
    @Autowired
    RoleService roleService;
    
    @Autowired
    SpecieService specieService;
    
    @Autowired
    StatusService statusService;
    
    
    @ModelAttribute("userSession")
    public String getUsername() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if(name == null)
        {
            return "neprihlasen";
        }
        else
        {
            return name;
        }
    }
    
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }
    
    @RequestMapping(value = {"login"}, method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }
    
    
    @RequestMapping(value = {"/animals"}, method = RequestMethod.GET)
    public String listAnimals (ModelMap model)
    {
        List<Animal> animals = animalService.findAllAnimals();
        model.addAttribute("animals", animals);
        return "animals";
    }
    
    @RequestMapping(value = { "/animalnew" }, method = RequestMethod.GET)
    public String newAnimal(ModelMap model) {
        List<Region> regions = regionService.findAllRegions();
        model.addAttribute("regions", regions);
        
        List<Specie> species = specieService.findAllSpecies();
        model.addAttribute("species", species);
        
        List<Status> statuses = statusService.findAllStatuses();
        model.addAttribute("statuses", statuses);
        
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        return "animalnew";
    }
    
    @RequestMapping(value = { "/animalnew" }, method = RequestMethod.POST)
    public String saveAnimal(@ModelAttribute("animal") Animal animal, BindingResult result, ModelMap model) {
 
        if (result.hasErrors()) {
            return "animalnew";
        }
        
        Specie currentSpecie = specieService.getSpecieById(animal.getSpecieCode());
        animal.setSpecie(currentSpecie);
        Region currentRegion = regionService.getRegionById(animal.getRegionCode());
        animal.setRegion(currentRegion);
        Status currentStatus = statusService.getStatusById(animal.getStatusCode());
        animal.setStatus(currentStatus);
 
        animalService.saveAnimal(animal);
 
        model.addAttribute("success", "Animal " + animal.getIdentifier()
                + " registered successfully");
        return "redirect:/animals";
    }    
    
    
     @RequestMapping(value = {"/animaledit/{id}"}, method = RequestMethod.GET)
    public String editAnimal(@PathVariable String id, ModelMap model)
    {
        Animal a = animalService.findAnimalByID(id);
        
        List<Specie> species = specieService.findAllSpecies();
        model.addAttribute("species", species);
        
        List<Region> regions = regionService.findAllRegions();
        model.addAttribute("regions", regions);
        
        List<Status> statuses = statusService.findAllStatuses();
        model.addAttribute("statuses", statuses);
        
        model.addAttribute("animal", a);
        
        return "animaledit";
        
    }
 
    @RequestMapping(value = {"/animaledit/{id}"}, method = RequestMethod.POST)
    public String updateAnimal(@ModelAttribute("animal") Animal animal, BindingResult result, ModelMap map, @PathVariable String id)
    {
        Animal a = animalService.findAnimalByID(id);
        
        Specie currentSpecie = specieService.getSpecieById(animal.getSpecieCode());
        animal.setSpecie(currentSpecie);
        Region currentRegion = regionService.getRegionById(animal.getRegionCode());
        animal.setRegion(currentRegion);
        Status currentStatus = statusService.getStatusById(animal.getStatusCode());
        animal.setStatus(currentStatus);
        
        a.setSpecie(animal.getSpecie());
        a.setRegion(animal.getRegion());
        a.setStatus(animal.getStatus());
        a.setIdentifier(animal.getIdentifier());
        a.setHistory(animal.getHistory());
        
        animalService.updateAnimal(a);
        
        return "redirect:/animals";
    }
    
    @RequestMapping(value = { "/animaldelete/{id}" }, method = RequestMethod.GET)
    public String deleteAnimal(@PathVariable String id) {
        animalService.deleteAnimalById(id);
        return "redirect:/animals";
    }
    
    
    
    
    //////////////////// USER SECTION    /////////////////////////
    
    
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model)
    {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    
    @RequestMapping(value = {"/usernew"}, method = RequestMethod.GET)
    public String newUser(ModelMap model)
    {
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        
        User user = new User();
        user.setRole(roleService.getDefaultRole());
        model.addAttribute("user", user);
        
        return "usernew";
    }
    
    @RequestMapping(value = {"/usernew"}, method = RequestMethod.POST)
    public String saveUser( @ModelAttribute("user") User user, BindingResult result, ModelMap model)
    {
        
        if (result.hasErrors()) {
            return "usernew";
        }
        
        Role currentRole = roleService.getRoleByID(user.getRoleCode());
        user.setRole(currentRole);
        
        userService.saveUser(user);
        
        model.addAttribute("success", "User " + user.getFirstname()
                + " registered successfully");        
        return "redirect:/users";
    }
    
    @RequestMapping(value = {"/useredit/{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String id, ModelMap model)
    {
        User u = userService.findUserByID(id);
        
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        
        model.addAttribute("user", u);
        
        return "useredit";
    }
    
    @RequestMapping(value = {"/useredit/{id}"}, method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model, @PathVariable String id)
    {
        User u = userService.findUserByID(id);
        Role currentRole = roleService.getRoleByID(user.getRoleCode());
        user.setRole(currentRole);
        
        u.setFirstname(user.getFirstname());
        u.setSurname(user.getSurname());
        u.setLogin(user.getLogin());
        u.setEnabled(user.isEnabled());
        u.setRole(user.getRole());
        
        userService.updateUser(u);
        
        return "redirect:/users";
    }
    
    @RequestMapping(value = { "/userdelete/{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
