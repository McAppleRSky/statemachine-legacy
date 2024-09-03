package ru.mrs.statemachine.service;

import ru.mrs.statemachine.service.enums.Actions;
import ru.mrs.statemachine.service.enums.EnumSetActionsWrap;
import ru.mrs.statemachine.service.enums.States;

import java.util.EnumSet;

public class MyObjectImpl implements MyObject {

    private States state = States.NULL;

    @Override
    public States getCurrentState() {
        return this.state;
    }

    @Override
    public MyObject transitToState(States state) {
        this.state = state;
        return this;
    }

}
