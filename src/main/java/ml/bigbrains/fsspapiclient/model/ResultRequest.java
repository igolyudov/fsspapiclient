package ml.bigbrains.fsspapiclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ResultRequest implements GenericRequest {
    private String token;
    private String task;
    private final String requestUrl = "result";
    private final TaskType type = TaskType.UNDEFINED;

    @Override
    public Map<String, String> getParams() {
        Map<String, String> map = new HashMap<>();
        if (token != null && !token.equals(""))
            map.put("token", token);
        if (task != null && !task.equals(""))
            map.put("task", task);
        return map;
    }
}
