package ua.kpi.comsys.manager.domain;

import java.time.LocalDateTime;

/**
 * Request Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public class Task {
    private String id;
    private String name;
    private String description;
    private TaskConfiguration configuration;
    private LocalDateTime creationDate;
    private LocalDateTime completeDate;
    private TaskStatus status;
    private String preRunScript;
    private String postRunScript;

    public Task() {
    }

    public Task(String name, String description, TaskConfiguration configuration, String preRunScript, String postRunScript) {
        this.name = name;
        this.description = description;
        this.configuration = configuration;
        this.creationDate = LocalDateTime.now();
        this.status = TaskStatus.SUBMITED;
        this.preRunScript = preRunScript;
        this.postRunScript = postRunScript;
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

    public TaskConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TaskConfiguration configuration) {
        this.configuration = configuration;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(LocalDateTime completeDate) {
        this.completeDate = completeDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getPreRunScript() {
        return preRunScript;
    }

    public void setPreRunScript(String preRunScript) {
        this.preRunScript = preRunScript;
    }

    public String getPostRunScript() {
        return postRunScript;
    }

    public void setPostRunScript(String postRunScript) {
        this.postRunScript = postRunScript;
    }
}