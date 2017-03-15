package com.zkh.controller;

import com.zkh.exception.CustomException;
import com.zkh.util.DataPage;
import com.zkh.pojo.Movie;
import com.zkh.service.MovieService;
import com.zkh.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by ms-zk on 2017-03-13.
 */
@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/list")
    public String list(Model model,Integer p){
        DataPage<Movie> page = movieService.selectPage(p,10,6);
        model.addAttribute("page",page);
        return "list";
    }

    @RequestMapping(value = "/create",method = {RequestMethod.GET})
    public String create(){
        return "create";
    }

    @RequestMapping(value = "/create",method = {RequestMethod.POST})
    public String createSubmit(Model model, @Valid Movie movie,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("movie",movie);
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
            return "create";
        }

        movieService.insert(movie);
        return "redirect:/list.action";
    }

    @RequestMapping("delete")
    public String delete(Model model,Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        model.addAttribute("movie",movie);
        return "delete";
    }

    @RequestMapping("deleteSubmit")
    public String deleteSubmit(Integer id){
        movieService.deleteByPrimaryKey(id);
        return "redirect:/list.action";
    }

    @RequestMapping("details")
    public String details(Model model,Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        model.addAttribute("movie",movie);
        return "details";
    }

    @RequestMapping(value = "/update",method = {RequestMethod.GET})
    public String update(Model model,Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        model.addAttribute("movie",movie);
        return "edit";
    }

    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public String updateSubmit(Model model,@Validated Movie movie,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("movie",movie);
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
            return "edit";
        }

        movieService.updateByPrimaryKey(movie.getId(),movie);
        return "redirect:/list.action";
    }
}
