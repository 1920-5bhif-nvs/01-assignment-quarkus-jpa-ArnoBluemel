package at.htl.model.events;

import at.htl.model.people.Guide;
import at.htl.model.people.Visitor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TOURS")
public class Tour extends Visit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "TITLE", nullable = false)//default value?
    private String title;
    @Column(name = "START", nullable = false)
    private LocalDateTime start;
    @Column(name = "DURATION", nullable = false)
    private Long duration;
    //@Column(name = "TOUR_GUIDE", nullable = false)
    @ManyToOne
    private Guide tourGuide;
    @OneToMany
    private List<Visitor> visitors;

    public Tour() { }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDateTime getStart()
    {
        return start;
    }

    public void setStart(LocalDateTime start)
    {
        this.start = start;
    }

    public Long getDuration()
    {
        return duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public Guide getTourGuide()
    {
        return tourGuide;
    }

    public void setTourGuide(Guide tourGuide)
    {
        this.tourGuide = tourGuide;
    }

    public List<Visitor> getVisitors()
    {
        return visitors;
    }

    protected void setVisitors(List<Visitor> visitors)
    {
        this.visitors = visitors;
    }

    public Tour(Double priceAdult, Double priceUnderaged, String title, LocalDateTime start, Long duration, Guide tourGuide, List<Visitor> visitors)
    {
        super(priceAdult, priceUnderaged);
        this.title = title;
        this.start = start;
        this.duration = duration;
        this.tourGuide = tourGuide;
        this.visitors = visitors;
    }
}
