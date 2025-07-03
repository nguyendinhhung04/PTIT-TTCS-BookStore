package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.Bill;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.billFeDTO;
import com.ptit.ttcs.bookstore.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/admin/resource/bill/create")
    public Long confirmBill(@RequestBody BillDTO billDTO) {
        Bill bill = billService.addBill(billDTO);
        return bill.getId();
    }

    @GetMapping("/admin/resource/bill/{id}")
    public billFeDTO getBill(@PathVariable Long id) {

        billService.getBillById(id);
        return billService.getBillById(id);

    }

    @GetMapping("/admin/resource/bill/all")
    public List<billFeDTO> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/admin/resource/bill/{id}/confirmed")
    public void confirmBillById(@PathVariable Long id) {
        billService.confirmBill(id);

    }


}
