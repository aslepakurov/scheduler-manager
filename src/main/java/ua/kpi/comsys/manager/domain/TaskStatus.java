package ua.kpi.comsys.manager.domain;

/**
 * TaskStatus Class
 *
 * @author aslepakurov
 * @version 01/15/2016
 */
public enum TaskStatus {
    SUBMITED("submited"),
    RESOLVED("resolved"),
    PROCESSING("processing"),
    COMPLETED("completed"),
    ERROR("error");

    private String name;

    TaskStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
