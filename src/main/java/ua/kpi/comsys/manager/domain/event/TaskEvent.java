package ua.kpi.comsys.manager.domain.event;

/**
 * TaskEvent Class
 *
 * @author aslepakurov
 * @version 01/21/2016
 */
public class TaskEvent {
    private String id;

    public TaskEvent() {
    }

    public TaskEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
