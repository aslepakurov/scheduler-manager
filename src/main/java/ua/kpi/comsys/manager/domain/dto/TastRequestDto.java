package ua.kpi.comsys.manager.domain.dto;


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
    private int nodes;
    private int cores;
    private int gpu;
    private int tasksPerNode;
    private String walltime;
    private String account;
    private int tasks;
    private String logFilePath;
    private String errorFilePath;
    private boolean exclusive;
    private String email;
    private boolean abortedEmail;
    private boolean beginEmail;
    private boolean endEmail;
    private String requestType;

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
}
