package uai.myslivosth.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tomáš Honner
 */

@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    
    @NotNull
    @Column(name = "firstname")
    @Size(min = 3, max = 255)
    private String firstname;
    
    @NotNull
    @Column(name = "surname")
    @Size(min = 3, max = 255)
    private String surname;
    
    @NotNull
    @Column(name = "login")
    @Size(min = 3, max = 255)
    private String login;
    
    @NotNull
    @Column(name = "password")
    @Size(min = 8, max = 255)
    private String password;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;
    
    @Transient
    private String roleCode;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.firstname);
        hash = 53 * hash + Objects.hashCode(this.surname);
        hash = 53 * hash + Objects.hashCode(this.login);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + (this.enabled ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

    /**
     * @return the roleCode
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode the roleCode to set
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    
    
    
    
}
