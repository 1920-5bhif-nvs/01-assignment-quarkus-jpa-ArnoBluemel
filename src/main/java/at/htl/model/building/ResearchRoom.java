package at.htl.model.building;

import at.htl.model.people.Scientist;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="RESEARCH_ROOMS")
public class ResearchRoom extends Room
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @ManyToMany
    @JsonbTransient
    private List<Scientist> scientists;

    public ResearchRoom(String roomName, List<Scientist> scientists)
    {
        super(roomName, Room.DEFAULT_CLEARANCE_RESEARCH_ROOM);
        this.scientists = scientists;
    }

    public ResearchRoom() { }

    public List<Scientist> getScientists()
    {
        return scientists;
    }

    protected void setScientists(List<Scientist> scientists)
    {
        this.scientists = scientists;
    }
}
