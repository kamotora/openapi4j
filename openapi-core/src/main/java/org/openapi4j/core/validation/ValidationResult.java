package org.openapi4j.core.validation;

import com.fasterxml.jackson.databind.JsonNode;

public class ValidationResult {
  private final ValidationSeverity severity;
  private final Integer code;
  private final String message;
  private final JsonNode jsonNode;

  /**
   * Should never be used.
   * Internal for serialization.
   */
  public ValidationResult() {
    this.severity = ValidationSeverity.NONE;
    this.code = null;
    this.message = null;
    this.jsonNode = null;
  }

  public ValidationResult(ValidationSeverity severity, Integer code, String message) {
    this(severity, code, message, null);
  }

  public ValidationResult(ValidationSeverity severity, Integer code, String message, JsonNode node) {
    this.severity = severity;
    this.code = code;
    this.message = message;
    this.jsonNode = node;
  }

  public ValidationSeverity severity() {
    return severity;
  }

  public Integer code() {
    return code;
  }

  public String message() {
    if (jsonNode != null) {
      return message + String.format("Json node: (%s)", jsonNode);
    }
    return message;
  }
}
