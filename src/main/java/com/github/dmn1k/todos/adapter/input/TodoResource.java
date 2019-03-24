package com.github.dmn1k.todos.adapter.input;

import com.github.dmn1k.todos.domain.api.TodoItemAnlegenDto;
import com.github.dmn1k.todos.domain.api.TodoItemService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/todos")
@Stateless
public class TodoResource {
    @Inject
    private TodoItemService todoItems;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response find(@PathParam("id") long id) {
        return todoItems.find(id)
                .map(v -> Response.ok().entity(v).build())
                .orElse(Response.noContent().build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TodoItemAnlegenDto item) {
        todoItems.persist(item);

        return Response.ok().build();
    }

}
