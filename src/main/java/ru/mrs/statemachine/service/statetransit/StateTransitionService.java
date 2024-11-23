package ru.mrs.statemachine.service.statetransit;

import java.util.List;
import java.util.Map;

public interface StateTransitionService {

    Map<String, List> getByWoName(String woName);

}
