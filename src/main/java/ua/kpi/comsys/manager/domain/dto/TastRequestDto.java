package ua.kpi.comsys.manager.domain.dto;


import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.TaskConfiguration;
import ua.kpi.comsys.manager.domain.TaskConfigurationType;

/**
 * TastRequestDto Class
 *
 * @author aslepakurov
 * @version 01/15/2016
 */
public class TastRequestDto {
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

    public TastRequestDto() {
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

    public static Task from(TastRequestDto taskDto) {
        Task task = new Task();
        TaskConfiguration configuration = new TaskConfiguration();

        String taskName = taskDto.getName();
        String taskDescription = taskDto.getDescription();
        int taskGpu = taskDto.getGpu();
        int taskNodes = taskDto.getNodes();
        int taskCores = taskDto.getCores();
        int taskSimulTasks = taskDto.getTasks();
        String taskAccount = taskDto.getAccount();
        String taskEmail = taskDto.getEmail();
        String taskLogFilePath = taskDto.getLogFilePath();
        String taskErrorFilePath = taskDto.getErrorFilePath();
        String taskPreRunScript = taskDto.getPreRunScript();
        String taskPostRunScript = taskDto.getPostRunScript();
        String taskRequestType = taskDto.getRequestType();
        int tasksPerNode = taskDto.getTasksPerNode();
        String taskWalltime = taskDto.getWalltime();
        boolean taskAbortedEmail = taskDto.isAbortedEmail();
        boolean taskBeginEmail = taskDto.isBeginEmail();
        boolean taskEndEmail = taskDto.isEndEmail();
        boolean taskExclusive = taskDto.isExclusive();

        configuration.setAccount(taskAccount);
        configuration.setCores(taskCores);
        configuration.setGpu(taskGpu);
        configuration.setErrorFilePath(taskErrorFilePath);
        configuration.setGpu(taskGpu);
        configuration.setLogFilePath(taskLogFilePath);
        configuration.setTasksPerNode(tasksPerNode);
        configuration.setTasks(taskSimulTasks);
        configuration.setEmail(taskEmail);
        configuration.setWalltime(taskWalltime);
        configuration.setAbortedEmail(taskAbortedEmail);
        configuration.setBeginEmail(taskBeginEmail);
        configuration.setEndEmail(taskEndEmail);
        configuration.setExclusive(taskExclusive);
        configuration.setNodes(taskNodes);

        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setPreRunScript(taskPreRunScript);
        task.setPostRunScript(taskPostRunScript);
        task.setType(TaskConfigurationType.getType(taskRequestType));
        task.setConfiguration(configuration);

        return task;
    }
}
