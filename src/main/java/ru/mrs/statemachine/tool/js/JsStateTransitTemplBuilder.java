package ru.mrs.statemachine.tool.js;

import java.util.List;
import java.util.Map;

public interface JsStateTransitTemplBuilder {

    JsStateTransitTemplBuilder setStates(List<Map<String, String>> states);

    Map<String, List> setStateTransAndBuild(List<Map<String, Object>> trans);
}
