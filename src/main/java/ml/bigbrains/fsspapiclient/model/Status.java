package ml.bigbrains.fsspapiclient.model;

import lombok.Data;

@Data
public class Status {
    private TaskStatus status;
    private String progress;
}
