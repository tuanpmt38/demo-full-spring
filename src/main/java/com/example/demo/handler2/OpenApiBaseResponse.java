package com.example.demo.handler2;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@NoArgsConstructor
public class OpenApiBaseResponse {
  private HttpStatus httpStatus = HttpStatus.OK;
  private List<String> error;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime timestamp = LocalDateTime.now();

  private String url;


}
