/**
 * 
 */
package uk.co.o2.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.wordnik.swagger.annotations.*;
import com.wordnik.swagger.jaxrs.listing.ApiListing;

@Path("/resources")
@Api("/resources")
@Produces({"application/json"})
public class ApiListingResource extends ApiListing {}
