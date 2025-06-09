package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Bill;
import com.ptit.ttcs.bookstore.domain.Customer;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDTO;
import com.ptit.ttcs.bookstore.repository.BillDetailRepository;
import com.ptit.ttcs.bookstore.repository.BillRepository;
import com.ptit.ttcs.bookstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final BillDetailRepository billDetailRepository;
    private final CustomerService customerService;

    public BillService(BillRepository billRepository, BillDetailRepository billDetailRepository,
                       CustomerService customerService) {
        this.billRepository = billRepository;
        this.billDetailRepository = billDetailRepository;
        this.customerService = customerService;
    }

    public Bill addBill(BillDTO billDTO) {
        Bill bill = new Bill();
        bill.setCreate_date(billDTO.getCreate_date());

        Customer customer = customerService.findUserById(billDTO.getCustomer_id());
        bill.setUser(customer);

    }

}
