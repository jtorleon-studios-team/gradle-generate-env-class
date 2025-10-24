package com.github.jtorleonstudios.generate.env.clazz;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.logging.Logging;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Main implements Plugin<Object> {
  public static final String PLUGIN_IDENTIFIER = "gradle-generate-env-class";

  @Override
  public void apply(
    @NotNull Object target
  ) {

    if (target instanceof Project project) {
      this.applyFrom(project);
      return;
    }

    Logging
      .getLogger(Main.class)
      .error(
        "Failed to apply plugin '{}': Unsupported target type '{}'. " +
        "This plugin can only be applied to a Gradle Project (build.gradle).",
        PLUGIN_IDENTIFIER,
        target.getClass().getName()
      );
  }

  private void applyFrom(
    @NotNull Project project
  ) {
    GenClassExt.register(project);

    GenClassTask.register(project);

    project.afterEvaluate(this::applyAfterEvaluateFrom);
  }

  @Contract(pure = true)
  private void applyAfterEvaluateFrom(
    @NotNull Project project
  ) {
    //this.configureProcessResources(project);
  }

}
