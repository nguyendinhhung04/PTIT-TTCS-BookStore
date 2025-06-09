package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Bill;
import com.ptit.ttcs.bookstore.domain.BillDetail;
import com.ptit.ttcs.bookstore.domain.Customer;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDetailDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.BillDetailMapper;
import com.ptit.ttcs.bookstore.repository.BillDetailRepository;
import com.ptit.ttcs.bookstore.repository.BillRepository;
import com.ptit.ttcs.bookstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final BillDetailRepository billDetailRepository;
    private final CustomerService customerService;
    private final BookService bookService;

    public BillService(BillRepository billRepository, BillDetailRepository billDetailRepository,
                       CustomerService customerService,
                       BookService bookService) {
        this.billRepository = billRepository;
        this.billDetailRepository = billDetailRepository;
        this.customerService = customerService;
        this.bookService = bookService;
    }

    public BillDetail saveBillDetail(BillDetail billDetail) {
        return billDetailRepository.save(billDetail);
    }

    @Transactional(rollbackFor = Exception.class)
    public Bill addBill(BillDTO billDTO) {
        // Validate input
        if (billDTO == null || billDTO.getCustomer_id() == null ||
                billDTO.getBillDetails() == null || billDTO.getBillDetails().isEmpty()) {
            throw new IllegalArgumentException("Invalid bill data");
        }

        // Find customer
        Customer customer = customerService.findUserById(billDTO.getCustomer_id());
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        // Create and save bill
        Bill bill = new Bill();
        bill.setCreate_date(billDTO.getCreate_date());
        bill.setPayment_date(billDTO.getPayment_date());
        bill.setUser(customer);
        Bill savedBill = billRepository.save(bill);

        // Save bill details
        for (BillDetailDTO detailDTO : billDTO.getBillDetails()) {
            if (detailDTO.getBook_id() == null) {
                throw new IllegalArgumentException("Book ID cannot be null");
            }

            BillDetail billDetail = BillDetailMapper.INSTANCE.toBillDetail(detailDTO);
            billDetail.setBill(savedBill);
            billDetail.setBook(bookService.findBookById(detailDTO.getBook_id()));
            billDetailRepository.save(billDetail);
        }

        return savedBill;
    }

}
