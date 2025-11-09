package fitstproject.chatdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class groupmessage {
    private Integer sendId;
    private String content;
    private Integer groupName;
}
