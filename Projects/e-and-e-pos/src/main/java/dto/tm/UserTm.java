package dto.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserTm {
    private String id;
    private String name;
    private String role;
    private String email;
    private String password;
    private Button btn;
}
