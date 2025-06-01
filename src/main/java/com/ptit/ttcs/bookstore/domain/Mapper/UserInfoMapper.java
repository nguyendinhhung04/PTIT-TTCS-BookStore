package com.ptit.ttcs.bookstore.domain.Mapper;


import com.ptit.ttcs.bookstore.domain.DTO.CreateUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.EditUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.GetUserDTO;
import com.ptit.ttcs.bookstore.domain.User;
import com.ptit.ttcs.bookstore.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {




    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    default GetUserDTO userToGetUserDTO(User user)
    {
        GetUserDTO getUserDTO = new GetUserDTO();
        getUserDTO.setEmail(user.getEmail());
        getUserDTO.setPhone(user.getPhone());
        getUserDTO.setAddress(user.getAddress());
        getUserDTO.setId(user.getId());
        getUserDTO.setAge(user.getAge());
        getUserDTO.setFullname(user.getFullname());
        getUserDTO.setGender(user.getGender());

        return getUserDTO;
    };



    User CreateUserDTOToUser(CreateUserDTO createUserDTO);

}
