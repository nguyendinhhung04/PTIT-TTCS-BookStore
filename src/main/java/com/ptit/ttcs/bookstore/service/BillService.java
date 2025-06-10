package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Bill;
import com.ptit.ttcs.bookstore.domain.BillDetail;
import com.ptit.ttcs.bookstore.domain.Customer;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDetailDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.billDetailFeDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.billFeDTO;
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

    public List<BillDetail> getDetailsOfBill(Long billId) {
        return billDetailRepository.findAllByBillId(billId);           //check
    }

    @Transactional(rollbackFor = Exception.class)
    public void addBill(BillDTO billDTO) {
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
            if (detailDTO.getBookId() == null) {
                throw new IllegalArgumentException("Book ID cannot be null");
            }

            BillDetail billDetail = BillDetailMapper.INSTANCE.toBillDetail(detailDTO);
            billDetail.setBill(savedBill);
            billDetail.setBook(bookService.findBookById(detailDTO.getBookId()));
            billDetailRepository.save(billDetail);
        }
    }

    public billFeDTO getBillById(Long id) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));

        billFeDTO billDTO = new billFeDTO();
        billDTO.setId(bill.getId());
        billDTO.setCreate_date(bill.getCreate_date());
        billDTO.setPayment_date(bill.getPayment_date());
        billDTO.setCustomer(bill.getUser());

        List<billDetailFeDTO> billDetailDTOs = new ArrayList<>();
        List<BillDetail> billDetails = this.getDetailsOfBill(bill.getId());
        for( BillDetail detail : billDetails) {
            billDetailFeDTO detailDTO = BillDetailMapper.INSTANCE.toBillDetailDTO(detail);
            billDetailDTOs.add(detailDTO);
        }
        billDTO.setBillDetailsFe(billDetailDTOs);
        System.out.println("Here");
        return billDTO;
    }

    public List<billFeDTO> getAllBills(){
        List<Bill> bills = billRepository.findAll();
        List<billFeDTO> billDTOs = new ArrayList<>();
        for (Bill bill : bills) {
            billFeDTO billDTO = new billFeDTO();
            billDTO.setId(bill.getId());
            billDTO.setCreate_date(bill.getCreate_date());
            billDTO.setPayment_date(bill.getPayment_date());
            billDTO.setCustomer(bill.getUser());

            List<billDetailFeDTO> billDetailDTOs = new ArrayList<>();
            List<BillDetail> billDetails = this.getDetailsOfBill(bill.getId());
            for( BillDetail detail : billDetails) {
                billDetailFeDTO detailDTO = BillDetailMapper.INSTANCE.toBillDetailDTO(detail);
                billDetailDTOs.add(detailDTO);
            }
            billDTO.setBillDetailsFe(billDetailDTOs);
            billDTOs.add(billDTO);
        }
        System.out.println("Hello");
        return billDTOs;
    }

}
