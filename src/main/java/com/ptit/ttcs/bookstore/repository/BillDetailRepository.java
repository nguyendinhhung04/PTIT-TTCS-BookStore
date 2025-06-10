package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Bill;
import com.ptit.ttcs.bookstore.domain.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
    
    public List<BillDetail> findAllByBillId(Long billId);

    public List<BillDetail> findAllByBill(Bill bill);
    
}
