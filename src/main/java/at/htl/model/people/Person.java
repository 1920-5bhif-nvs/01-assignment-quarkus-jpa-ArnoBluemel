package at.htl.model.people;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person
{
    protected static Integer DEFAULT_CLEARANCE_VISITOR = 0;
    protected static Integer DEFAULT_CLEARANCE_PERSONNEL = 1;
    protected static Integer DEFAULT_CLEARANCE_SCIENTIST = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "PERSON_AGE", nullable = false)
    private Long age;
    @Column(name = "CLEARANCE", nullable = false)
    private Integer clearance;

    protected Person() { }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getAge()
    {
        return age;
    }

    public void setAge(Long age)
    {
        this.age = age;
    }

    public Integer getClearance()
    {
        return clearance;
    }

    public void setClearance(Integer clearance)
    {
        this.clearance = clearance;
    }

    protected Person(String name, Long age, Integer clearance)
    {
        this.name = name;
        this.clearance = clearance;
        this.age = age;
    }
}
