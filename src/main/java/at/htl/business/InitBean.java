package at.htl.business;

import at.htl.model.building.ExhibitionRoom;
import at.htl.model.building.ResearchRoom;
import at.htl.model.events.SingleVisit;
import at.htl.model.events.Tour;
import at.htl.model.objects.Fossil;
import at.htl.model.objects.Mineral;
import at.htl.model.people.Guide;
import at.htl.model.people.Scientist;
import at.htl.model.people.Visitor;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;

@ApplicationScoped
@Transactional
public class InitBean
{
    @PersistenceContext
    private EntityManager em;

    public InitBean()
    {

    }

    void onStart(@Observes StartupEvent ev)
    {
        //Persons
        //-Staff
        //--Guides
        Guide guide1 = new Guide("Deppy Dave", 46L, 506.80D);
        Guide guide2 = new Guide("John Doe", 22L, 490.45D);
        //--Scientists
        Scientist scientist1 = new Scientist("Ellie Sattler", 45L, 2800.87D, "Paleobiology", "Dr.", "");
        Scientist scientist2 = new Scientist("Alan Grant", 56L, 3467.40D, "Paleontology", "Dr.", "");
        Scientist scientist3 = new Scientist("Ian Malcolm", 36L, 2763.65D, "Chaos Theory", "Dr.", "");
        Scientist scientist4 = new Scientist("John Hammond", 73L, 5904.53D, "Genetics", "Prof.", "");
        //-Visitors
        Visitor visitor1 = new Visitor("Max Mustermann", 50L, null);
        Visitor visitor2 = new Visitor("Erika Mustermann", 47L, null);
        Visitor visitor3 = new Visitor("Michael Mustermann", 12L, null);
        Visitor visitor4 = new Visitor("David Wong", 35L, null);
        //Rooms
        //-ExhibitionRooms
        ExhibitionRoom exRoom1 = new ExhibitionRoom("Late Cretaceous Period", scientist2);
        ExhibitionRoom exRoom2 = new ExhibitionRoom("Precious Stones", scientist3);
        ExhibitionRoom exRoom3 = new ExhibitionRoom("Mesozoic Era", scientist2);
        ExhibitionRoom exRoom4 = new ExhibitionRoom("Jurassic Park", scientist4);
        ExhibitionRoom exRoom5 = new ExhibitionRoom("Dinosaur Anatomy", scientist2);
        //-ResearchRooms
        ResearchRoom reRoom1 = new ResearchRoom("Archive", new ArrayList());
        ResearchRoom reRoom2 = new ResearchRoom("Hammond Creation Lab", new ArrayList());
        ResearchRoom reRoom3 = new ResearchRoom("Geological Research", new ArrayList());
        reRoom1.getScientists().add(scientist1);
        reRoom1.getScientists().add(scientist2);
        reRoom1.getScientists().add(scientist3);
        reRoom1.getScientists().add(scientist4);
        reRoom2.getScientists().add(scientist2);
        reRoom2.getScientists().add(scientist4);
        reRoom3.getScientists().add(scientist3);
        //Visits
        //-SingleVisits
        SingleVisit siVisit1 = new SingleVisit(visitor4, LocalDateTime.of(2018, 8, 26, 13, 46));
        //-Tours
        Tour tour1 = new Tour(10D, 2D, "The Land Before Time", LocalDateTime.of(2018, 10, 20, 9, 12), 4L, guide1, new ArrayList());
        tour1.getVisitors().add(visitor1);
        tour1.getVisitors().add(visitor2);
        tour1.getVisitors().add(visitor3);
        //Exhibits
        //-Fossils
        Fossil fossil1 = new Fossil("T-Rex Scapula", "Dinosaur Provincial Park", exRoom1, 68L, "Tyrannosaurus rex", "Tyrannosaurus", "Tyrannosauridae", "Saurischia", "Reptilia", "Chordata", "Animalia", "Eucaryota");
        Fossil fossil2 = new Fossil("Triceratops Cranium", "Great Plains", exRoom1, 67L, "Ceratops horridus", "Triceratops", "Ceratopsidae", "Ornitischia", "Reptilia", "Chordata", "Animalia", "Eucaryota");
        visitor1.setFavouriteObject(fossil2);
        visitor3.setFavouriteObject(fossil1);
        visitor4.setFavouriteObject(fossil2);
        //-Minerals
        Mineral mineral1 = new Mineral("Diamond", "Ruanda", exRoom2, "Carbon", "C", 3520D);
        Mineral mineral2 = new Mineral("Ruby", "Kenya", exRoom2, "Aluminium Oxide with Chromium", "Al2O3:Cr", 4050D);
        visitor2.setFavouriteObject(mineral1);
        //persist
        em.persist(guide1);
        em.persist(guide2);
        em.persist(scientist1);
        em.persist(scientist2);
        em.persist(scientist3);
        em.persist(scientist4);
        em.persist(visitor1);
        em.persist(visitor2);
        em.persist(visitor3);
        em.persist(visitor4);
        em.persist(exRoom1);
        em.persist(exRoom2);
        em.persist(exRoom3);
        em.persist(exRoom4);
        em.persist(exRoom5);
        em.persist(reRoom1);
        em.persist(reRoom2);
        em.persist(reRoom3);
        em.persist(siVisit1);
        em.persist(tour1);
        em.persist(fossil1);
        em.persist(fossil2);
        em.persist(mineral1);
        em.persist(mineral2);
    }

    void onStop(@Observes ShutdownEvent ev) {

    }
}
