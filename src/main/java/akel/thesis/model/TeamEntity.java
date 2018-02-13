package akel.thesis.model;

import javax.persistence.*;

@Entity
@Table(name = "team", schema = "thesis", catalog = "")
public class TeamEntity{
    private Integer id;
    private String name;
    private String description;

    @Id
    @Column(name = "id")
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        TeamEntity that = (TeamEntity) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
