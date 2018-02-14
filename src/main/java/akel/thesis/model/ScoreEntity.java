package akel.thesis.model;

import javax.persistence.*;

@Entity
@Table(name = "score", schema = "thesis")
public class ScoreEntity{
    private Integer id;
    private Integer getscore;
    private String teamname;

    @Id
    @Column(name = "id")
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Basic
    @Column(name = "getscore")
    public Integer getGetscore(){
        return getscore;
    }

    public void setGetscore(Integer getscore){
        this.getscore=getscore;
    }

    @Basic
    @Column(name = "teamname")
    public String getTeamname(){
        return teamname;
    }

    public void setTeamname(String teamname){
        this.teamname = teamname;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ScoreEntity that = (ScoreEntity) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(getscore != null ? !getscore.equals(that.getscore) : that.getscore != null) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (getscore != null ? getscore.hashCode() : 0);
        return result;
    }

}
