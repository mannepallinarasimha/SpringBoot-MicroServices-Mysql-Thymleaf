package com.nara.eps.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8082", value = "project-feign-client", path = "/api/project")
public interface ProjectFeign {

	@GetMapping("/{project_code}")
	feign.Response getProjectByProjectCode(@PathVariable("project_code") long projectCode);
}
