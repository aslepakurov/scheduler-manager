package ua.kpi.comsys.manager.service;

import com.google.common.base.Joiner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * TaskManagerService Class
 *
 * @author aslepakurov
 * @version 01/31/2016
 */
@Component
public class TaskFileManagerService implements ITaskFileManagerService {
    //temp
    private String taskPath = "/tmp/manager";

    @Override
    public void generateFile(String id, String text) throws IOException {
        File generatedFile = new File(getTaskGeneratedFile(id));
        saveFile(text, generatedFile, "Can't create generated file and/or directory", generatedFile.toPath());
    }

    @Override
    public void saveScriptFile(String id, String text) throws IOException {
        File scriptFile = new File(getTaskScriptFile(id));
        saveFile(text, scriptFile, "Can't create script file and/or directory", scriptFile.toPath());
    }

    @Override
    public void savePreScriptFile(String id, String text) throws IOException {
        File preScriptFile = new File(getTaskPreScriptFile(id));
        saveFile(text, preScriptFile, "Can't create pre-script file and/or directory", preScriptFile.toPath());
    }

    @Override
    public void savePostScriptFile(String id, String text) throws IOException {
        File postScriptFile = new File(getTaskPreScriptFile(id));
        saveFile(text, postScriptFile, "Can't create post-script file and/or directory", postScriptFile.toPath());
    }

    private void saveFile(String text, File file, String message, Path path) throws IOException {
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new IOException(message);
        }
        Files.write(path, text.getBytes(), StandardOpenOption.CREATE);
    }


    @Override
    public String getTaskGeneratedFile(String id) {
        return getJoin(id, GENERATED_FILE);
    }

    @Override
    public String getTaskScriptFile(String id) {
        return getJoin(id, SCRIPT);
    }

    @Override
    public String getTaskPreScriptFile(String id) {
        return getJoin(id, PRE_SCRIPT);
    }

    @Override
    public String getTaskPostScriptFile(String id) {
        return getJoin(id, POST_SCRIPT);
    }

    private String getJoin(String id, String postScript) {
        return Joiner.on(File.separator).join(taskPath, id, postScript);
    }


}
