package com.nara.restdemo.service;

import com.nara.restdemo.model.CloudVendor;
import com.nara.restdemo.response.ResponseHandler;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CloudVendorService {

    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String vendorId);
    public CloudVendor getCloudVendor(String vendorId);
    public List<CloudVendor> getAllCloudVendors();
    public List<CloudVendor> findByVendorName(String vendorName);

}
