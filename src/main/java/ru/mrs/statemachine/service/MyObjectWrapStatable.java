package ru.mrs.statemachine.service;

import ru.mrs.statemachine.service.enums.States;

public interface MyObjectWrapStatable {

    MyObjectWrapStateTransitable toState(States state);

}
