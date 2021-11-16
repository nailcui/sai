package com.github.nailcui.sai.agent.gc;

import arthas.VmTool;
import java.lang.instrument.Instrumentation;

/**
 * @author nailcui
 * @date 2020-11-26 12:40
 */
public class Agent {

  public static final String KEY_SYSTEM_GC = "system_gc";
  public static final String KEY_FORCE_GC = "force_gc";

  public static void premain(String agentArgs, final Instrumentation instrumentation) {
    System.out.println("premain");
    System.out.println("agent args: " + agentArgs);
  }

  public static void agentmain(String agentArgs, Instrumentation inst) {
    System.out.println("agentmain");
    System.out.println("agent args2: " + agentArgs);
    System.out.println("path" + System.getProperty("java.library.path"));
    if (agentArgs.contains(KEY_SYSTEM_GC)) {
      System.gc();
      System.out.println("run System.gc();");
    }
    if (agentArgs.contains(KEY_FORCE_GC)) {
      try {
        VmTool.getInstance("/home/admin/.arthas/lib/3.5.4/arthas/lib/libArthasJniLibrary-x64.dll").forceGc();
        System.out.println("run force gc");
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
