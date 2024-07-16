package rest.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupRequest {
    private String name;
    private String header;
    private String footer;
}
