package ru.mrs.statemachine.service;

import ru.mrs.statemachine.service.enums.Actions;
import ru.mrs.statemachine.service.enums.States;

public class MyObjectWrapImpl implements MyObjectWrapStateTransitable, MyObjectWrapActionable, MyObjectWrapStatable {

    private final MyObject myObject;

//    private final EnumSet<States> states = EnumSet.allOf(States.class);
//    private final EnumSet<Actions> actions = EnumSet.allOf(Actions.class);

    private Actions doAction;
    private States toState;

    public MyObjectWrapImpl(MyObject myObject) {
        try {
            MyObjectChecker.check(myObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.myObject = myObject;
    }

    public MyObjectWrapStatable actionFromCurrent(Actions action) {
        try {
            MyObjectChecker.check(myObject, action);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.doAction = action;
        return this;
    }

    @Override
    public MyObjectWrapStateTransitable toState(States state) {
        try {
            MyObjectChecker.check(this.myObject, this.doAction, state);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.toState = state;
        return this;
    }

    @Override
    public MyObject transitTo() {
        return this.myObject.transitToState(this.toState);
    }

/*    @Override
    public States getState() {
        return this.myObject.getCurrentState();
    }*/
}
