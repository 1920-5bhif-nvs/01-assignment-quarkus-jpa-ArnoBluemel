package at.htl.model.events;

import javax.persistence.*;

@Entity
@Table(name = "VISITS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Visit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "PRICE_ADULT", nullable = false, precision = 2)
    private Double priceAdult;
    @Column(name = "PRICE_UNDERAGED", nullable = false, precision = 2)
    private Double priceUnderaged;

    protected Visit() { }

    public Double getPriceAdult()
    {
        return priceAdult;
    }

    public void setPriceAdult(Double priceAdult)
    {
        this.priceAdult = priceAdult;
    }

    public Double getPriceUnderaged()
    {
        return priceUnderaged;
    }

    public void setPriceUnderaged(Double priceUnderaged)
    {
        this.priceUnderaged = priceUnderaged;
    }

    protected Visit(Double priceAdult, Double priceUnderaged)
    {
        this.priceAdult = priceAdult;
        this.priceUnderaged = priceUnderaged;
    }
}
