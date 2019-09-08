package com.example.demo.service;

import com.example.demo.dto.NewDto;
import com.example.demo.dto.NewEditDto;
import com.example.demo.entity.News;
import java.util.List;

public interface NewService {

  List<News> getAll();

  News findById (Long id);

  News save (NewDto newDto);

  News update(NewEditDto newEditDto);
}
