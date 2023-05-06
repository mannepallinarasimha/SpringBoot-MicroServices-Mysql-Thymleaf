package com.nara.mokito.junit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nara.mokito.junit.model.Employee;
import com.nara.mokito.junit.model.EmployeeResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMokitoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addEmployeeTest() throws Exception {
		Employee employee = new Employee();
		employee.setName("Nara");
		employee.setDepartment("SE");
		String jsonRequest = om.writeValueAsString(employee);
		MvcResult result = mockMvc.perform(
				post("/employee/addEmployee").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		// we need to get our exact String
		String resultString = result.getResponse().getContentAsString();
		EmployeeResponse response = om.readValue(resultString, EmployeeResponse.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}

	@Test
	public void getAllEmployeesTest() throws Exception {

		MvcResult result = mockMvc
				.perform(get("/employee/getAllEmployees").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();

		// we need to get our exact String
		String resultString = result.getResponse().getContentAsString();
		EmployeeResponse response = om.readValue(resultString, EmployeeResponse.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}

}
