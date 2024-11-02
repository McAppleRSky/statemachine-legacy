package ru.mrs.statemachine.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonBuildTest {

    private String getClassPathJs(String filename) {
        String result = null;
        try (
                InputStream stateTransitJsStream = JsonBuildTest.class.getClassLoader()
                        .getResourceAsStream(filename);
                InputStreamReader stateTransitJsStreamReader = new InputStreamReader(stateTransitJsStream);
                BufferedReader stateTransitJsReader = new BufferedReader(stateTransitJsStreamReader) ) {
            result = stateTransitJsReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private String getClassJs(Map object) {
        String result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(object);
            System.out.println();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Test
    void getJsTest() {
        assertNotNull(getClassPathJs("state-transit_min.json"));
        assertNotNull(getClassJs(new HashMap<>()));
    }

    @Test
    void getClassJsTemplTest() {
        Map<String, Object> StObject = new LinkedHashMap<>();
        StObject.put("caption", "State transition mapping for work object : wSpace");
        LinkedHashMap<String, Object> rowHead = new LinkedHashMap<>();
        rowHead.put("rowh", Collections.singletonList(
                        Collections.singletonMap("column", Collections.nCopies(8, new HashMap())) ));
        List<Map<String, Object>> states = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4).collect(Collectors.toList());
        states.get(0).put("title", "NULL");
        states.get(0).put("colSpan", 2);
        states.get(1).put("title", "wDraft");
        states.get(1).put("colSpan", 2);
        states.get(2).put("title", "wActive");
        states.get(2).put("colSpan", 2);
        states.get(3).put("title", "wRetired");
        states.get(3).put("colSpan", 2);
        rowHead.put("rowd", Collections.singletonList(Collections.singletonMap("state", states)));
        StObject.put("head", Collections.singletonList(rowHead));
        List<Map<String, List>> bodies3 = Stream.generate(LinkedHashMap<String, List>::new)
                .limit(3).collect(Collectors.toList());
        List<Map<String, Object>> cellArrows1 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-1).collect(Collectors.toList());
        cellArrows1.get(0).put("borderRight", true);
        cellArrows1.get(0).put("isFirstCell", true);
        cellArrows1.get(1).put("arrow", Arrays.asList(new String[]{"NULL", "wDraft"}));
        cellArrows1.get(1).put("colSpan", 2);
        cellArrows1.get(1).put("borderLeft", true);
        cellArrows1.get(1).put("borderRight", true);
        cellArrows1.get(1).put("canvas", true);
        cellArrows1.get(2).put("borderLeft", true);
        cellArrows1.get(3).put("borderRight", true);
        cellArrows1.get(4).put("borderLeft", true);
        cellArrows1.get(5).put("borderRight", true);
        cellArrows1.get(6).put("borderLeft", true);
        bodies3.get(0).put("rowArrow", Collections.singletonList(
                Collections.singletonMap("cellArrow", cellArrows1) ));
        List<Map<String, Object>> cellTitles1 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-1).collect(Collectors.toList());
        cellTitles1.get(0).put("borderRight", true);
        cellTitles1.get(0).put("isFirstCell", true);
        cellTitles1.get(1).put("title", "wCreateDraft");
        cellTitles1.get(1).put("colSpan", 2);
        cellTitles1.get(2).put("borderLeft", true);
        cellTitles1.get(3).put("borderRight", true);
        cellTitles1.get(4).put("borderLeft", true);
        cellTitles1.get(5).put("borderRight", true);
        cellTitles1.get(6).put("borderLeft", true);
        bodies3.get(0).put("rowTitle", Collections.singletonList(
                Collections.singletonMap("cellTitle", cellTitles1) ));
        List<Map<String, Object>> cellDescs1 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(8-1).collect(Collectors.toList());
        cellDescs1.get(0).put("borderRight", true);
        cellDescs1.get(0).put("isFirstCell", true);
        cellDescs1.get(1).put("description", "a\nb");
        cellDescs1.get(1).put("colSpan", 2);
        cellDescs1.get(2).put("borderLeft", true);
        cellDescs1.get(3).put("borderRight", true);
        cellDescs1.get(4).put("borderLeft", true);
        cellDescs1.get(5).put("borderRight", true);
        cellDescs1.get(6).put("borderLeft", true);
        bodies3.get(0).put("rowDesc", Collections.singletonList(
                Collections.singletonMap("cellDesc", cellDescs1)));
        List<Map<String, Object>> cellArrows2 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-1).collect(Collectors.toList());
        cellArrows2.get(0).put("borderRight", true);
        cellArrows2.get(0).put("isFirstCell", true);
        cellArrows2.get(1).put("borderLeft", true);
        cellArrows2.get(2).put("borderRight", true);
        cellArrows2.get(3).put("arrow", Arrays.asList(new String[]{"wDraft", "wDraft"}));
        cellArrows2.get(3).put("colSpan", 2);
        cellArrows2.get(3).put("canvas", true);
        cellArrows2.get(4).put("borderLeft", true);
        cellArrows2.get(5).put("borderRight", true);
        cellArrows2.get(6).put("borderLeft", true);
        bodies3.get(1).put("rowArrow", Collections.singletonList(
                Collections.singletonMap("cellArrow", cellArrows2) ));
        List<Map<String, Object>> cellTitles2 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-1).collect(Collectors.toList());
        cellTitles2.get(0).put("borderRight", true);
        cellTitles2.get(0).put("isFirstCell", true);
        cellTitles2.get(1).put("borderLeft", true);
        cellTitles2.get(2).put("borderRight", true);
        cellTitles2.get(3).put("title", "wAction");
        cellTitles2.get(3).put("colSpan", 2);
        cellTitles2.get(4).put("borderLeft", true);
        cellTitles2.get(5).put("borderRight", true);
        cellTitles2.get(6).put("borderLeft", true);
        bodies3.get(1).put("rowTitle", Collections.singletonList(
                Collections.singletonMap("cellTitle", cellTitles2) ));
        List<Map<String, Object>> cellDescs2 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-1).collect(Collectors.toList());
        cellDescs2.get(0).put("borderRight", true);
        cellDescs2.get(0).put("isFirstCell", true);
        cellDescs2.get(1).put("borderLeft", true);
        cellDescs2.get(2).put("borderRight", true);
        cellDescs2.get(3).put("description", "ab\nbc");
        cellDescs2.get(3).put("colSpan", 2);
        cellDescs2.get(4).put("borderLeft", true);
        cellDescs2.get(5).put("borderRight", true);
        cellDescs2.get(6).put("borderLeft", true);
        bodies3.get(1).put("rowDesc", Collections.singletonList(
                Collections.singletonMap("cellDesc", cellDescs2)));
        List<Map<String, Object>> cellArrows3 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-3).collect(Collectors.toList());
        cellArrows3.get(0).put("borderRight", true);
        cellArrows3.get(0).put("isFirstCell", true);
        cellArrows3.get(1).put("borderLeft", true);
        cellArrows3.get(2).put("borderRight", true);
        cellArrows3.get(3).put("arrow", Arrays.asList(new String[]{"wDraft", "wRetired"}));
        cellArrows3.get(3).put("colSpan", 4);
        cellArrows3.get(3).put("canvas", true);
        cellArrows3.get(4).put("borderLeft", true);
        bodies3.get(2).put("rowArrow", Collections.singletonList(
                Collections.singletonMap("cellArrow", cellArrows3) ));
        List<Map<String, Object>> cellTitles3 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-1).collect(Collectors.toList());
        cellTitles3.get(0).put("borderRight", true);
        cellTitles3.get(0).put("isFirstCell", true);
        cellTitles3.get(1).put("borderLeft", true);
        cellTitles3.get(2).put("borderRight", true);
        cellTitles3.get(3).put("title", "wRetire");
        cellTitles3.get(3).put("colSpan", 2);
        cellTitles3.get(4).put("borderLeft", true);
        cellTitles3.get(5).put("borderRight", true);
        cellTitles3.get(6).put("borderLeft", true);
        bodies3.get(2).put("rowTitle", Collections.singletonList(
                Collections.singletonMap("cellTitle", cellTitles3) ));
        List<Map<String, Object>> cellDescs3 = Stream.generate(LinkedHashMap<String, Object>::new)
                .limit(4*2-1).collect(Collectors.toList());
        cellDescs3.get(0).put("borderRight", true);
        cellDescs3.get(0).put("isFirstCell", true);
        cellDescs3.get(1).put("borderLeft", true);
        cellDescs3.get(2).put("borderRight", true);
        cellDescs3.get(3).put("description", "abc\nxyz");
        cellDescs3.get(3).put("colSpan", 2);
        cellDescs3.get(4).put("borderLeft", true);
        cellDescs3.get(5).put("borderRight", true);
        cellDescs3.get(6).put("borderLeft", true);
        bodies3.get(2).put("rowDesc", Collections.singletonList(
                Collections.singletonMap("cellDesc", cellDescs3)));
        StObject.put("body", bodies3);
        String expected = getClassPathJs("state-transit_min.json"),
                ___actual = getClassJs(StObject);
//        String difference = StringUtils.difference(expected, ___actual);
        assertEquals(expected, ___actual);
    }

}
