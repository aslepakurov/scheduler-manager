package ua.kpi.comsys.manager.domain;

/**
 * Request Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public class TaskRequest {
    private String id;
    private String text;

    public TaskRequest() {
    }

    public TaskRequest(String text) {
        this.text = text;
    }

    public TaskRequest(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}