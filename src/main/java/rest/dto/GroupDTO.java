package rest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupDTO {
    private Integer id;
    private String name;
    private String header;
    private String footer;
}
