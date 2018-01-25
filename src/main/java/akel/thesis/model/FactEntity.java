package akel.thesis.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Basic;


@Entity
@Table(name = "fact", schema = "thesis")
public class FactEntity{
    private Integer id;
    private String action;
    private String result;
    private Integer effortPoint;

    @Id
    @Column(name = "id")
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Basic
    @Column(name = "action")
    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action = action;
    }

    @Basic
    @Column(name = "result")
    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    @Basic
    @Column(name = "effort_point")
    public Integer getEffortPoint(){
        return effortPoint;
    }

    public void setEffortPoint(Integer effortPoint){
        this.effortPoint = effortPoint;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        FactEntity that = (FactEntity) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(action != null ? !action.equals(that.action) : that.action != null) return false;
        if(result != null ? !result.equals(that.result) : that.result != null) return false;
        if(effortPoint != null ? !effortPoint.equals(that.effortPoint) : that.effortPoint != null) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (action != null ? action.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (effortPoint != null ? effortPoint.hashCode() : 0);
        return result1;
    }
}
