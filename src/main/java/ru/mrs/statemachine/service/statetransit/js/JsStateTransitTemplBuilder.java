package ru.mrs.statemachine.service.statetransit.js;

import java.util.List;
import java.util.Map;

public interface JsStateTransitTemplBuilder {

    JsStateTransitTemplBuilder setStates(List<Map<String, Object>> states);

    Map<String, List> setStateTransAndBuild(List<Map<String, Object>> trans);
}
