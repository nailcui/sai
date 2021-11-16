package com.github.nailcui.sai.core;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType.Builder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

/**
 * @author nailcui
 * @date 2020-11-26 12:40
 */
public class Agent {

  public static void premain(String agentArgs, final Instrumentation instrumentation) {
    System.out.println("premain");
//    new AgentBuilder.Default()
//        .type(ElementMatchers.<TypeDescription>named("com.github.nailcui.sai.example.CalUtil"))
//        .transform(new AgentBuilder.Transformer() {
//          public Builder<?> transform(Builder<?> builder, TypeDescription typeDescription,
//              ClassLoader classLoader, JavaModule javaModule) {
//            return builder.method(ElementMatchers.<MethodDescription>named("add"))
//                .intercept(FixedValue.value(3L));
//          }
//        }).installOn(instrumentation);
    System.out.println("agent args: " + agentArgs);
    if (agentArgs.contains("system_gc")) {
      System.gc();
      System.out.println("run System.gc();");
    }
  }

  public static void agentmain(String agentArgs, Instrumentation inst) {
    System.out.println("agentmain");
    System.out.println("agent args: " + agentArgs);
    if (agentArgs.contains("system_gc")) {
      System.gc();
      System.out.println("run System.gc();");
    }
  }
}
