package ru.mrs.statemachine.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;
//import ru.mrs.statemachine.configuration.Events;
//import ru.mrs.statemachine.configuration.States;

@Slf4j
@Component
public class Runner implements CommandLineRunner {

//    @Autowired private StateMachine stateMachine;

    @Override
    public void run(String... args) throws Exception {
        log.info("In CommandLine Runner");
    }

}
