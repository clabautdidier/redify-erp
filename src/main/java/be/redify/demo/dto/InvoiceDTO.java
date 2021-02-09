package be.redify.demo.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InvoiceDTO {
    public String invoiceNumber;
    public String status;
}
