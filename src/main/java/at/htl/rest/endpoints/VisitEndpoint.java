package at.htl.rest.endpoints;

import at.htl.model.events.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/visits")
public class VisitEndpoint
{
    @PersistenceContext
    EntityManager em;

    //Visits
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Visit> tq = em.createQuery("select v from Visit v", Visit.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisit(@PathParam("id") long id)
    {
        Visit v = em.find(Visit.class, id);
        return Response.ok().entity(v).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postVisit(Visit v)
    {
        em.merge(v);
        em.persist(v);
        return Response.ok().entity(v).build();
    }

    @DELETE
    @Path("d/{id}")
    public void deleteVisit(@PathParam("id") long id)
    {
        em.remove(em.find(Visit.class, id));
    }
    //Visits

    //SingleVisits
    @GET
    @Path("single-vists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSingleVisit()
    {
        TypedQuery<SingleVisit> tq = em.createQuery("select sv from SingleVisit sv", SingleVisit.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("single-visits/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleVisit(@PathParam("id") long id)
    {
        SingleVisit sv = em.find(SingleVisit.class, id);
        return Response.ok().entity(sv).build();
    }

    @POST
    @Path("single-visits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postSingleVisit(SingleVisit sv)
    {
        em.merge(sv);
        em.persist(sv);
        return Response.ok().entity(sv).build();
    }

    @DELETE
    @Path("single-visits/d/{id}")
    public void deleteSingleVisit(@PathParam("id") long id)
    {
        em.remove(em.find(SingleVisit.class, id));
    }
    //SingleVisits

    //Tours
    @GET
    @Path("tours")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTours()
    {
        TypedQuery<Tour> tq = em.createQuery("select t from Tour t", Tour.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("tours/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTour(@PathParam("id") long id)
    {
        Tour t = em.find(Tour.class, id);
        return Response.ok().entity(t).build();
    }

    @POST
    @Path("tours")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMineral(Tour t)
    {
        em.merge(t);
        em.persist(t);
        return Response.ok().entity(t).build();
    }

    @DELETE
    @Path("tours/d/{id}")
    public void deleteTour(@PathParam("id") long id)
    {
        em.remove(em.find(Tour.class, id));
    }
    //Tours
}
