package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RepairOrderDto {
    private int orderId;
    private Date date;
    private String description;
    private String customerContact;
    private String item;
    private String itemCode;
}
