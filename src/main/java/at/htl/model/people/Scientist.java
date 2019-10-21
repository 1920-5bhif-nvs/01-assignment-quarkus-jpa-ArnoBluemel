package at.htl.model.people;

import javax.persistence.*;

@Entity
@Table(name = "SCIENTISTS")
public class Scientist extends Staff
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "FIELD_OF_RESEARCH", nullable = false)
    private String fieldOfResearch;
    @Column(name = "TITLE_PREFIX")
    private String titlePrefix;
    @Column(name = "TITLE_POSTFIX")
    private String titlePostfix;

    public Scientist() { }

    public String getFieldOfResearch()
    {
        return fieldOfResearch;
    }

    public void setFieldOfResearch(String fieldOfResearch)
    {
        this.fieldOfResearch = fieldOfResearch;
    }

    public String getTitlePrefix()
    {
        return titlePrefix;
    }

    public void setTitlePrefix(String titlePrefix)
    {
        this.titlePrefix = titlePrefix;
    }

    public String getTitlePostfix()
    {
        return titlePostfix;
    }

    public void setTitlePostfix(String titlePostfix)
    {
        this.titlePostfix = titlePostfix;
    }

    public Scientist(String name, Long age, Double salary, String fieldOfResearch, String titlePrefix, String titlePostfix) {
        super(name, age, Person.DEFAULT_CLEARANCE_SCIENTIST, salary);
        this.fieldOfResearch = fieldOfResearch;
        this.titlePrefix = titlePrefix;
        this.titlePostfix = titlePostfix;
    }
}
