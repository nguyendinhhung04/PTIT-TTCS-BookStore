package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDTO;
import com.ptit.ttcs.bookstore.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/admin/resource/bill/confirm")
    public void confirmBill(@RequestBody BillDTO billDTO) {
        billService.addBill(billDTO);
    }

//    @PostMapping("/admin/resource/bill/confirm")
//    public ResponseEntity<?> confirmBill(@RequestBody BillDTO billDTO) {
//        try {
//            if (billDTO == null) {
//                return ResponseEntity.badRequest().body("Bill data cannot be null");
//            }
//            billService.addBill(billDTO);
//            return ResponseEntity.ok().build();
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body("Invalid bill data: " + e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("Error processing bill: " + e.getMessage());
//        }
//    }


}
