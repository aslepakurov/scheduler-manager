package ua.kpi.comsys.manager.domain.dto;


import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.TaskConfiguration;
import ua.kpi.comsys.manager.domain.TaskConfigurationType;

import java.util.HashMap;
import java.util.Map;

/**
 * TastRequestDto Class
 *
 * @author aslepakurov
 * @version 01/15/2016
 */
public class TaskRequestDto {
    private String id;
    private String name;
    private String description;

    private String script;
    private String preRunScript;
    private String postRunScript;
    private String requestType;

    private int nodes;
    private int cores;
    private int gpu;
    private int tasks;
    private int tasksPerNode;

    private String walltime;
    private String account;
    private String email;
    private boolean abortedEmail;
    private boolean beginEmail;

    private boolean endEmail;
    private String logFilePath;
    private String errorFilePath;
    private boolean exclusive;

    public TaskRequestDto() {
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

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public static Task from(TaskRequestDto taskDto) {
        Task task = new Task();
        TaskConfiguration configuration = new TaskConfiguration();

        configuration.setAccount(taskDto.getAccount());
        configuration.setCores(taskDto.getCores());
        configuration.setGpu(taskDto.getGpu());
        configuration.setErrorFilePath(taskDto.getErrorFilePath());
        configuration.setLogFilePath(taskDto.getLogFilePath());
        configuration.setTasksPerNode(taskDto.getTasksPerNode());
        configuration.setTasks(taskDto.getTasks());
        configuration.setEmail(taskDto.getEmail());
        configuration.setWalltime(taskDto.getWalltime());
        configuration.setAbortedEmail(taskDto.isAbortedEmail());
        configuration.setBeginEmail(taskDto.isBeginEmail());
        configuration.setEndEmail(taskDto.isEndEmail());
        configuration.setExclusive(taskDto.isExclusive());
        configuration.setNodes(taskDto.getNodes());

        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setPreRunScript(taskDto.getPreRunScript());
        task.setPostRunScript(taskDto.getPostRunScript());
        task.setType(TaskConfigurationType.getType(taskDto.getRequestType()));
        task.setConfiguration(configuration);

        return task;
    }

    public static TaskRequestDto to(Task task) {
        TaskRequestDto dto = new TaskRequestDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setRequestType(task.getType().getName());
        dto.setNodes(task.getConfiguration().getNodes());
        dto.setCores(task.getConfiguration().getCores());
        dto.setGpu(task.getConfiguration().getGpu());
        dto.setTasks(task.getConfiguration().getTasks());
        dto.setTasksPerNode(task.getConfiguration().getTasksPerNode());
        dto.setWalltime(task.getConfiguration().getWalltime());
        dto.setAccount(task.getConfiguration().getAccount());
        dto.setEmail(task.getConfiguration().getEmail());
        dto.setAbortedEmail(task.getConfiguration().isAbortedEmail());
        dto.setBeginEmail(task.getConfiguration().isBeginEmail());
        dto.setEndEmail(task.getConfiguration().isEndEmail());
        dto.setLogFilePath(task.getConfiguration().getLogFilePath());
        dto.setErrorFilePath(task.getConfiguration().getErrorFilePath());
        dto.setExclusive(task.getConfiguration().isExclusive());
        return dto;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("description", description);
        map.put("nodes", nodes);
        map.put("cores", cores);
        map.put("gpu", gpu);
        map.put("tasks", tasks);
        map.put("tasksPerNode", tasksPerNode);
        map.put("walltime", walltime);
        map.put("account", account);
        map.put("email", email);
        map.put("abortedEmail", abortedEmail);
        map.put("beginEmail", beginEmail);
        map.put("endEmail", endEmail);
        map.put("logFilePath", logFilePath);
        map.put("errorFilePath", errorFilePath);
        map.put("exclusive", exclusive);
        return map;
    }
}
