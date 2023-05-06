package com.nara.cafe.cms.serviceimpl;

import com.nara.cafe.cms.constants.CafeConstants;
import com.nara.cafe.cms.dao.BillDao;
import com.nara.cafe.cms.dao.CategoryDao;
import com.nara.cafe.cms.dao.ProductDao;
import com.nara.cafe.cms.service.CategoryService;
import com.nara.cafe.cms.service.DashboardService;
import com.nara.cafe.cms.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    BillDao billDao;

    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("category", categoryDao.count());
        map.put("product", productDao.count());
        map.put("bill", billDao.count());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
