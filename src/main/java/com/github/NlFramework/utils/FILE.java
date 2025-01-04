package com.github.NlFramework.utils;

import com.github.NaleumFramework;
import java.io.File;

public class FILE {
    public static void createFolderINE(File folder) {
        if (!folder.exists() && folder.mkdirs()) {
            CL.Send("&b[FILE] &7Successfully created the &a" + folder.getName(), NaleumFramework.getInstance());
        }
    }
}
