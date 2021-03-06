package ua.kpi.comsys.manager.domain;

/**
 * TaskConfigurationType Class
 *
 * @author aslepakurov
 * @version 01/15/2016
 */
public enum TaskConfigurationType {
    PBS("pbs"),
    BSUB("bsub"),
    LEGION("legion"),
    SBATCH("sbatch");

    private String name;

    TaskConfigurationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TaskConfigurationType getType(String type) {
        for (TaskConfigurationType taskConfigurationType : values()) {
            if (taskConfigurationType.getName().equalsIgnoreCase(type)) {
                return taskConfigurationType;
            }
        }
        return null;
    }
}
