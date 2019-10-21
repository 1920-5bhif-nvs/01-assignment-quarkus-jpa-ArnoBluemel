package at.htl.model.people;

import javax.persistence.*;

@Entity
@Table(name = "GUIDES")
public class Guide extends Staff
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    public Guide(String name, Long age, Double salary)
    {
        super(name, age, Person.DEFAULT_CLEARANCE_PERSONNEL, salary);
    }

    public Guide() { }
}
