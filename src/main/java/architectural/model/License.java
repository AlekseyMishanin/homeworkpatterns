package architectural.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class License {

    private String serialId;
    private String type;
    private int deviceCount;
    private String duration;

}
