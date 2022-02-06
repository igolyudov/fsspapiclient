package ml.bigbrains.fsspapiclient.model;


import java.util.Map;

public interface GenericRequest {
    String getToken();
    String getRequestUrl();
    Map<String,String> getParams();
    TaskType getType();
}
