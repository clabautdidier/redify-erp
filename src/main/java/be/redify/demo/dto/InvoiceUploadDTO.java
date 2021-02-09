package be.redify.demo.dto;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

public class InvoiceUploadDTO {
    @FormParam("invoiceFile")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream invoiceFile;

    @FormParam("invoiceFilename")
    @PartType("text/plain")
    public String invoiceFilename;

    @FormParam("invoiceNumber")
    @PartType(MediaType.TEXT_PLAIN)
    public String invoiceNumber;
}
