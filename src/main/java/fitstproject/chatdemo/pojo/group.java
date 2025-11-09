package fitstproject.chatdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class group {
    private String groupName;
    private List<Integer> memberIds;
}
