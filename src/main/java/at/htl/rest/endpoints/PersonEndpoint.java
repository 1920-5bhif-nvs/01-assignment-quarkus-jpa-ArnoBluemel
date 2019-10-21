package at.htl.rest.endpoints;

import at.htl.model.people.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/persons")
public class PersonEndpoint
{
    @PersistenceContext
    EntityManager em;

    //Persons
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Person> tq = em.createQuery("select p from Person p", Person.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") long id)
    {
        Person p = em.find(Person.class, id);
        return Response.ok().entity(p).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPerson(Person p)
    {
        em.merge(p);
        em.persist(p);
        return Response.ok().entity(p).build();
    }

    @DELETE
    @Path("d/{id}")
    public void deletePerson(@PathParam("id") long id)
    {
        em.remove(em.find(Person.class, id));
    }
    //Persons

    //Staff
    @GET
    @Path("staff")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStaff()
    {
        TypedQuery<Staff> tq = em.createQuery("select s from Staff s", Staff.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("staff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaff(@PathParam("id") long id)
    {
        Staff s = em.find(Staff.class, id);
        return Response.ok().entity(s).build();
    }

    @POST
    @Path("staff")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMineral(Staff s)
    {
        em.merge(s);
        em.persist(s);
        return Response.ok().entity(s).build();
    }

    @DELETE
    @Path("staff/d/{id}")
    public void deleteStaff(@PathParam("id") long id)
    {
        em.remove(em.find(Staff.class, id));
    }
    //Staff

    //Guides
    @GET
    @Path("staff/guides")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGuides()
    {
        TypedQuery<Guide> tq = em.createQuery("select g from Guide g", Guide.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("staff/guides/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuide(@PathParam("id") long id)
    {
        Guide g = em.find(Guide.class, id);
        return Response.ok().entity(g).build();
    }

    @POST
    @Path("staff/guides")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postGuide(Guide g)
    {
        em.merge(g);
        em.persist(g);
        return Response.ok().entity(g).build();
    }

    @DELETE
    @Path("staff/guides/d/{id}")
    public void deleteGuide(@PathParam("id") long id)
    {
        em.remove(em.find(Guide.class, id));
    }
    //Guides

    //Scientists
    @GET
    @Path("staff/scientists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllScientists()
    {
        TypedQuery<Scientist> tq = em.createQuery("select s from Scientist s", Scientist.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("staff/scientists/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getScientist(@PathParam("id") long id)
    {
        Scientist s = em.find(Scientist.class, id);
        return Response.ok().entity(s).build();
    }

    @POST
    @Path("staff/scientists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postScientist(Scientist s)
    {
        em.merge(s);
        em.persist(s);
        return Response.ok().entity(s).build();
    }

    @DELETE
    @Path("staff/scientists/d/{id}")
    public void deleteScientist(@PathParam("id") long id)
    {
        em.remove(em.find(Scientist.class, id));
    }
    //Scientists

    //Visitors
    @GET
    @Path("visitors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVisitors()
    {
        TypedQuery<Visitor> tq = em.createQuery("select v from Visitor v", Visitor.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("visitors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id)
    {
        Visitor v = em.find(Visitor.class, id);
        return Response.ok().entity(v).build();
    }

    @POST
    @Path("visitors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postVisitor(Visitor v)
    {
        em.merge(v);
        em.persist(v);
        return Response.ok().entity(v).build();
    }

    @DELETE
    @Path("visitors/d/{id}")
    public void deleteVisitor(@PathParam("id") long id)
    {
        em.remove(em.find(Visitor.class, id));
    }
    //Visitors
}
