package ml.bigbrains.fsspapiclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ml.bigbrains.fsspapiclient.model.*;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;


@Slf4j
public class FsspApiClient {

    private String baseUrl = "https://api-ip.fssp.gov.ru/api/v1.0/";

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public FsspApiClient() {
    }

    public FsspApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public GenericResponse<Task> searchPhysical(SearchPhysicalRequest request)
    {
        GenericResponse<Task> response = getRequest(request.getRequestUrl(), request.getParams(), GenericResponse.class);
        return response;
    }

    public GenericResponse<Task> searchIp(SearchIpRequest request)
    {
        GenericResponse<Task> response = getRequest(request.getRequestUrl(), request.getParams(), GenericResponse.class);
        return response;
    }

    public GenericResponse<Task> searchLegal(SearchLegalRequest request)
    {
        GenericResponse<Task> response = getRequest(request.getRequestUrl(), request.getParams(), GenericResponse.class);
        return response;
    }

    public GenericResponse<Task> searchGroup(SearchGroupRequest request)
    {
        GenericResponse<Task> response = postRequest(request.getRequestUrl(), request, GenericResponse.class);
        return response;
    }

    public GenericResponse<Status> status(StatusRequest request)
    {
        GenericResponse<Status> response = getRequest(request.getRequestUrl(), request.getParams(), GenericResponse.class);
        return response;
    }

    public GenericResponse<Result> result(ResultRequest request)
    {
        GenericResponse<Result> response = getRequest(request.getRequestUrl(), request.getParams(), GenericResponse.class);
        return response;
    }

    private <T> T getRequest(String url, Map<String, String> params, Class<T> responseClass) {

        HttpUrl.Builder requestUrl = HttpUrl.parse(baseUrl+url).newBuilder();

        for(Map.Entry<String, String> param : params.entrySet()) {
            requestUrl.addQueryParameter(param.getKey(),param.getValue());
        }

        okhttp3.Request request = new Request.Builder()
                .url(requestUrl.build())
                .header("accept","application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
            {
                log.warn("Response is not success. Response code: {}",response.code());
            }
            return mapper.readValue(Objects.requireNonNull(response.body()).string(), responseClass);
        }
        catch (NullPointerException e)
        {
            log.error("Empty response body after request to {}",url);
            return null;
        }
        catch (IOException e)
        {
            log.error("Error in getRequest to {}",url,e);
            return null;
        }
    }

    private <T> T postRequest(String url, Object requestObject, Class<T> responseClass) {

        String strRequest = "";
        try {
            strRequest = mapper.writeValueAsString(requestObject);
        }
        catch (JsonProcessingException e)
        {
            log.error("Error in convert request object to JSON",e);
        }

        Request.Builder urlBuilder = new Request.Builder()
                .url(baseUrl + url)
                .header("accept", "application/json");


        RequestBody formBody  = RequestBody.create(strRequest, JSON);
        okhttp3.Request request = urlBuilder.post(formBody).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
            {
                log.warn("Response is not success. Response code: {}",response.code());
            }
            if(response.body()!=null)
                return mapper.readValue(response.body().string(), responseClass);
            else
            {
                log.error("Empty response body after request to {}",url);
                return null;
            }
        }
        catch (IOException e)
        {
            log.error("Error in postRequest to {}",url,e);
            return null;
        }
    }
}
