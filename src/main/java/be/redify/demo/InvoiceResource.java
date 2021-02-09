package be.redify.demo;

import be.redify.demo.dto.InvoiceDTO;
import be.redify.demo.dto.InvoiceUploadDTO;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;

@Path("/invoices")
@Slf4j
public class InvoiceResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public InvoiceDTO hello() {
        return InvoiceDTO.builder()
                .invoiceNumber("12345")
                .status("OK")
                .build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadInvoice(@MultipartForm InvoiceUploadDTO invoiceUploadDTO) {
        log.info(invoiceUploadDTO.invoiceNumber);
        log.info(invoiceUploadDTO.invoiceFilename);
        try {
            log.info(invoiceUploadDTO.invoiceFile.available() + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.created(URI.create("/fruits/NEWINVOICE")).build();
    }
}