package ml.bigbrains.fsspapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Result {
    private TaskStatus status;
    @JsonProperty("task_start")
    private String taskStart;
    @JsonProperty("task_end")
    private String taskEnd;
    private List<ResultContent> result;
}
