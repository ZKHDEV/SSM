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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/list")
    public String list(Model model,Integer p){
        p = p == null ? 1 : (p < 1 ? 1 : p);
        DataPage<Movie> page = movieService.selectPage(p,10,6);
        return View("list",model,page);
    }

    @RequestMapping(value = "/create",method = {RequestMethod.GET})
    public String create(HttpSession session){
        session.setAttribute("token", UUID.randomUUID().toString());
        return View("create");
    }

    @RequestMapping(value = "/create",method = {RequestMethod.POST})
    public String createSubmit(Model model,HttpSession session,String token, @Valid Movie movie,BindingResult bindingResult) throws CustomException {
        validateAntiForgeryToken(session,token);
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
            return View("list",model,movie);
        }

        movieService.insert(movie);
        return RedirectTo("/movie/list");
    }

    @RequestMapping("delete")
    public String delete(Model model,Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        return View("delete",model,movie);
    }

    @RequestMapping("deleteSubmit")
    public String deleteSubmit(Integer id){
        movieService.deleteByPrimaryKey(id);
        return RedirectTo("/movie/list");
    }

    @RequestMapping("details")
    public String details(Model model,Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        return View("details",model,movie);
    }

    @RequestMapping(value = "/update",method = {RequestMethod.GET})
    public String update(Model model,HttpSession session,Integer id) throws CustomException {
        Movie movie = movieService.findByPrimaryKey(id);
        session.setAttribute("token", UUID.randomUUID().toString());
        return View("edit",model,movie);
    }

    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public String updateSubmit(Model model,HttpSession session,String token,@Validated Movie movie,BindingResult bindingResult) throws CustomException {
        validateAntiForgeryToken(session,token);
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
            return View("edit",model,movie);
        }

        movieService.updateByPrimaryKey(movie.getId(),movie);
        return RedirectTo("/movie/list");
    }
}
