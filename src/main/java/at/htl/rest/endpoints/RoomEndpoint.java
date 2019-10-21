package at.htl.rest.endpoints;

import at.htl.model.building.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rooms")
public class RoomEndpoint
{
    @PersistenceContext
    EntityManager em;

    //Rooms
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Room> tq = em.createQuery("select r from Room r", Room.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoom(@PathParam("id") long id) {
        Room r = em.find(Room.class, id);
        return Response.ok().entity(r).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postRoom(Room r)
    {
        em.merge(r);
        em.persist(r);
        return Response.ok().entity(r).build();
    }

    @DELETE
    @Path("d/{id}")
    public void deleteRoom(@PathParam("id") long id)
    {
        em.remove(em.find(Room.class, id));
    }
    //Rooms

    //ExhibitionRooms
    @GET
    @Path("exhibition-rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllExhibitionRooms()
    {
        TypedQuery<ExhibitionRoom> tq = em.createQuery("select er from ExhibitionRoom er", ExhibitionRoom.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("exhibition-room/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExhibitionRoom(@PathParam("id") long id)
    {
        ExhibitionRoom er = em.find(ExhibitionRoom.class, id);
        return Response.ok().entity(er).build();
    }

    @POST
    @Path("exhibition-rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postExhibitionRoom(ExhibitionRoom er)
    {
        em.merge(er);
        em.persist(er);
        return Response.ok().entity(er).build();
    }

    @DELETE
    @Path("exhibition-rooms/d/{id}")
    public void deleteExhibitionRoom(@PathParam("id") long id)
    {
        em.remove(em.find(ExhibitionRoom.class, id));
    }
    //ExhibitionRooms

    //ResearchRooms
    @GET
    @Path("research-rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllResearchRooms()
    {
        TypedQuery<ResearchRoom> tq = em.createQuery("select er from ResearchRoom er", ResearchRoom.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("research-room/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResearchRoom(@PathParam("id") long id)
    {
        ResearchRoom er = em.find(ResearchRoom.class, id);
        return Response.ok().entity(er).build();
    }

    @POST
    @Path("research-rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postResearchRoom(ResearchRoom rr)
    {
        em.merge(rr);
        em.persist(rr);
        return Response.ok().entity(rr).build();
    }

    @DELETE
    @Path("research-rooms/d/{id}")
    public void deleteMineral(@PathParam("id") long id)
    {
        em.remove(em.find(ResearchRoom.class, id));
    }
    //ResearchRooms
}
