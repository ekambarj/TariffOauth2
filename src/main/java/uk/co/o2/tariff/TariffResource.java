package uk.co.o2.tariff;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import uk.co.o2.dao.TariffDAO;
import uk.co.o2.exception.TariffNotFoundException;
import uk.co.o2.util.TariffConstants;
import uk.co.o2.vo.Tariff;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiErrors;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/tariffs")
@Api(value = "/tariffs", description = "Manage Tariff details")
@Produces({ "application/json" })
public class TariffResource {

	@GET
	@Path("/")
	@ApiOperation(value = "Returns list of all available Tariff details", notes = "Returns all the tariff details", responseClass = "uk.co.o2.vo.Tariff", multiValueResponse = true)
	@Produces({ "application/json" })
	public List<Tariff> tariff() {

		// List custList = tariffDAO.gettariffList();
		List tarifffList = TariffDAO.getTariffList();

		if ((tarifffList == null) || (tarifffList.size() <= 0)) {
			Response.status(Response.Status.NO_CONTENT)
					.entity(getMessage(204, "Tariff details not available",
							TariffConstants.MSG_TYPE_INFO)).build();
		}
		Response.status(Response.Status.OK).build();

		return tarifffList;
	}

	@POST
	@Path("/")
	@ApiOperation(value = "Creates a new Tariff details", notes = "Creates a new Tariff detail", responseClass = "java.lang.String")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response tariff(
			@ApiParam(value = "Tariff details", required = true) Tariff tariff) {

		TariffDAO.addTariff(tariff);
		return Response
				.status(Response.Status.CREATED)
				.entity(getMessage(201, "Tariff details created successfully!",
						TariffConstants.MSG_TYPE_INFO)).build();

	}

	@PUT
	@Path("/{tariffID}")
	@ApiOperation(value = "Updates Tariff detail", notes = "Updates tariff detail", responseClass = "java.lang.String")
	@ApiErrors({ @com.wordnik.swagger.annotations.ApiError(code = 404, reason = "Tariff details not found") })
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response tariff(@PathParam("tariffID") String tariffID,
			@ApiParam(value = "Tariff details", required = true) Tariff tariff) {

		Tariff tariffvo = null;

		try {

			tariffvo = TariffDAO.getTariffDetail(tariffID);
			tariffvo.setTariffID(tariffID);
			TariffDAO.updateTariff(tariff);

			return Response
					.status(Response.Status.OK)
					.entity(getMessage(200,
							"Tariff details updated successfully",
							TariffConstants.MSG_TYPE_INFO)).build();

		} catch (TariffNotFoundException e) {

			return Response
					.status(Response.Status.NOT_FOUND)
					.entity(getMessage(404, "Tariff details not found",
							TariffConstants.MSG_TYPE_ERROR)).build();
		}
	}

	@GET
	@Path("/{TariffID}")
	@ApiOperation(value = "Get tariff details by tariff id", notes = "Returns tariff details for the given tariff id", responseClass = "uk.co.o2.vo.Tariff")
	@ApiErrors({ @com.wordnik.swagger.annotations.ApiError(code = 404, reason = "Tariff details not found") })
	@Produces({ "application/json" })
	public Response tariff(@PathParam("TariffID") int TariffID) {

		Tariff tariffVO = null;

		try {
			tariffVO = TariffDAO.getTariffDetail(TariffID + "");

			return Response.status(Response.Status.OK).entity(tariffVO).build();

		} catch (TariffNotFoundException e) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity(getMessage(404, "Tariff details not found",
							TariffConstants.MSG_TYPE_ERROR)).build();
		}
	}

	@DELETE
	@Path("/{tariffID}")
	@ApiOperation(value = "Delete Tariff details", notes = "Deletes tariff details for the given tariff id", responseClass = "java.lang.String")
	@ApiErrors({ @com.wordnik.swagger.annotations.ApiError(code = 404, reason = "Tariff Details not found") })
	@Produces({ "application/json" })
	public Response tariff(
			@ApiParam(value = "tariffID", required = true) @PathParam("tariffID") String tariffID) {

		try {
			TariffDAO.deleteTariff(tariffID);
			return Response
					.status(Response.Status.OK)
					.entity(getMessage(200,
							"Tariff details deleted successfully",
							TariffConstants.MSG_TYPE_INFO)).build();
		} catch (TariffNotFoundException e) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity(getMessage(404, "Tariff details not found",
							TariffConstants.MSG_TYPE_ERROR)).build();
		}

	}

	private static String getMessage(int code, String message, String errorType) {
		return "{\"code\": " + code + ",  \"message\": " + message
				+ " ,  \"type\": " + errorType + "}";
	}

}