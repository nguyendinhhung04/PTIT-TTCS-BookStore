package com.ptit.ttcs.bookstore.domain.Mapper;

import com.ptit.ttcs.bookstore.domain.DTO.Publisher.PublisherDTO;
import com.ptit.ttcs.bookstore.domain.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    default Publisher toPublisher(PublisherDTO publisherDTO) {
        if (publisherDTO == null) {
            return null;
        }

        Publisher publisher = new Publisher();
        publisher.setId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        publisher.setBooks(publisherDTO.getBooks());
        return publisher;
    }

    default PublisherDTO toDTO(Publisher publisher) {
        if (publisher == null) {
            return null;
        }

        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setId(publisher.getId());
        publisherDTO.setName(publisher.getName());
        publisherDTO.setBooks(publisher.getBooks());
        return publisherDTO;
    }

}
