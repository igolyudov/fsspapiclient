package ml.bigbrains.fsspapiclient.model;

import lombok.Data;

import java.util.Map;

@Data
public class GroupRequest {
    private Integer type;
    private Map<String,String> params;
}
