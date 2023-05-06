package com.nara.restdemo.response;

import com.nara.restdemo.model.CloudVendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHandler {
    private List<CloudVendor> data;
    private HttpStatus httpStatus;
    private String message;

    public static ResponseEntity<Object> responseBuilder(
            String message, HttpStatus httpStatus, Object responseObject
    ) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }

}
