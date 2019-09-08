package com.example.demo.controller;

import com.example.demo.dto.NewDto;
import com.example.demo.dto.NewEditDto;
import com.example.demo.entity.News;
import com.example.demo.service.NewService;
import com.example.demo.utils.EntityValidationUtils;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class NewController {

  @Autowired
  private NewService newService;

  @GetMapping(value ="/news")
  public ResponseEntity<List<News>> all (){

    List<News> news = newService.getAll();
    return ResponseEntity.ok(news);
  }

  @GetMapping(value = "/new/{id}")
  public ResponseEntity<News> getNewById(@PathVariable Long id){
    News news = newService.findById(id);
    return ResponseEntity.ok(news);
  }

  @PostMapping(value = "/new")
  public ResponseEntity<News> add (@Valid @RequestBody NewDto newDto, BindingResult bindingResult){
    EntityValidationUtils.processBindingResults(bindingResult);
    News news = newService.save(newDto);
    return ResponseEntity.ok(news);
  }

  @PutMapping(value = "/new")
  public ResponseEntity<News> edit (@Valid @RequestBody NewEditDto newEditDto, BindingResult bindingResult){

    EntityValidationUtils.processBindingResults(bindingResult);
    News news = newService.update(newEditDto);
    return ResponseEntity.ok(news);

  }

}
