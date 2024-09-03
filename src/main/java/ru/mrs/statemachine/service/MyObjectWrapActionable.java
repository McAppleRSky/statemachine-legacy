package ru.mrs.statemachine.service;

import ru.mrs.statemachine.service.enums.Actions;

public interface MyObjectWrapActionable {

    MyObjectWrapStatable actionFromCurrent(Actions actions);

}
