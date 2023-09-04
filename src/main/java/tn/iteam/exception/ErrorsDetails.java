package tn.iteam.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class ErrorsDetails {

    private LocalTime timestamp;
    private String message;
    private String details;

}
