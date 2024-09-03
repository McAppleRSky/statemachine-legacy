package ru.mrs.statemachine.service;

import ru.mrs.statemachine.service.enums.Actions;
import ru.mrs.statemachine.service.enums.States;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class MyObjectChecker {

    public static void check(MyObject myObject) throws Exception {
//        myObject instanceof
//        Class<? extends MyObject> aClass = myObject.getClass();
//        Class<MyObject> myObjectClass = MyObject.class;
        if (myObject != null && myObject instanceof MyObject) {
            return;
        } else {
            throw new Exception("Can't take My Object");
        }
    }

    public static void check(MyObject myObject, Actions action) throws Exception {

        Map<Object, EnumSet<States>> mapMyObjectStates = new HashMap<>();
        mapMyObjectStates.put(myObject.getClass(), EnumSet.allOf(States.class));
        Map<States, EnumSet<Actions>> mapStateActions = new HashMap<>();
        mapStateActions.put(States.NULL, EnumSet.of(Actions.CREATE));

        EnumSet<States> states = mapMyObjectStates.get(myObject.getClass());
        if (states.isEmpty()) {
            throw new Exception("States empty for My Object: " + myObject.getClass());
        }
        if (myObject.getCurrentState() == null) {
            throw new Exception("Current state is null");
        }
        if (!states.contains(myObject.getCurrentState())) {
            throw new Exception("Hasn't state: " + myObject.getCurrentState());
        }
        EnumSet<Actions> currentStateActions = mapStateActions.get(myObject.getCurrentState());
        if (currentStateActions.isEmpty()) {
            throw new Exception("Actions empty for State: " + currentStateActions + " My Object: " + myObject.getClass());
        }
        if (!currentStateActions.contains(action)) {
            throw new Exception("Hasn't action: " + action + " for State: " + currentStateActions + " My Object: " + myObject.getClass());
        }
    }

    public static void check(MyObject myObject, Actions currentAction, States stateTo) throws Exception {
        Map<Actions, EnumSet<States>> _mapActionStates = new HashMap<>();
        _mapActionStates.put(Actions.CREATE, EnumSet.of(States.DRAFT));
        Map<Object, Map<Actions, EnumSet<States>>> mapMyObjectStates = new HashMap<>();
        mapMyObjectStates.put(myObject.getClass(), _mapActionStates);

        Map<Actions, EnumSet<States>> mapActionStates = mapMyObjectStates.get(myObject.getClass());
        EnumSet<States> targetStates = mapActionStates.get(currentAction);
        if (targetStates == null) {
            throw new Exception("Target state is null");
        }
        if (targetStates.isEmpty()) {
            throw new Exception("Target state is empty");
        }
        if (!targetStates.contains(stateTo)) {
            throw new Exception("Hasn't action: " + currentAction + " to State: " + stateTo + " My Object: " + myObject.getClass());
        }
    }

}
