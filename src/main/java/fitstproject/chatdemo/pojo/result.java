package fitstproject.chatdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class result {
    private String message;
    private String code;
    private Object data;
}
