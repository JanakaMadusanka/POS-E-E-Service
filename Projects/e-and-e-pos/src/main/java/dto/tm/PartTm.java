package dto.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PartTm {
    private String code;
    private String name;
    private BigDecimal unitPrice;
    private Integer qtyOnHand;
    private Button btn;
}
