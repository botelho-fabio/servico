/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package br.edu.unievangelica;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.xml.bind.JAXB;
import java.io.StringWriter;
import com.google.gson.Gson;
import jakarta.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author botel
 */
@Path("temperatura")
public class ServicoResource {

    /**
     * Retrieves representation of an instance of com.deitel.welcomerestxml.ServicoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("fahrenheit/{celsius}")
    @Produces("application/json")
    public String getFahrenheit(@jakarta.ws.rs.PathParam("celsius") String c) {
        
        Double fahrenheit = 0.0;
        
        fahrenheit = (Double.parseDouble(c) * 1.8) + 32;
        
        //String message = c + " graus celsius, coresponde a " + fahrenheit.toString() + " graus fahrenheit. ";
       
        return new Gson().toJson(fahrenheit.toString());
        
    }
    
    @GET
    @Path("kelvin/{celsius}")
    @Produces("application/json")
    public String getKelvin(@jakarta.ws.rs.PathParam("celsius") String c) {
        
        Double kelvin = 0.0;
        
        kelvin = (Double.parseDouble(c)) + 273;
       
        return new Gson().toJson(kelvin.toString());
        
    }
    
    @POST @Consumes("application/json")
    @Path("fahrenheit")
    @Produces("application/json")
    public String getFahrenheit(CelsiusBean input) {
        
        Double fahrenheit = 0.0;
        
        fahrenheit = (Double.parseDouble(input.celsius) * 1.8) + 32;
        
        //String message = c + " graus celsius, coresponde a " + fahrenheit.toString() + " graus fahrenheit. ";
       
        return new Gson().toJson(fahrenheit.toString());
        
    }
    
    @POST @Consumes("application/json")
    @Path("kelvin")
    @Produces("application/json")
    public String getKelvin(CelsiusBean input) {
        
        Double kelvin = 0.0;
        
        kelvin = (Double.parseDouble(input.celsius)) + 273;
       
        return new Gson().toJson(kelvin.toString());
        
    }

}
