package ml.bigbrains.fsspapiclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SearchLegalRequest implements GenericRequest {
    private String token;
    private final String requestUrl = "search/legal";
    private final TaskType type = TaskType.LEGAL;

    private Integer regionId;
    private String name;
    private String address;

    public SearchLegalRequest(Integer regionId, String name, String address) {
        this.regionId = regionId;
        this.name = name;
        this.address = address;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String,String> map = new HashMap<>();
        if(token!=null && !token.equals("") )
            map.put("token",token);
        if(regionId!=null && !regionId.equals(""))
            map.put("region",Integer.toString(regionId));
        if(name!=null && !name.equals(""))
            map.put("name",name);
        if(address!=null && !address.equals(""))
            map.put("address",address);
        return map;
    }
}
