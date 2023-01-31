package com.farmer.ManufacturerService.GlobalException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY)
public class ErrorDetails {

    Date timeStamp;
    String message;
    String exceptionMessage;
}
