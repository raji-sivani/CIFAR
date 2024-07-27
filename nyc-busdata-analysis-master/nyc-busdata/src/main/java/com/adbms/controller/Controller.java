package com.adbms.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adbms.data.AccessData;
import com.adbms.dto.Transport;

/**
 * Root resource (exposed at "transport" path)
 */
@Path("transport")
public class Controller {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "APPLICATION_JSON" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
    @GET
    @Path("/details/{day}/{startTime}/{endTime}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transport> getTransportDetailsForDay(@PathParam("day") String day, 
    		@PathParam("startTime") String startTime, @PathParam("endTime") String endTime) {
    	AccessData accessData = new AccessData();
    	List<Transport> transportDetails = accessData.getTrasnportDetailsForDay(day, startTime, endTime);
    	return transportDetails;
    }
    
}
