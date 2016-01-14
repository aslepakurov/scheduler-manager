package ua.kpi.comsys.manager.domain.rest;

/**
 * TaskRequestRestResponse Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public class TaskRestResponse {
    private String text;

    public TaskRestResponse() {
    }

    public TaskRestResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
