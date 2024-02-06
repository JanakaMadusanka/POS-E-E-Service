package entity;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class RepairOrderEntity {
    private int orderId;
    private Date date;
    private String description;
    private String customerContact;
    private String item;
    private String itemCode;
}
