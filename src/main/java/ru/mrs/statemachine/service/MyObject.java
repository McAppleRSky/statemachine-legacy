package ru.mrs.statemachine.service;

import ru.mrs.statemachine.service.enums.Actions;
import ru.mrs.statemachine.service.enums.States;

public interface MyObject {

    States getCurrentState();

//    Actions getCurrentAction();

    MyObject transitToState(States toState);

//    States getState();
}
