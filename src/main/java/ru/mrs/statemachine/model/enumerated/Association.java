package ru.mrs.statemachine.model.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Association {

    HAS("Has"),
    IS("Is");

    private final String name;

}
