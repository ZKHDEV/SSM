package com.zkh.controller;

import com.zkh.exception.CustomException;
import com.zkh.util.DataPage;
import com.zkh.pojo.Movie;
import com.zkh.service.MovieService;
import com.zkh.util.ControllerUtil;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by ms-zk on 2017-03-13.
 */
@Controller
@RequestMapping("/movie")
public class MovieController extends BaseController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/list")
    public String list(Model model,Integer p){
        p = p == null ? 1 : (p < 1 ? 1 : p);
        DataPage<Movie> page = movieService.selectPage(p,10,6);
        return View("list",model,page);
    }

    @GetMapping("/create")
    public String create(){
        return View("create");
    }

    @PostMapping("/create")
    public String createSubmit(Model model, @Valid Movie movie,BindingResult bindingResult) throws CustomException {
        if(!bindingResult.hasErrors()){
            movieService.insert(movie);
            return RedirectTo("/movie/list");
        }else{
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
        }

        return View("list",model,movie);
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        return View("delete",model,movie);
    }

    @GetMapping("/deleteSubmit/{id}")
    public String deleteSubmit(@PathVariable("id") Integer id){
        movieService.deleteByPrimaryKey(id);
        return RedirectTo("/movie/list");
    }

    @GetMapping("/details/{id}")
    public String details(Model model,@PathVariable("id") Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        return View("details",model,movie);
    }

    @GetMapping("/update/{id}")
    public String update(Model model,@PathVariable("id") Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        return View("edit",model,movie);
    }

    @PostMapping("/update")
    public String updateSubmit(Model model,@Validated Movie movie,BindingResult bindingResult) throws CustomException {
        if(!bindingResult.hasErrors()){
            movieService.updateByPrimaryKey(movie.getId(),movie);
            return RedirectTo("/movie/list");
        }else{
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
        }

        return View("edit",model,movie);
    }
}
