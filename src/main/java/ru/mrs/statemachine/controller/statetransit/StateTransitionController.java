package ru.mrs.statemachine.controller.statetransit;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.*;
import ru.mrs.statemachine.service.statetransit.StateTransitionService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class StateTransitionController {

    private final StateTransitionService stateTransitionService;

    @RequestMapping(value="/statetransit/v0/{woName}", method= RequestMethod.GET)
    @ResponseBody
    public Map<String, List> stateTransit(@PathVariable Map<String, String> woName) {
        Map<String, List> result = null;
        switch (woName.get("woName")) {
            case "wSpace":
                throw new NotImplementedException("woName - wSpace");
            case "wPeople":
                result = //Collections.singletonMap("content", Collections.singletonList(Collections.singletonMap("caption", "State transition mapping for work object : wSpace")))
                        this.stateTransitionService.getByWoName(woName.get("woName"))
                ;
        }
        return result;
    }

}
