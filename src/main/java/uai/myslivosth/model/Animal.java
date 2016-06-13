package uai.myslivosth.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "animal")
public class Animal implements Serializable{
    
   private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "species_id")
    private Specie specie;
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "region_id")
    private Region region;
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "status_id")
    private Status status;
    
    @Size(min = 3, max = 255)
    @Column(name = "identifier")
    @NotNull
    private String identifier;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "history")
    private String history;
    
    @Transient
    private String regionCode;
    
    @Transient
    private String specieCode;
    
    @Transient
    private String statusCode;

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
     * @return the speciesID
     */
    public Specie getSpecie() {
        return specie;
    }

    /**
     * @param specie the speciesID to set
     */
    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    /**
     * @return the region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * @param region the regionID to set
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * @return the statusID
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the statusID to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return the history
     */
    public String getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(String history) {
        this.history = history;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.specie);
        hash = 59 * hash + Objects.hashCode(this.region);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.identifier);
        hash = 59 * hash + Objects.hashCode(this.history);
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.specie, other.specie)) {
            return false;
        }
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        if (!Objects.equals(this.history, other.history)) {
            return false;
        }
        return true;
    }

    /**
     * @return the regionCode
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * @param regionCode the regionCode to set
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    /**
     * @return the specieCode
     */
    public String getSpecieCode() {
        return specieCode;
    }

    /**
     * @param specieCode the specieCode to set
     */
    public void setSpecieCode(String specieCode) {
        this.specieCode = specieCode;
    }

    /**
     * @return the statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    
}