package com.ptit.ttcs.bookstore.domain.Mapper;


import com.ptit.ttcs.bookstore.domain.Customer;
import com.ptit.ttcs.bookstore.domain.DTO.CreateUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.GetUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {




    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    default GetUserDTO userToGetUserDTO(Customer customer)
    {
        GetUserDTO getUserDTO = new GetUserDTO();
        getUserDTO.setEmail(customer.getEmail());
        getUserDTO.setPhone(customer.getPhone());
        getUserDTO.setAddress(customer.getAddress());
        getUserDTO.setId(customer.getId());
        getUserDTO.setAge(customer.getAge());
        getUserDTO.setFullname(customer.getFullname());
        getUserDTO.setGender(customer.getGender());

        return getUserDTO;
    };



    Customer CreateUserDTOToUser(CreateUserDTO createUserDTO);

}
