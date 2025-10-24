package com.github.jtorleonstudios.generate.env.clazz;

import org.gradle.api.GradleException;
import org.gradle.api.Project;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class GenClassExt {
  /**
   * <p>
   * The name of this extension when it is added to a Gradle project.
   * </p>
   */
  public final static String NAME = "setupEnvClass";

  public static void register(
    @NotNull Project project
  ) {
    project
      .getExtensions()
      .create(
        GenClassExt.NAME,
        GenClassExt.class
      );
  }

  public static boolean validate(
    @NotNull GenClassExt instance
  ) {
    IsNotNullAndNotEmpty(
      "outputPackage",
      "com.example.generated",
      instance.getOutputPackage().getOrNull()
    );

    IsNotNullAndNotEmpty(
      "className",
      "HelloWorld",
      instance.getClassName().getOrNull()
    );

    IsNotNullAndNotEmpty(
      "classSuffix",
      "Constant",
      instance.getClassSuffix().getOrNull()
    );

    return true;
  }

  @Contract("_, _, null -> fail")
  private static void IsNotNullAndNotEmpty(
    String fieldName,
    String exampleValue,
    @Nullable String value
  ) {
    if (value == null || value.trim().isEmpty()) {
      throw new GradleException("""
        Invalid configuration: '%1$s' is missing or empty.
        Please define it in your build.gradle, for example:
        
        setupEnvClass {
            %1$s = "%2$s"
        }
        """.formatted(fieldName, exampleValue)
      );
    }
  }

  /**
   * <p>
   * Default constructor for GenClassExt.
   * </p>
   * <ul>
   *     <li>
   *       {@code expected}: defaults to an empty list,
   *       indicating no specific keys are expected by default.
   *     </li>
   * </ul>
   */
  public GenClassExt() {
    this.getOutputPackage().convention("");
    this.getClassName().convention("");
    this.getClassSuffix().convention("Constant");
    this.getConstants().convention(Map.of());
  }

  public abstract Property<String> getOutputPackage();

  public abstract Property<String> getClassName();

  public abstract Property<String> getClassSuffix();

  public abstract MapProperty<String, Object> getConstants();

}
