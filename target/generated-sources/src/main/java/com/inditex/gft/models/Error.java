package com.inditex.gft.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-03T21:04:22.416430500+01:00[Europe/Madrid]")
public class Error {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Integer status;

  private String error;

  private String message;

  private String path;

  /**
   * Default constructor
   * @deprecated Use {@link Error#Error(OffsetDateTime, Integer, String, String, String)}
   */
  @Deprecated
  public Error() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Error(OffsetDateTime timestamp, Integer status, String error, String message, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

  public Error timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Fecha y hora en que se produjo el error.
   * @return timestamp
  */
  @NotNull @Valid 
  @Schema(name = "timestamp", description = "Fecha y hora en que se produjo el error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public Error status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Código de estado HTTP.
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Código de estado HTTP.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Error error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Tipo de error.
   * @return error
  */
  @NotNull 
  @Schema(name = "error", description = "Tipo de error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("error")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Mensaje descriptivo del error.
   * @return message
  */
  @NotNull 
  @Schema(name = "message", description = "Mensaje descriptivo del error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Ruta que generó el error.
   * @return path
  */
  @NotNull 
  @Schema(name = "path", description = "Ruta que generó el error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.timestamp, error.timestamp) &&
        Objects.equals(this.status, error.status) &&
        Objects.equals(this.error, error.error) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.path, error.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, status, error, message, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

