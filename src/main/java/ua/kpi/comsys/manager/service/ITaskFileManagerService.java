package ua.kpi.comsys.manager.service;

import java.io.IOException;

/**
 * ITaskManagerService Class
 *
 * @author aslepakurov
 * @version 01/31/2016
 */
public interface ITaskFileManagerService {
    String GENERATED_FILE = "generated";
    String SCRIPT = "script";
    String PRE_SCRIPT = "prescript";
    String POST_SCRIPT = "postscript";

    void generateFile(String id, String text) throws IOException;
    void saveScriptFile(String id, String text) throws IOException;
    void savePreScriptFile(String id, String text) throws IOException;
    void savePostScriptFile(String id, String text) throws IOException;
    String getTaskGeneratedFile(String id);
    String getTaskScriptFile(String id);
    String getTaskPreScriptFile(String id);
    String getTaskPostScriptFile(String id);
}
