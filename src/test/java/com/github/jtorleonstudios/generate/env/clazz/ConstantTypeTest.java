package com.github.jtorleonstudios.generate.env.clazz;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantTypeTest {

  @Nested
  class TestGetType {

    @Test
    void test_get_type_for_null() {
      assertEquals(ConstantType.NULL, ConstantType.getType(null));
    }

    @Test
    void test_get_type_for_string() {
      assertEquals(ConstantType.STRING, ConstantType.getType("hello world"));
    }

    @Test
    void test_get_type_for_boolean() {
      assertEquals(ConstantType.BOOLEAN, ConstantType.getType(true));
      assertEquals(ConstantType.BOOLEAN, ConstantType.getType(false));
    }

    @Test
    void test_get_type_for_int() {
      assertEquals(ConstantType.INT, ConstantType.getType(0));
      assertEquals(ConstantType.INT, ConstantType.getType(5));
    }

    @Test
    void test_get_type_for_long() {
      assertEquals(ConstantType.LONG, ConstantType.getType(0L));
      assertEquals(ConstantType.LONG, ConstantType.getType(5L));
    }

    @Test
    void test_get_type_for_float() {
      assertEquals(ConstantType.FLOAT, ConstantType.getType(0F));
      assertEquals(ConstantType.FLOAT, ConstantType.getType(5F));
    }

    @Test
    void test_get_type_for_double() {
      assertEquals(ConstantType.DOUBLE, ConstantType.getType(0D));
      assertEquals(ConstantType.DOUBLE, ConstantType.getType(5D));
    }

    @Test
    void test_get_type_for_char() {
      assertEquals(ConstantType.CHAR, ConstantType.getType('n'));
    }

    @Test
    void test_get_type_for_byte() {
      assertEquals(ConstantType.BYTE, ConstantType.getType((byte) 0));
    }

    @Test
    void test_get_type_for_short() {
      assertEquals(ConstantType.SHORT, ConstantType.getType((short) 1));
    }

    @Test
    void test_get_type_for_object() {
      assertEquals(ConstantType.OBJECT, ConstantType.getType(new Object()));
    }

  }

  @Nested
  class TestFormatter {

    @Test
    void test_formatter_boolean() {
      assertEquals("true", ConstantType.BOOLEAN.format(true));
      assertEquals("false", ConstantType.BOOLEAN.format(false));
    }

    @Test
    void test_formatter_byte() {
      var v = 0;
      assertEquals("(byte) 0", ConstantType.BYTE.format(v));
    }

    @Test
    void test_formatter_char() {
      var v = 'b';
      assertEquals("'b'", ConstantType.CHAR.format(v));
    }

    @Test
    void test_formatter_double() {
      var v = 3.14159D;
      assertEquals("3.14159D", ConstantType.DOUBLE.format(v));
    }

    @Test
    void test_formatter_float() {
      var v = 0.5F;
      assertEquals("0.5F", ConstantType.FLOAT.format(v));
    }

    @Test
    void test_formatter_int() {
      var v = 69;
      assertEquals("69", ConstantType.INT.format(v));
    }

    @Test
    void test_formatter_long() {
      var v = 123456789L;
      assertEquals("123456789L", ConstantType.LONG.format(v));
    }

    @Test
    void test_formatter_short() {
      var v = 32000;
      assertEquals("(short) 32000", ConstantType.SHORT.format(v));
    }

    @Test
    void test_formatter_string() {
      var v = "hello world";
      assertEquals("\"hello world\"", ConstantType.STRING.format(v));
    }

    @Test
    void test_formatter_object() {
      var v = new Object();
      assertEquals("new Object()", ConstantType.OBJECT.format(v));
    }

    @Test
    void test_formatter_null() {
      assertEquals("null", ConstantType.NULL.format(null));
    }
  }

  @Nested
  class TestToCode {
    @Test
    void test_to_code_boolean() {
      assertEquals(
        "  boolean HELLO = true;",
        ConstantType.BOOLEAN.toCode("hello", true)
      );
    }

    @Test
    void test_to_code_byte() {
      assertEquals(
        "  byte HELLO = (byte) 0;",
        ConstantType.BYTE.toCode("hello", 0)
      );
    }

    @Test
    void test_to_code_char() {
      assertEquals(
        "  char HELLO = 'r';",
        ConstantType.CHAR.toCode("hello", 'r')
      );
    }


    @Test
    void test_to_code_double() {
      assertEquals(
        "  double HELLO = 0.0D;",
        ConstantType.DOUBLE.toCode("hello", 0.0D)
      );
    }

    @Test
    void test_to_code_float() {
      assertEquals(
        "  float HELLO = 0.0F;",
        ConstantType.FLOAT.toCode("hello", 0.0F)
      );
    }

    @Test
    void test_to_code_int() {
      assertEquals(
        "  int HELLO = 0;",
        ConstantType.INT.toCode("hello", 0)
      );
    }

    @Test
    void test_to_code_long() {
      assertEquals(
        "  long HELLO = 0L;",
        ConstantType.LONG.toCode("hello", 0L)
      );
    }

    @Test
    void test_to_code_short() {
      assertEquals(
        "  short HELLO = (short) 0;",
        ConstantType.SHORT.toCode("hello", 0)
      );
    }

    @Test
    void test_to_code_string() {
      assertEquals(
        "  String HELLO = \"test\";",
        ConstantType.STRING.toCode("hello", "test")
      );
    }

    @Test
    void test_to_code_object() {
      assertEquals(
        "  Object HELLO = new Object();",
        ConstantType.OBJECT.toCode("hello", new Object())
      );
    }

  }

}