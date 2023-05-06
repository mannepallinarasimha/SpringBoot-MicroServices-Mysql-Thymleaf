package com.nara.restdemo.controller;

import com.nara.restdemo.model.CloudVendor;
import com.nara.restdemo.response.ResponseHandler;
import com.nara.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorById(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.responseBuilder(
                "Successfully fetched HERE Cloud Vendor with Id: " + vendorId,
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseHandler getCloudVendorId(@PathVariable("vendorId") String vendorId) {
        CloudVendor cloudVendor = cloudVendorService.getCloudVendor(vendorId);
        return new ResponseHandler(Arrays.asList(cloudVendor), HttpStatus.OK, "Successfully fetched Records with vendorId: " + vendorId);
    }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping()
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping()
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorById(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }

//    @GetMapping("{vendorName}")
//    public ResponseHandler getCloudVendorByName(@PathVariable("vendorName") String vendorName) {
//        return new ResponseHandler(
//                cloudVendorService.findByVendorName(vendorName),
//                HttpStatus.OK,
//                "Successfully fetched Records with vendorName: " + vendorName);
//    }
}
