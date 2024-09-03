package ru.mrs.statemachine.model.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Catalog {
    ACTION_FORM("actionform", "ActionForm", 100),
    BUDGET("budget", "Budget", 200),
    CATALOG("catalog", "Catalog", 300),
    CLASSIFICATION("clasification", "Clasification", 400),
    COMMON("common", "Common", 500),
    CONTRACT("contract", "Contract", 600),
    COST_ITEM("costitem", "CostItem", 700),
    DOCUMENT("document", "Document", 800),
    GEOGRAPHY("geography", "Geography", 900),
    GROUP("group", "Group", 1000),
    INTERMEDIATE("intermediate", "Intermediate", 1100),
    INTEGRATION("integration", "Integration", 1200),
    ITEM("item", "Item", 1300),
    LOCATION("location", "Location", 1400),
    MAIL("mail", "Mail", 1500),
    NAVIGATION("navigation", "Navigation", 1600),
    ORGANIZATION("organization", "Organization", 1700),
    PAYMENT("payment", "Payment", 1800),
    PEOPLE("people", "People", 1900),
    PORTAL("portal", "Portal", 2000),
    PROJECT("project", "Project", 2100),
    REQUEST("request", "Request", 2200),
    RISK("risk", "Risk", 2300),
    ROUTING("routing", "Routing", 2400),
    SETUP("setup", "Setup", 2500),
    SPECIFICATION("specification", "specification", 2600),
    SURVEY("survey", "Survey", 2700),
    SYSTEM("system", "System", 2800),
    TASK("task", "Task", 2900),
    TEMPLATE("template", "Template", 3000),
    TIME("time", "Time", 3100);

    private final String packageName;
    private final String name;
    private final Integer ord;

}
