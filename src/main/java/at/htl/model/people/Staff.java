package at.htl.model.people;

import javax.persistence.*;

@Entity
@Table(name = "STAFF")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Staff extends Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "SALARY", nullable = false, precision = 2)
    private Double salary;

    protected Staff() { }

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    protected Staff(String name, Long age, Integer clearance, Double salary)
    {
        super(name, age, clearance);
        this.salary = salary;
    }
}
