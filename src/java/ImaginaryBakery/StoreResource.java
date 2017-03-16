/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImaginaryBakery;

import org.w3c.dom.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;


/**
 * REST Web Service
 *
 * @author gluck
 */
@Path("Store")
public class StoreResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StoreResource
     */
    public StoreResource() {
    }

    /**
     * Retrieves representation of an instance of ImaginaryBakery.StoreResource
     * @param orderNumber
     * @param itemOrdered
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws javax.xml.transform.TransformerConfigurationException
     * @throws javax.xml.transform.TransformerException
     */
    @POST
    @Path("NewOrder")
    @Consumes(MediaType.TEXT_PLAIN)
    public void CreateNewOrder(@PathParam("orderNumber") String orderNumber, @PathParam("itemOrdered") String itemOrdered) throws ParserConfigurationException, TransformerConfigurationException, TransformerException
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        
        
        Element order = doc.createElement("orders");
        Attr attr = doc.createAttribute("ordernumber");
        attr.setValue(orderNumber);
        order.setAttributeNode(attr);
        
        Element item = doc.createElement("items");
        item.appendChild(doc.createTextNode(itemOrdered));
        order.appendChild(item);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("orders.xml"));
        transformer.transform(source, result);
    }
    
    @GET
    @Path("OrderHistory")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String GetOrderHistory(@PathParam("orderNumber") int orderNumber) throws FileNotFoundException, XPathExpressionException 
    {
        //use order number to return matching xml entry
        File orders = new File("orders.xml");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        InputSource source = new InputSource(new FileReader(orders));
        String xItem = String.format("/order[@ordernumber = {0}]/item", orderNumber);
        String itemsOrdered = xpath.evaluate(xItem, source);
        return itemsOrdered;
    }

    /**
     * PUT method for updating or creating an instance of StoreResource
     * @param orderNumber
     * @param item
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void addItem(@PathParam("orderNumber") int orderNumber, @PathParam("item") String item) 
    {
        File orderHistory = new File("orderHistory.txt");
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    public void deleteOrder(@PathParam("orderNumber") int orderNumber)
    {
        
    }
}
