package ru.mrs.statemachine.service;

import org.junit.jupiter.api.Test;
import ru.mrs.statemachine.service.enums.Actions;
import ru.mrs.statemachine.service.enums.States;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatemachineServiceTest {

    private MyObjectService myObjectService = new MyObjectServiceImpl();

    @Test
    void test0() {
        MyObject myObject0 = new MyObjectImpl();
        MyObject myObject1 = myObjectService
                .takeFrom(myObject0)
                .actionFromCurrent(Actions.CREATE)
                .toState(States.DRAFT)
                .transitTo();
        assertEquals(myObject1.getCurrentState(), States.DRAFT);
    }

}
