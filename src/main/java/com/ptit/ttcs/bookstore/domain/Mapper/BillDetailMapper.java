package com.ptit.ttcs.bookstore.domain.Mapper;

import com.ptit.ttcs.bookstore.domain.BillDetail;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDetailDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.billFeDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.billDetailFeDTO;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BillDetailMapper {

    BillDetailMapper INSTANCE = Mappers.getMapper(BillDetailMapper.class);

    default BillDetail toBillDetail(BillDetailDTO billDetailDTO) {
        if (billDetailDTO == null) {
            return null;
        }
        BillDetail billDetail = new BillDetail();
        billDetail.setQuantity(billDetailDTO.getQuantity());
        billDetail.setPrice(billDetailDTO.getPrice());
        return billDetail;
    }

    default billDetailFeDTO toBillDetailDTO(BillDetail billDetail) {
        if (billDetail == null) {
            return null;
        }
        billDetailFeDTO billDetailDTO = new billDetailFeDTO();
        billDetailDTO.setBookName( billDetail.getBook().getBook_name());
        billDetailDTO.setCode(billDetail.getBook().getCode());
        billDetailDTO.setQuantity(billDetail.getQuantity());
        billDetailDTO.setPrice(billDetail.getPrice());
        return billDetailDTO;
    }

}
