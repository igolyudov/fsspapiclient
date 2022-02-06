package ml.bigbrains.fsspapiclient.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class SearchGroupRequest {
    private String token;
    private List<GroupRequest> request;
    private final String requestUrl = "search/group";

    public SearchGroupRequest(String token, List<GenericRequest> requests) {
        this.token = token;
        this.request = new ArrayList<>();
        for(GenericRequest request: requests)
        {
            GroupRequest groupRequest = new GroupRequest();
            groupRequest.setType(TaskType.PHYSICAL.ordinal());
            groupRequest.setParams(request.getParams());
            this.request.add(groupRequest);
        }
    }
}
