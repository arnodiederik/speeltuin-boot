package org.speeltuin.speeltuindata.app.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.speeltuin.speeltuindata.app.dto.PersonDto;
import org.speeltuin.speeltuindata.app.entity.Person;

public class PersonMapperTest {
    @Test
    public void testMapper() {
        Person person = new Person();
        person.setId(1L);
        person.setName("Duck");
        person.setFirstName("Donald");

        PersonDto personDto = new PersonDto();

        final ModelMapper personModelMapper = ModelMapperUtil.getPersonModelMapper();
        personModelMapper.map(person, personDto);

        Assertions.assertEquals("","Duick", personDto.getName());
    }
}
