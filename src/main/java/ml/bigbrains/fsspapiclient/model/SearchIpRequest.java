package ml.bigbrains.fsspapiclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SearchIpRequest implements GenericRequest {

    private String token;
    private final String requestUrl = "search/ip";
    private final TaskType type = TaskType.IP;

    private String number;

    public SearchIpRequest(String number) {
        this.number = number;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String,String> map = new HashMap<>();
        if(token!=null && !token.equals("") )
            map.put("token",token);
        if(number!=null && !number.equals(""))
            map.put("number",number);
        return map;
    }
}
