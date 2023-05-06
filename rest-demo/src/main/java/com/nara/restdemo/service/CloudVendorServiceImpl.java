package com.nara.restdemo.service;

import com.nara.restdemo.exception.CloudVendorNotFoundException;
import com.nara.restdemo.model.CloudVendor;
import com.nara.restdemo.repository.CloudVendorRepository;
import com.nara.restdemo.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{

    private CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        if(!cloudVendorRepository.findById(cloudVendor.getVendorId()).isEmpty()){
            throw new CloudVendorNotFoundException("Requested cloud vendor with "+cloudVendor.getVendorId()+ "Already Exist exist");
        }
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        if(cloudVendorRepository.findById(cloudVendor.getVendorId()).isEmpty()){
            throw new CloudVendorNotFoundException("Requested cloud vendor with "+cloudVendor.getVendorId()+ "DoesNOt Exist ");
        }
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty()){
            throw new CloudVendorNotFoundException("Requested cloud vendor with "+vendorId+ " does not exist");
        }
        cloudVendorRepository.deleteById(vendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        //exception code
        if(cloudVendorRepository.findById(vendorId).isEmpty()){
            throw new CloudVendorNotFoundException("Requested cloud vendor with "+vendorId+ " does not exist");
        }
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        if(cloudVendorRepository.findAll().isEmpty()){
            throw new CloudVendorNotFoundException("NO Cloud Vendors Available in DB");
        }
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> findByVendorName(String vendorName) {
        if(cloudVendorRepository.findByVendorName(vendorName).isEmpty()){
            throw new CloudVendorNotFoundException("NO Cloud Vendors Available in DB with Name :"+vendorName);
        }
        return cloudVendorRepository.findByVendorName(vendorName);
    }


}
