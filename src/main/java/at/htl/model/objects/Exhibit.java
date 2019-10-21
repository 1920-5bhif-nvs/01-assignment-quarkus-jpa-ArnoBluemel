package at.htl.model.objects;

import at.htl.model.building.ExhibitionRoom;

import javax.persistence.*;

@Entity
@Table(name = "EXHIBITS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Exhibit
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "EXHIBIT_NAME", nullable = false)
    private String exhibitName;
    @Column(name = "ORIGIN", nullable = false)
    private String origin;
    //@Column(name = "ROOM", nullable = false)
    @ManyToOne
    private ExhibitionRoom room;

    protected Exhibit() { }

    public String getExhibitName()
    {
        return exhibitName;
    }

    public void setExhibitName(String exhibitName)
    {
        this.exhibitName = exhibitName;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public ExhibitionRoom getRoom()
    {
        return room;
    }

    public void setRoom(ExhibitionRoom room)
    {
        this.room = room;
    }

    protected Exhibit(String exhibitName, String origin, ExhibitionRoom room)
    {
        this.exhibitName = exhibitName;
        this.origin = origin;
        this.room = room;
    }
}
