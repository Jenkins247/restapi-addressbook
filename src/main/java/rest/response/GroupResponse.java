package rest.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupResponse {
    private Integer id;
    private String name;
    private String header;
    private String footer;
}
