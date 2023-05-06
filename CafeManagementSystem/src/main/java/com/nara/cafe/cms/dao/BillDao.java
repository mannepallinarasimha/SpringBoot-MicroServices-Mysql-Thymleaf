package com.nara.cafe.cms.dao;

import com.nara.cafe.cms.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillDao extends JpaRepository<Bill, Integer> {
    List<Bill> getAllBills();

    List<Bill> getBillByUserName(String currentUser);
}
