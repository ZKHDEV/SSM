package com.zkh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zkh.dao.MovieMapper;
import com.zkh.exception.CustomException;
import com.zkh.util.DataPage;
import com.zkh.pojo.Movie;
import com.zkh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ms-zk on 2017-03-13.
 */
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Movie findByPrimaryKey(Integer id) throws CustomException {

        Movie movie = movieMapper.selectByPrimaryKey(id);
        if(movie==null){
            throw new CustomException("记录不存在！");
        }
        return movie;
    }

    @Override
    public void insert(Movie movie) {
        movieMapper.insert(movie);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        movieMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKey(Integer id, Movie movie) {
        movie.setId(id);
        movieMapper.updateByPrimaryKey(movie);
    }

    @Override
    public DataPage<Movie> selectPage(Integer pageNum, Integer pageSize, Integer indexCount) {
        PageHelper.startPage(pageNum,pageSize);
        List<Movie> movies = movieMapper.selectByExample(null);

        Integer pageCount = ((Page) movies).getPages();
        pageNum = pageNum > pageCount ? pageCount : pageNum;

        DataPage<Movie> page = new DataPage<Movie>();
        page.setData(movies);
        page.setIndexCount(indexCount);
        page.setPageCount(pageCount);
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);

        return page;
    }

}
