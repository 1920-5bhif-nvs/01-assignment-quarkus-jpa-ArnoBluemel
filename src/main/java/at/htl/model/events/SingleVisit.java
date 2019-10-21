package at.htl.model.events;

import at.htl.model.people.Visitor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SINGLE_VISITS")
public class SingleVisit extends Visit
{
    private static final Double PRICE_UNDERAGED = 5D;
    private static final Double PRICE_ADULT = 12D;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    //@Column(name = "VISITOR")
    @ManyToOne
    private Visitor visitor;
    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public SingleVisit() { }

    public Visitor getVisitor()
    {
        return visitor;
    }

    public void setVisitor(Visitor visitor)
    {
        this.visitor = visitor;
    }

    public SingleVisit(Visitor visitor, LocalDateTime timestamp)
    {
        super(PRICE_ADULT, PRICE_UNDERAGED);
        this.visitor = visitor;
    }
}
