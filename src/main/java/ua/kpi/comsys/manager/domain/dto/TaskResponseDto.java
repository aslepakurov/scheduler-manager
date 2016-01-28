package ua.kpi.comsys.manager.domain.dto;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.TaskConfigurationType;
import ua.kpi.comsys.manager.domain.TaskStatus;

import java.io.Serializable;

/**
 * TaskResponseDto Class
 *
 * @author aslepakurov
 * @version 01/29/2016
 */
public class TaskResponseDto implements Serializable {
    private String name;
    private String description;
    private int nodes;
    private int cores;
    private int gpu;
    private String walltime;
    private int tasksPerNode;
    private String account;
    private int tasks;
    private String logFilePath;
    private String errorFilePath;
    private boolean exclusive;
    private String email;
    private boolean abortedEmail;
    private boolean beginEmail;
    private boolean endEmail;
//    private String creationDate;
//    private String completeDate;
    private String status;
    private String preRunScript;
    private String postRunScript;
    private String type;

    public TaskResponseDto() {
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

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getGpu() {
        return gpu;
    }

    public void setGpu(int gpu) {
        this.gpu = gpu;
    }

    public String getWalltime() {
        return walltime;
    }

    public void setWalltime(String walltime) {
        this.walltime = walltime;
    }

    public int getTasksPerNode() {
        return tasksPerNode;
    }

    public void setTasksPerNode(int tasksPerNode) {
        this.tasksPerNode = tasksPerNode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public String getErrorFilePath() {
        return errorFilePath;
    }

    public void setErrorFilePath(String errorFilePath) {
        this.errorFilePath = errorFilePath;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAbortedEmail() {
        return abortedEmail;
    }

    public void setAbortedEmail(boolean abortedEmail) {
        this.abortedEmail = abortedEmail;
    }

    public boolean isBeginEmail() {
        return beginEmail;
    }

    public void setBeginEmail(boolean beginEmail) {
        this.beginEmail = beginEmail;
    }

    public boolean isEndEmail() {
        return endEmail;
    }

    public void setEndEmail(boolean endEmail) {
        this.endEmail = endEmail;
    }

//    public String getCreationDate() {
//        return creationDate;
//    }

//    public void setCreationDate(String creationDate) {
//        this.creationDate = creationDate;
//    }

//    public String getCompleteDate() {
//        return completeDate;
//    }

//    public void setCompleteDate(String completeDate) {
//        this.completeDate = completeDate;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status.getName();
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

    public String getType() {
        return type;
    }

    public void setType(TaskConfigurationType type) {
        this.type = type.getName();
    }

    public static TaskResponseDto to(Task task) {
        TaskResponseDto responseDto = new TaskResponseDto();
        responseDto.setName(task.getName());
        responseDto.setDescription(task.getDescription());
        responseDto.setNodes(task.getConfiguration().getNodes());
        responseDto.setCores(task.getConfiguration().getCores());
        responseDto.setGpu(task.getConfiguration().getGpu());
        responseDto.setWalltime(task.getConfiguration().getWalltime());
        responseDto.setTasksPerNode(task.getConfiguration().getTasksPerNode());
        responseDto.setAccount(task.getConfiguration().getAccount());
        responseDto.setTasks(task.getConfiguration().getTasks());
        responseDto.setLogFilePath(task.getConfiguration().getLogFilePath());
        responseDto.setErrorFilePath(task.getConfiguration().getErrorFilePath());
        responseDto.setExclusive(task.getConfiguration().isExclusive());
        responseDto.setEmail(task.getConfiguration().getEmail());
        responseDto.setAbortedEmail(task.getConfiguration().isAbortedEmail());
        responseDto.setBeginEmail(task.getConfiguration().isBeginEmail());
        responseDto.setEndEmail(task.getConfiguration().isEndEmail());
//        responseDto.setCreationDate(task.getCreationDate().toString());
//        responseDto.setCompleteDate(task.getCompleteDate().toString());
        responseDto.setStatus(task.getStatus());
        responseDto.setPreRunScript(task.getPreRunScript());
        responseDto.setPostRunScript(task.getPostRunScript());
        responseDto.setType(task.getType());
        return responseDto;
    }
}
