package akel.thesis.model;

import javax.persistence.*;

@Entity
@Table(name = "problem", schema = "thesis", catalog = "")
public class ProblemEntity{
    private Integer id;
    private String name;
    private String description;
    private Integer score;

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

    @Basic
    @Column(name = "score")
    public Integer getScore(){
        return score;
    }

    public void setScore(Integer score){
        this.score = score;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ProblemEntity that = (ProblemEntity) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(name != null ? !name.equals(that.name) : that.name != null) return false;
        if(description != null ? !description.equals(that.description) : that.description != null) return false;
        if(score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
