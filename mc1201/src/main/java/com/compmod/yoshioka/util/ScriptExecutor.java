/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.compmod.yoshioka.util;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScriptExecutor {
    final String scriptNameMac;
    final String scriptPathMac;
    final String scriptNameWin;
    final String scriptPathWin;
    public static final Logger LOGGER = LogManager.getLogger();

    public ScriptExecutor(String arg1, String arg2, String arg3, String arg4) {
        this.scriptPathMac = arg1;
        this.scriptNameMac = arg2;
        this.scriptPathWin = arg3;
        this.scriptNameWin = arg4;
    }

    public boolean execScript() {
        if ("1".equals(this.getOs())) {
            try {
                if (!this.execShellScript(this.scriptPathWin, this.scriptNameWin)) {
                    return false;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else if ("2".equals(this.getOs())) {
            try {
                if (!this.execShellScript(this.scriptPathMac, this.scriptNameMac)) {
                    return false;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else {
        	LOGGER.info(".............neither Win nor Mac : [" + this.getOs() + "]");
            return false;
        }
    }

    private boolean execShellScript(String arg1, String arg2) throws IOException, InterruptedException {
        System.out.println(arg1);
        System.out.println(arg2);
        File scriptFile = new File(arg1, arg2);
        if (!scriptFile.exists()) {
            LOGGER.info(".............The script not exists : [" + scriptFile.getAbsolutePath() + "]");
            return false;
        }
        ProcessBuilder processBuilder = new ProcessBuilder(scriptFile.getAbsolutePath());
        processBuilder.directory(new File(arg2));
        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            LOGGER.info(".............The script has been executed : [" + scriptFile.getAbsolutePath() + "] (" + exitCode + ")");
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return false;
        }
    }

    private String getOs() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "1";
        }
        if (os.contains("mac")) {
            return "2";
        }
        if (os.contains("nix") || os.contains("nux")) {
            return "3";
        }
        return "4";
    }
}
