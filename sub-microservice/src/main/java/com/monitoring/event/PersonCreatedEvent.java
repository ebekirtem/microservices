package com.monitoring.event;

import com.monitoring.domain.Person;


public record PersonCreatedEvent(Person person) {

}
