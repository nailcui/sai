package com.github.nailcui.sai.attacher;

import com.sun.tools.attach.VirtualMachine;

/**
 * @author dingyu
 * @date 2021-11-12 10:47
 */
public class Attach {

  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("pid jar_file args");
      return;
    }
    String pid = args[0];
    String agentJar = args[1];
    String agentArgs = args[2];
    try {
      VirtualMachine attach = VirtualMachine.attach(pid);
      attach.loadAgent(agentJar, agentArgs);
      attach.detach();
    } catch (Exception e) {
      System.out.println("attach error");
      System.out.println(e);
      return;
    }
  }

}
