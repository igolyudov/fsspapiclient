package ml.bigbrains.fsspapiclient.model;

import lombok.Data;

import java.util.Map;

@Data
public class Query {
    private TaskType type;
    private Map<String,String> params;
}
