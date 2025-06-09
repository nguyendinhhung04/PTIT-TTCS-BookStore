package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Staff;
import com.ptit.ttcs.bookstore.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public Staff findById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));
    }

    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    public boolean checkUsernameExists(String username) {
        return staffRepository.existsByUsername(username);
    }

    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }
}
