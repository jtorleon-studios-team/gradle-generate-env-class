package com.github.jtorleonstudios.generate.env.clazz;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public enum ConstantType {

  BOOLEAN(
    "boolean",
    v -> Boolean.toString((Boolean) v)
  ),

  BYTE(
    "byte",
    v -> "(byte) " + v),

  CHAR(
    "char",
    v -> "'" + v + "'"
  ),

  DOUBLE(
    "double",
    v -> v + "D"
  ),

  FLOAT(
    "float",
    v -> v + "F"
  ),

  INT(
    "int",
    v -> Integer.toString((Integer) v)
  ),

  LONG(
    "long",
    v -> v + "L"
  ),

  SHORT(
    "short",
    v -> "(short) " + v
  ),

  STRING(
    "String",
    v -> "\"" + v + "\""
  ),

  OBJECT(
    "Object",
    v -> "new Object()"
  ),

  NULL(
    "Null",
    v -> "null"
  );

  private final String type;
  private final Function<Object, String> formatter;

  @Contract(pure = true)
  public static ConstantType getType(
    @Nullable Object object
  ) {
    if (object == null) {
      return ConstantType.NULL;
    }

    if (object instanceof String) {
      return ConstantType.STRING;
    }

    if (object instanceof Boolean) {
      return ConstantType.BOOLEAN;
    }

    if (object instanceof Integer) {
      return ConstantType.INT;
    }

    if (object instanceof Long) {
      return ConstantType.LONG;
    }

    if (object instanceof Float) {
      return ConstantType.FLOAT;
    }

    if (object instanceof Double) {
      return ConstantType.DOUBLE;
    }

    if (object instanceof Character) {
      return ConstantType.CHAR;
    }

    if (object instanceof Byte) {
      return ConstantType.BYTE;
    }

    if (object instanceof Short) {
      return ConstantType.SHORT;
    }

    return ConstantType.OBJECT;
  }

  public String format(
    Object value
  ) {
    return formatter.apply(value);
  }

  public @NotNull String toCode(
    @NotNull String constantName,
    Object value
  ) {
    return "  "
           + this.getType()
           + " "
           + constantName.toUpperCase()
           + " = " + this.format(value)
           + ";";
  }

}
