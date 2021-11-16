package com.github.nailcui.sai.example;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import java.util.List;

/**
 * @author nailcui
 * @date 2020-11-26 12:45
 */
public class Main {

  public static void main(String[] args) {
    List<VirtualMachineDescriptor> list = VirtualMachine.list();
    System.out.println(CalUtil.add(3, 4));
  }
}
