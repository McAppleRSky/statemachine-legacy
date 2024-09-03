package ru.mrs.statemachine.model.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MyObject {

    ACTION_FORM("action_form", "ActionForm", "Action Form", 100_000),
    BUDGET("budget", "Budget", "Budget", 200_000),
    CATALOG("catalog", "Catalog", "Catalog", 300_000),
    CLASSIFICATION("clasification", "Clasification", "Clasification", 400_000),
    DS_TYPE("ds_type", "DSType", "DS Type", 500_000),
    PAYMENT_TYPE("payment_type", "PaymentType", "Payment Type", 600_000),
    PAY_PERIOD("pay_period", "PayPeriod", "Pay Period", 700_000),
    ROLE("role","Role", "Role", 800_000),
    STATUS("status", "Status", "Status", 900_000),
    COMMON("common", "Common", "Common", 1000_000),
    URL("url", "URL", "URL", 1100_000),
    EMAIL("email", "EMail", "EMail", 1200_000),
    EMAIL_("address", "Address", "Address", 1300_000),
    CONTRACT("contract", "Contract", "Contract", 1400_000),
    REAL_ESTATE_CONTRACT("my_rec", "myREC", "Договор аренды", 1500_000),
    LEASE_ABSTRACT("lease_abstract", "LeaseAbstract", "Lease Abstract", 1600_000),
    COST_ITEM("cost_item", "CostItem", "Cost Item", 1700_000),
    PAYMENT_LINE_ITEM("payment_line_item", "PaymentLineItem", "Payment Line Item", 1800_000),
    DOCUMENT("document", "Document", "Document", 1900_000),
    GEOGRAPHY("geography", "Geography", "Geography", 2000_000),
    GROUP("group", "Group", "Group", 2100_000),
    INTERMEDIATE("intermediate", "Intermediate", "Intermediate", 2200_000),
    CONTACT_ROLE("contact_role", "ContactRole", "Contact Role", 2300_000),
    RE_CONTRACT_LOCATIONS("my_recls", "myRECLs", "Площадь в договоре", 2400_000),
    INTEGRATION("integration", "Integration", "Integration", 2500_000),
    ITEM("item", "Item", "Item", 2600_000),
    OPTION("option", "Option", "Option", 2700_000),
    LEASE_CLAUSE("lease_clause", "LeaseClause", "Lease Clause", 2800_000),
    MY_DS("my_ds", "myDS", "Дополнительное соглашение", 2900_000),
    BILLS_RECEIVABLE("bills_receivable", "BillsReceivable", "Bills Receivable", 3000_000),
    DATA_ATTRIBUTE_ITEM("data_attribute_item", "DataAttributeItem", "Измерение площади", 3100_000),
    LOCATION("location", "Location", "Location", 3_200_000),
    SPACE("space", "Space", "Space", 3300_000),
    BUILDING("building", "Building", "Building", 3_400_000),
    FLOOR("floor", "Floor", "Floor", 3500_000),
    LAND("land", "Land", "Land", 3600_000),
    MAIL("mail", "Mail", "Mail", 3700_000),
    EMAIL_MESSAGE("email_message", "EmailMessage", "Email Message", 3800_000),
    EMAIL_ADDRESS("email_address","EmailAddress", "Email Address", 3900_000),
    NAVIGATION("navigation", "Navigation", "Navigation", 4000_000),
    ORGANIZATION("organization", "Organization", "Organization", 4100_000),
    PAYMENT("payment", "Payment", "Payment", 4200_000),
    PAYMENT_SCHEDULE("payment_schedule", "PaymentSchedule", "Payment Schedule", 4300_000),
    PEOPLE("people", "People", "People", 4400_000),
    PORTAL("portal", "Portal","Portal", 4500_000),
    PROJECT("project", "Project", "Project", 4600_000),
    REQUEST("request", "Request", "Request", 4700_000),
    RISK("risk", "Risk", "Risk", 4800_000),
    ROUTING("routing", "Routing", "Routing", 4900_000),
    APPROVAL("approval", "Approval", "Approval", 5000_000),
    SETUP("setup", "Setup", "Setup", 5100_000),
    USER_MESSAGE("user_message", "UserMessage", "User Message", 5200_000),
    CRON_TASK_ITEM("cron_task_item", "CronTaskItem", "Cron Task Item", 5300_000),
    CRON_TASK("cron_task", "CronTask", "Cron Task", 5400_000),
    SPECIFICATION("specification", "Specification", "Specification", 5500_000),
    SURVEY("survey", "Survey", "Survey", 5600_000),
    SYSTEM("system", "System", "System", 5700_000),
    LIST("list", "List", "List", 5800_000),
    TASK("task", "Task", "Task", 5900_000),
    TEMPLATE("template", "Template", "Template", 6000_000),
    TIME("time", "Time", "Time", 6100_000);

    private final String table;
    private final String name;
    private final String label;
    private final int ord;

}
