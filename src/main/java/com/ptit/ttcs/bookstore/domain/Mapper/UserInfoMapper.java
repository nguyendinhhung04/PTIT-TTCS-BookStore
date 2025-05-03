package com.ptit.ttcs.bookstore.domain.Mapper;


import com.ptit.ttcs.bookstore.domain.DTO.CreateUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.GetUserDTO;
import com.ptit.ttcs.bookstore.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    GetUserDTO userToGetUserDTO(User user);

    User CreateUserDTOToUser(CreateUserDTO createUserDTO);

}
