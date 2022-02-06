package ml.bigbrains.fsspapiclient.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResultContent {
    private TaskStatus status;
    private Query query;
    private List<Map<String,String>> result;
}
