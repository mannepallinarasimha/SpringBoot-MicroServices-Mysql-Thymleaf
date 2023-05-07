package com.nara.eps.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Project {
	private long id;
	private long projectCode;
	private String projectName;

}
