package at.htl.model.building;

import at.htl.model.people.Scientist;

import javax.persistence.*;

@Entity
@Table(name = "EXHIBITION_ROOMS")
public class ExhibitionRoom extends Room
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    //@Column(name = "CARETAKER")
    @ManyToOne
    private Scientist caretaker;

    public ExhibitionRoom(String roomName, Scientist caretaker)
    {
        super(roomName, Room.DEFAULT_CLEARANCE_EXHIBITION_ROOM);
        this.caretaker = caretaker;
    }

    public ExhibitionRoom() { }
}
