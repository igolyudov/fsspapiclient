package ml.bigbrains.fsspapiclient;

import lombok.extern.slf4j.Slf4j;
import ml.bigbrains.fsspapiclient.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(JUnit4.class)
public class FsspapiclientApplicationTests {

	private String testToken = System.getProperty("token");

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


	private FsspApiClient apiClient = new FsspApiClient();


	@Test
	public void testCreateRequest()
	{
		LocalDate birthday = LocalDate.parse("18.06.1982",formatter);
		SearchPhysicalRequest request = new SearchPhysicalRequest(testToken,"Ткаченко","Юрий", "Васильевич", birthday, 1);
		GenericResponse<Task> response = apiClient.searchPhysical(request);
		log.debug("result: {}",response);

	}

	@Test
	public void testGetStatus()
	{
		String taskUUID="b43c0c35-61bc-4a2d-9be5-ac152dffb90b";
		StatusRequest request = new StatusRequest(testToken,taskUUID);
		GenericResponse<Status> response = apiClient.status(request);
		log.debug("result: {}",response);
	}

	@Test
	public void testGetResult()
	{
		String taskUUID="b43c0c35-61bc-4a2d-9be5-ac152dffb90b";
		ResultRequest request = new ResultRequest(testToken, taskUUID);
		GenericResponse<Result> response = apiClient.result(request);
		log.debug("result: {}",response);
	}

	@Test
	public void testGroupRequest()
	{
		LocalDate birthday = LocalDate.parse("18.06.1982",formatter);
		SearchPhysicalRequest subRequest = new SearchPhysicalRequest("Ткаченко","Юрий", "Васильевич", birthday, 1);
		List<GenericRequest> subRequests = new ArrayList<>();
		subRequests.add(subRequest);
		SearchGroupRequest request = new SearchGroupRequest(testToken,subRequests);
		GenericResponse<Task> response = apiClient.searchGroup(request);
		log.debug("result: {}",response);

	}
}
