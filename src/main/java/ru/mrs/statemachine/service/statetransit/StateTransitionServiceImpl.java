package ru.mrs.statemachine.service.statetransit;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.mrs.statemachine.service.statetransit.js.JsStateTransitTemplBuilderImpl;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class StateTransitionServiceImpl implements StateTransitionService {

    private final DataSource dataSource;

    @Override
    public Map<String, List> getByWoName(String woName) {
        Map<String, List> result = Collections.emptyMap();
        JsStateTransitTemplBuilderImpl builder = new JsStateTransitTemplBuilderImpl(woName);
        /*JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        builder.setStates(jdbcTemplate.queryForList("SELECT s.wo_state FROM s_state s WHERE s.wo_name = ? ", woName));
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM s_state_transit s WHERE s.wo_name = ? ", woName);
        Map<String, List> stringListMap = builder.setStateTransAndBuild(jdbcTemplate.queryForList("SELECT * FROM s_state_transit s WHERE s.wo_name = ? ", woName));*/
        result = new JsStateTransitTemplBuilderImpl(woName)
                .setStates(
                        new JdbcTemplate(dataSource)
                                .queryForList("SELECT s.wo_state FROM s_state s WHERE s.wo_name = ? ", woName) )
                .setStateTransAndBuild(
                        new JdbcTemplate(dataSource)
                                .queryForList("SELECT * FROM s_state_transit s WHERE s.wo_name = ? ", woName) );
//        result = stringListMap;
        return result;
    }

}
