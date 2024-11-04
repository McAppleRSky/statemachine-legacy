package ru.mrs.statemachine.tool.js;

import org.apache.commons.lang3.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsStateTransitTemplBuilderImpl implements JsStateTransitTemplBuilder {

    private final Map<String, List> resultMap;
    private int transSize;
    private String[] states;
//    private List<Map<String, String>> states;

    private Map getCaption (String woName) {
        Map result = new LinkedHashMap();
        result.put("caption", String.format("State transition mapping for work object : %s", woName));
        return result;
    }

    public JsStateTransitTemplBuilderImpl(String woName) {
        String[] resultMapKeys = {"caption", "head", "body"};
        resultMap = getCaption(woName);
        for (int i = 1; i < resultMapKeys.length; i++) {
            resultMap.put(resultMapKeys[i], null);
        }
    }

    @Override
    public JsStateTransitTemplBuilder setStates(List<Map<String, String>> stateMap) {
        this.states = new String[stateMap.size()];
        LinkedHashMap<String, Object> rowHead = new LinkedHashMap<>();
        rowHead.put("rowh", Collections.singletonList(
                Collections.singletonMap("column", Collections.nCopies(this.states.length * 2, new HashMap())) ));
        List<Map<String, Object>> states = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4).collect(Collectors.toList());
        for (int i = 0; i < this.states.length; i++) {
            Map<String, Object> state = states.get(i);
            this.states[i] = stateMap.get(i).get("WO_STATE");
            state.put("title", this.states[i]);
            state.put("colSpan", 2);
        }
        rowHead.put("rowd", Collections.singletonList(Collections.singletonMap("state", states)));
        resultMap.put("head", Collections.singletonList(rowHead));
        return this;
    }

    @Override
    public Map<String, List> setStateTransAndBuild(List<Map<String, Object>> trans) {
        this.transSize = trans.size();
        List<Map<String, List>> bodies = Stream.generate(LinkedHashMap<String, List>::new)
                .limit(transSize).collect(Collectors.toList());
        for (int i = 0; i < bodies.size(); i++) {
            Integer from = null, to = null, firstState = null;
            int span = 2;
            Map<String, Object> transit = trans.get(i);
            Object curState = transit.get("CURRENT_STATE"),
                    nextState = transit.get("NEXT_STATE"),
                    transitTitle = transit.get("TITLE"),
                    transitDescription = transit.get("DESCRIPTION");
            for (int j = 0; j < this.states.length; j++) {
                if (states[j].equals(curState)) {
                    from = j;
                }
                if (states[j].equals(nextState)) {
                    to = j;
                }
            }
            if (from == null || to == null ) {
                throw new NotImplementedException("No state");
            } else {
                if (to - from > 1) {
                    span = (to - from) * 2;
                }
                if (from <= to) {
                    firstState = from;
                } else {
                    firstState = to;
                }
            }
            List<Map<String, Object>> cellArrows = Stream.generate(LinkedHashMap<String, Object>::new)
                    .limit(this.states.length * 2 - (span - 1)).collect(Collectors.toList());
            boolean borderRight = true;
            for (int kCell = 0, kState = -1, k0 = -1; kCell < cellArrows.size(); kCell++,
                    k0 = ((kCell & 1) == 0) ? k0 : (kCell == 1 ? 0 : k0 + 1), kState = ((kCell & 1) == 0) ? -1 : k0) {
                if (kState == firstState) {
                    cellArrows.get(kCell).put("arrow", Arrays.asList(new String[]{curState.toString(), nextState.toString()}));
                    cellArrows.get(kCell).put("colSpan", span);
                    if (i == 0){
                        cellArrows.get(kCell).put("borderLeft", true);
                        cellArrows.get(kCell).put("borderRight", true);
                    }
                    cellArrows.get(kCell).put("canvas", true);
                } else {
                    if (borderRight) {
                        cellArrows.get(kCell).put("borderRight", true);
                        borderRight = false;
                    } else {
                        cellArrows.get(kCell).put("borderLeft", true);
                        borderRight = true;
                    }
                    if (kCell == 0) {
                        cellArrows.get(0).put("isFirstCell", true);
                    }
                }
            }
            bodies.get(i).put("rowArrow", Collections.singletonList(
                    Collections.singletonMap("cellArrow", cellArrows) ));
            List<Map<String, Object>> cellTitles = Stream.generate(LinkedHashMap<String, Object>::new)
                    .limit(this.states.length * 2 - 1).collect(Collectors.toList());
            borderRight = true;
            span = 2;
            for (int lCell = 0, lState = -1, k0 = -1; lCell < cellTitles.size(); lCell++,
                    k0 = ((lCell & 1) == 0) ? k0 : (lCell == 1 ? 0 : k0 + 1), lState = ((lCell & 1) == 0) ? -1 : k0) {
                if (lState == firstState) {
                    cellTitles.get(lCell).put("title", transitTitle);
                    cellTitles.get(lCell).put("colSpan", span);
                } else {
                    if (borderRight) {
                        cellTitles.get(lCell).put("borderRight", true);
                        borderRight = false;
                    } else {
                        cellTitles.get(lCell).put("borderLeft", true);
                        borderRight = true;
                    }
                    if (lCell == 0) {
                        cellTitles.get(0).put("isFirstCell", true);
                    }
                }
            }
            bodies.get(i).put("rowTitle", Collections.singletonList(
                    Collections.singletonMap("cellTitle", cellTitles) ));
            List<Map<String, Object>> cellDescs = Stream.generate(LinkedHashMap<String, Object>::new)
                    .limit(this.states.length * 2 - 1).collect(Collectors.toList());
            borderRight = true;
            for (int mCell = 0, mState = -1, k0 = -1; mCell < cellDescs.size(); mCell++,
                    k0 = ((mCell & 1) == 0) ? k0 : (mCell == 1 ? 0 : k0 + 1), mState = ((mCell & 1) == 0) ? -1 : k0) {
                if (mState == firstState) {
                    cellDescs.get(mCell).put("description", transitDescription);
                    cellDescs.get(mCell).put("colSpan", span);
                } else {
                    if (borderRight) {
                        cellDescs.get(mCell).put("borderRight", true);
                        borderRight = false;
                    } else {
                        cellDescs.get(mCell).put("borderLeft", true);
                        borderRight = true;
                    }
                    if (mCell == 0) {
                        cellDescs.get(0).put("isFirstCell", true);
                    }
                }
            }
            bodies.get(i).put("rowDesc", Collections.singletonList(
                    Collections.singletonMap("cellDesc", cellDescs) ));
        }
        this.resultMap.put("body", bodies);
        return resultMap;
    }

}
