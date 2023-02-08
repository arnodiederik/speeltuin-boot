package org.speeltuin.speeltuindata.app.util;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.speeltuin.speeltuindata.app.dto.PersonDto;
import org.speeltuin.speeltuindata.app.entity.Person;

public class ModelMapperUtil {

    public static ModelMapper getPersonModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new AbstractConverter<Person, PersonDto>() {
            @Override
            protected PersonDto convert(Person person) {
                PersonDto personDto = new PersonDto();
                personDto.setId(personDto.getId());
                personDto.setName(person.getName());
                return personDto;
            }
        });
        return modelMapper;
    }
}
