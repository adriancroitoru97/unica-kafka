package com.myunica.first.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "type",
        "interactionPoint",
        "multipleIPs",
        "treatmentCodes"
})

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaDTO {

    @Range(min = 100, max = 999, message = "Invalid ID")
    @NotNull(message = "ID is mandatory")
    private Integer id;

    private CallType type;

    @Length(max = 30, message = "IP name too long")
    private String interactionPoint;

    private List<String> multipleIPs;

    private List<String> treatmentCodes;
}
