package at.htl.rest.endpoints;

import at.htl.model.objects.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/exhibits")
public class ExhibitEndpoint
{
    @PersistenceContext
    EntityManager em;

    //Exhibits
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Exhibit> tq = em.createQuery("select e from Exhibit e", Exhibit.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExhibit(@PathParam("id")long id)
    {
        Exhibit e = em.find(Exhibit.class, id);
        return  Response.ok().entity(e).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postExhibits(Exhibit e)
    {
        em.merge(e);
        em.persist(e);
        return Response.ok().entity(e).build();
    }

    @DELETE
    @Path("d/{id}")
    public void deleteExhibit(@PathParam("id") long id)
    {
        em.remove(em.find(Exhibit.class, id));
    }
    //Exhibits

    //Minerals
    @GET
    @Path("minerals")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMinerals()
    {
        TypedQuery<Mineral> tq = em.createQuery("select m from Mineral m", Mineral.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("minerals/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMineral(@PathParam("id")long id)
    {
        Mineral m = em.find(Mineral.class, id);
        return  Response.ok().entity(m).build();
    }

    @POST
    @Path("minerals")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMineral(Mineral m)
    {
        em.merge(m);
        em.persist(m);
        return Response.ok().entity(m).build();
    }

    @DELETE
    @Path("minerals/d/{id}")
    public void deleteMineral(@PathParam("id") long id)
    {
        em.remove(em.find(Mineral.class, id));
    }
    //Minerals

    //Fossils
    @GET
    @Path("fossils")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFossils()
    {
        TypedQuery<Fossil> tq = em.createQuery("select f from Fossil f", Fossil.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("fossils/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFossil(@PathParam("id") long id)
    {
        Fossil f = em.find(Fossil.class, id);
        return Response.ok().entity(f).build();
    }

    @POST
    @Path("fossils")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postFossil(Fossil f)
    {
        em.merge(f);
        em.persist(f);
        return Response.ok().entity(f).build();
    }

    @DELETE
    @Path("fossils/d/{id}")
    public void deleteFossil(@PathParam("id") long id)
    {
        em.remove(em.find(Fossil.class, id));
    }
    //Fossils
}
