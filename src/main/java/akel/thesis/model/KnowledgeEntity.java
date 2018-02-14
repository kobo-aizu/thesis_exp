package akel.thesis.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "knowledge", schema = "thesis")
public class KnowledgeEntity{
    private Integer id;
    private String who;
    private String how;
    private String what;
    private Timestamp when_t;
    private String why;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "how")
    public String getHow(){
        return how;
    }

    public void setHow(String how){
        this.how = how;
    }

    @Basic
    @Column(name = "what")
    public String getWhat(){
        return what;
    }

    public void setWhat(String what){
        this.what = what;
    }

    @Basic
    @Column(name = "when_t")
    public Timestamp getWhen_t(){
        return when_t;
    }

    public void setWhen_t(Timestamp when){
        this.when_t = when;
    }

    @Basic
    @Column(name = "why")
    public String getWhy(){
        return why;
    }

    public void setWhy(String why){
        this.why = why;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        KnowledgeEntity that = (KnowledgeEntity) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(who != null ? !who.equals(that.who) : that.who != null) return false;
        if(how != null ? !how.equals(that.how) : that.how != null) return false;
        if(what != null ? !what.equals(that.what) : that.what != null) return false;
        if(when_t != null ? !when_t.equals(that.when_t) : that.when_t != null) return false;
        if(why != null ? !why.equals(that.why) : that.why != null) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (who != null ? who.hashCode() : 0);
        result = 31 * result + (how != null ? how.hashCode() : 0);
        result = 31 * result + (what != null ? what.hashCode() : 0);
        result = 31 * result + (when_t != null ? when_t.hashCode() : 0);
        result = 31 * result + (why != null ? why.hashCode() : 0);
        return result;
    }

    public String knowledgeSource(){
        if(!who.equals("")&&how.equals("")&&!what.equals("")&&why.equals("")) return "team";
        if(!who.equals("")&&how.equals("")&&!what.equals("")&&!why.equals("")) return "rank";
        if(!who.equals("")&&!how.equals("")&&!what.equals("")&&why.equals("")) return "submit";
        return "error";
    }

}
