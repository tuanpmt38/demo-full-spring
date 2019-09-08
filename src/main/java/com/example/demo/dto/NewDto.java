package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NewDto {

  @NotNull(message = "content.not-null")
  private String content;

  @NotNull(message = "image.not-null")
  private String imageUrl;

}
