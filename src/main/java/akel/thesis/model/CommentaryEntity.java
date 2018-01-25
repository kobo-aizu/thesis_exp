package akel.thesis.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Basic;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;

@Entity
@Table(name = "commentary", schema = "thesis")
public class CommentaryEntity{
    private Integer id;
    private String who;
    private Timestamp occurrenceTime;
    private FactEntity factByFactId;

    @Id
    @Column(name = "id")
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Basic
    @Column(name = "who")
    public String getWho(){
        return who;
    }

    public void setWho(String who){
        this.who = who;
    }

    @Basic
    @Column(name = "occurrence_time")
    public Timestamp getOccurrenceTime(){
        return occurrenceTime;
    }

    public void setOccurrenceTime(Timestamp occurrenceTime){
        this.occurrenceTime = occurrenceTime;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        CommentaryEntity that = (CommentaryEntity) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(who != null ? !who.equals(that.who) : that.who != null) return false;
        if(occurrenceTime != null ? !occurrenceTime.equals(that.occurrenceTime) : that.occurrenceTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (who != null ? who.hashCode() : 0);
        result = 31 * result + (occurrenceTime != null ? occurrenceTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fact_id", referencedColumnName = "id", nullable = false)
    public FactEntity getFactByFactId(){
        return factByFactId;
    }

    public void setFactByFactId(FactEntity factByFactId){
        this.factByFactId = factByFactId;
    }
}
