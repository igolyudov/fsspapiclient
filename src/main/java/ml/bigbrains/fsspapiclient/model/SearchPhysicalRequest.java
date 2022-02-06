package ml.bigbrains.fsspapiclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class SearchPhysicalRequest implements GenericRequest {
    private String token;
    private final String requestUrl = "search/physical";
    private final TaskType type = TaskType.PHYSICAL;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private Integer regionId;

    public SearchPhysicalRequest(String surname, String name, String patronymic, LocalDate birthday, Integer regionId) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.regionId = regionId;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String,String> map = new HashMap<>();
        if(token!=null && !token.equals("") )
            map.put("token",token);
        if(regionId!=null && !regionId.equals(""))
            map.put("region",Integer.toString(regionId));
        if(surname!=null && !surname.equals(""))
            map.put("lastname",surname);
        if(name!=null && !name.equals(""))
            map.put("firstname",name);
        if(patronymic!=null && !patronymic.equals(""))
            map.put("secondname",patronymic);
        if(birthday!=null)
            map.put("birthdate",birthday.format(formatter));
        return map;
    }

}
