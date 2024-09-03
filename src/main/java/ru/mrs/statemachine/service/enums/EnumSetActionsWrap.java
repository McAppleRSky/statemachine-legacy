package ru.mrs.statemachine.service.enums;

import java.util.EnumSet;

public class EnumSetActionsWrap {

    private final EnumSet<Actions> actions;

    public EnumSetActionsWrap(EnumSet<Actions> actions) {
        this.actions = actions;
    }

}
