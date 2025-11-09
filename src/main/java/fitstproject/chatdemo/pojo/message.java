package fitstproject.chatdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class message {
    private Integer receiveId;
    private String content;
    private Integer sendId;
}
