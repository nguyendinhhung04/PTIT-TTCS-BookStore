package com.ptit.ttcs.bookstore.domain.Mapper;

import com.ptit.ttcs.bookstore.domain.BillDetail;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDTO;
import com.ptit.ttcs.bookstore.domain.DTO.BillDTO.BillDetailDTO;
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


}
