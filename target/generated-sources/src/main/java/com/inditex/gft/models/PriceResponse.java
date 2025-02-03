package com.inditex.gft.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PriceResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-03T21:04:22.416430500+01:00[Europe/Madrid]")
public class PriceResponse {

  private Integer productId;

  private Integer brandId;

  private Integer priceList;

  private String startDate;

  private String endDate;

  private Double price;

  /**
   * Default constructor
   * @deprecated Use {@link PriceResponse#PriceResponse(Integer, Integer, Integer, String, String, Double)}
   */
  @Deprecated
  public PriceResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PriceResponse(Integer productId, Integer brandId, Integer priceList, String startDate, String endDate, Double price) {
    this.productId = productId;
    this.brandId = brandId;
    this.priceList = priceList;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
  }

  public PriceResponse productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Identificador del producto.
   * @return productId
  */
  @NotNull 
  @Schema(name = "productId", description = "Identificador del producto.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productId")
  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public PriceResponse brandId(Integer brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Identificador de la cadena/brand.
   * @return brandId
  */
  @NotNull 
  @Schema(name = "brandId", description = "Identificador de la cadena/brand.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("brandId")
  public Integer getBrandId() {
    return brandId;
  }

  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  public PriceResponse priceList(Integer priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * Identificador de la tarifa de precios aplicada.
   * @return priceList
  */
  @NotNull 
  @Schema(name = "priceList", description = "Identificador de la tarifa de precios aplicada.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("priceList")
  public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(Integer priceList) {
    this.priceList = priceList;
  }

  public PriceResponse startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Fecha y hora de inicio de la tarifa en formato `YYYY-MM-DD HH:MM:SS`.
   * @return startDate
  */
  @NotNull 
  @Schema(name = "startDate", description = "Fecha y hora de inicio de la tarifa en formato `YYYY-MM-DD HH:MM:SS`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startDate")
  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public PriceResponse endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Fecha y hora de fin de la tarifa en formato `YYYY-MM-DD HH:MM:SS`.
   * @return endDate
  */
  @NotNull 
  @Schema(name = "endDate", description = "Fecha y hora de fin de la tarifa en formato `YYYY-MM-DD HH:MM:SS`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("endDate")
  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public PriceResponse price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Precio final a aplicar.
   * @return price
  */
  @NotNull 
  @Schema(name = "price", description = "Precio final a aplicar.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceResponse priceResponse = (PriceResponse) o;
    return Objects.equals(this.productId, priceResponse.productId) &&
        Objects.equals(this.brandId, priceResponse.brandId) &&
        Objects.equals(this.priceList, priceResponse.priceList) &&
        Objects.equals(this.startDate, priceResponse.startDate) &&
        Objects.equals(this.endDate, priceResponse.endDate) &&
        Objects.equals(this.price, priceResponse.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, priceList, startDate, endDate, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceResponse {\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

