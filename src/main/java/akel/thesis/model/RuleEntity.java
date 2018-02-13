package akel.thesis.model;

import javax.persistence.*;

@Entity
@Table(name = "rule", schema = "thesis", catalog = "")
public class RuleEntity{
    private Integer id;
    private String expression;
    private String commentarysegment;

    @Id
    @Column(name = "id")
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Basic
    @Column(name = "expression")
    public String getExpression(){
        return expression;
    }

    public void setExpression(String expression){
        this.expression = expression;
    }

    @Basic
    @Column(name = "commentarysegment")
    public String getCommentarysegment(){
        return commentarysegment;
    }

    public void setCommentarysegment(String commentarysegment){
        this.commentarysegment = commentarysegment;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        RuleEntity that = (RuleEntity) o;

        if(id != null ? !id.equals(that.id) : that.id != null) return false;
        if(expression != null ? !expression.equals(that.expression) : that.expression != null) return false;
        if(commentarysegment != null ? !commentarysegment.equals(that.commentarysegment) : that.commentarysegment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        result = 31 * result + (commentarysegment != null ? commentarysegment.hashCode() : 0);
        return result;
    }
}
