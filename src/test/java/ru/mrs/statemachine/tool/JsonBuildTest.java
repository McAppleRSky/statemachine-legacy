package ru.mrs.statemachine.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.mrs.statemachine.tool.js.JsStateTransitTemplBuilder;
import ru.mrs.statemachine.tool.js.JsStateTransitTemplBuilderImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        Map<String, Object> wObject = new LinkedHashMap<>();
        wObject.put("caption", "State transition mapping for work object : wSpace");
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
        wObject.put("head", Collections.singletonList(rowHead));
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
        wObject.put("body", bodies3);
        String expected = getClassPathJs("state-transit_min.json"),
                ___actual = getClassJs(wObject);
//        String difference = StringUtils.difference(expected, ___actual);
        assertEquals(expected, ___actual);
    }

    void setDb() {
        try {
            Class.forName ("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1", "sa", "");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("" +
                    "CREATE TABLE s_state ( " +
                    "    id bigint generated by default as identity, " +
                    "    wo_name varchar(100) not null, " +
                    "    wo_state varchar(100) not null, " +
                    "    primary key (id) ) ");
            statement.executeUpdate("" +
                    "CREATE TABLE s_state_transition ( " +
                    "    id bigint generated by default as identity, " +
                    "    wo_name varchar(100) not null, " +
                    "    current_state varchar(100) not null, " +
                    "    next_state varchar(100) not null, " +
                    "    title varchar(100) not null, " +
                    "    description varchar(100), " +
                    "    primary key (id) ) ");
            try (PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "INSERT INTO s_state(wo_name, wo_state) VALUES (?, ?)")) {
                String[] param = new String[]{"NULL","wDraft","wActive","wRetired"};
                for (int i = 0; i < param.length; i++) {
                    preparedStatement.setString(1, "wSpace");
                    preparedStatement.setString(2, param[i]);
                    preparedStatement.executeUpdate();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "INSERT INTO s_state_transition (wo_name, current_state, next_state, title, description) " +
                    "     VALUES (?, ?, ? , ?, ?)")) {
                String[][] param = {
                        {"wSpace", "NULL", "wDraft", "wCreateDraft", "a\nb"},
                        {"wSpace", "wDraft", "wDraft", "wAction", "ab\nbc"},
                        {"wSpace", "wDraft", "wRetired", "wRetire", "abc\nxyz"} };
                for (int i = 0; i < param.length; i++) {
                    for (int j = 0; j < param[i].length; j++) {
                        preparedStatement.setString(j+1, param[i][j]);
                    }
                    preparedStatement.executeUpdate();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void dbTest () {
        setDb();
        int actualStateCount = Integer.MIN_VALUE, actualStateTransitionCount = Integer.MIN_VALUE;
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1", "sa", "");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(id) cnt FROM s_state ");
            if (resultSet.next()) {
                actualStateCount = resultSet.getInt("cnt");
            }
            resultSet = statement.executeQuery("SELECT COUNT(id) cnt FROM s_state_transition ");
            if (resultSet.next()) {
                actualStateTransitionCount = resultSet.getInt("cnt");
            }
            System.out.println();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals(4, actualStateCount);
        assertEquals(3, actualStateTransitionCount);
    }

//    @Test
    void dbStateTransitionTest () {
        setDb();
        int actualStateCount = Integer.MIN_VALUE, actualStateTransitionCount = Integer.MIN_VALUE;
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1", "sa", "");
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(id) cnt FROM s_state ");
            if (resultSet.next()) {
                actualStateCount = resultSet.getInt("cnt");
            }
            resultSet = statement.executeQuery("SELECT COUNT(id) cnt FROM s_state_transition ");
            if (resultSet.next()) {
                actualStateTransitionCount = resultSet.getInt("cnt");
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals(4, actualStateCount);
        assertEquals(3, actualStateTransitionCount);
    }

    DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    List getStatesByWoName(String woName) {
        return new JdbcTemplate(getDataSource())
                .queryForList("SELECT s.wo_state FROM s_state s WHERE s.wo_name = ? ", woName);
    }

    List<Map<String, Object>> getStateTransByWoName(String woName) {
        return new JdbcTemplate(getDataSource())
                .queryForList("SELECT * FROM s_state_transition s WHERE s.wo_name = ? ", woName);
    }

    @Test
    void test0() {
        setDb();
        String woName = "wSpace";
        String expected = getClassPathJs("state-transit_min.json"),
                ___actual = getClassJs(new JsStateTransitTemplBuilderImpl(woName)
                        .setStates(getStatesByWoName(woName))
                        .setStateTransAndBuild(getStateTransByWoName(woName)));
        String difference = StringUtils.difference(expected, ___actual);
        assertEquals(expected, ___actual);
    }

//    @Test
    void oddEven() {
        for (int i = 0; i < 3; i++) {
            if ((i & 1) == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd"); //нечет
            }
        }
    }

}
