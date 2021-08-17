package com.erayt.web01.batch.processor;

import com.erayt.web01.domain.Person;
import org.springframework.batch.item.ItemProcessor;

import java.util.Locale;

/**
 * @Auther: Z151
 * @Date: 2021/8/17 21:15
 */
public class PersonProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        String firstName = "!" + person.getFirstName().toUpperCase(Locale.ROOT)+"!";
        String lastName = " @" + person.getLastName().toUpperCase(Locale.ROOT)+"@";
        Person result = new Person(firstName,lastName);
        System.out.println(String.format("this is PersonProcessor.process method,convert %s to %s",person.toString(),result.toString()));
        return result;
    }
}
