package com.chuse.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chuse.entity.Product;
import com.chuse.service.ProductService;



@Controller
public class ProductController {
	
	@Resource
	private ProductService productService;
	//首页上跳转至健康
	@RequestMapping(value="/myHealth")

	public String showIndex(Map<String,Object> map,HttpSession session){

		//把最热的10条商品添加到map集合中
		map.put("hList", productService.findHot());
		
		return "health"; 
	}

	//根据菜品pid查询菜品
	@RequestMapping(value="findByPid/{pid}",method=RequestMethod.GET)
	public String findByPid(@PathVariable("pid") Integer pid,Map<String,Product> map){
		map.put("product", productService.findByPid(pid));
		return "health";
	}
}


















