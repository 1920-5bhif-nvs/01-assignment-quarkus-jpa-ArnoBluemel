package at.htl.model.building;

import javax.persistence.*;

@Entity
@Table(name = "ROOMS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Room
{
    protected static Integer DEFAULT_CLEARANCE_EXHIBITION_ROOM = 0;
    protected static Integer DEFAULT_CLEARANCE_RESEARCH_ROOM = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "ROOM_NAME", nullable = false)
    private String roomName;
    @Column(name = "CLEARANCE", nullable = false)
    private Integer clearance; //0 = Visitors, 1 = Staff, 2 = Scientists, ...

    protected Room() { }

    public String getRoomName()
    {
        return roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public Integer getClearance()
    {
        return clearance;
    }

    public void setClearance(Integer clearance)
    {
        this.clearance = clearance;
    }

    protected Room(String roomName, Integer clearance)
    {
        this.roomName = roomName;
        this.clearance = clearance;
    }
}
