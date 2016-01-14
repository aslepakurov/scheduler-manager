package ua.kpi.comsys.manager.domain;

/**
 * TaskConfiguration Class
 *
 * @author aslepakurov
 * @version 01/15/2016
 */
public class TaskConfiguration {
    private String id;
    private String name;
    private String description;
    private String script;
    private TaskConfigurationType type;

    public TaskConfiguration() {
    }

    public TaskConfiguration(String name, String description, TaskConfigurationType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskConfigurationType getType() {
        return type;
    }

    public void setType(TaskConfigurationType type) {
        this.type = type;
    }
}
