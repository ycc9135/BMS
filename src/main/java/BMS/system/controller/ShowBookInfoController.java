package BMS.system.controller;

import java.util.Date;
import java.util.HashMap;

/**
 * <p>
 *  登录
 * </p>
 *
 * @author YangChao
 * @since 2018-11-19
 */

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import BMS.system.entity.TBook;
import BMS.system.service.TBookService;
@RequestMapping("/book")
@RestController
public class ShowBookInfoController {
	@Autowired
	TBookService bookservice;
	@ResponseBody
	@RequestMapping(value = "/bookList", produces = { "application/json;charset=UTF-8" })
	public Map<String, Object> BookList(HttpServletResponse response,@RequestParam("current") int current, @RequestParam("rowCount") int rowCount) {
		EntityWrapper<TBook> wrapper = new EntityWrapper<TBook>();
		List<TBook> books = bookservice.selectList(wrapper);
		int total = books.size();
		List<TBook> list = bookservice.findByPage(current, rowCount);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("current", current);
		map.put("rowCount", rowCount);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	@RequestMapping(value = "/delBook", method = RequestMethod.POST)
	public String delete(@RequestParam("bookId") int bookId) {
		System.out.println("bookId:" + bookId);
		bookservice.deleteById(bookId);
		return "redirect:bookList";
	}
	
	@ResponseBody
	@RequestMapping(value="/getBookInfo",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public TBook geTBookById(@RequestParam("bookId") int bookId){
		TBook tBook=bookservice.selectById(bookId);
        return tBook;
    }
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
    public Boolean update(@RequestParam("nAp") String nAp){
		String str[] = nAp.split("-");
		int bookId = Integer.parseInt(str[0]);
		String bookName = str[1];
		String storagetime = str[2];
		int state = Integer.parseInt(str[5]);
		String author = str[6];
		String publishingHouse = str[7];
        TBook tBook=new TBook();
        tBook.setBookId(bookId);
        tBook.setBookName(bookName);
        tBook.setState(state);
        tBook.setAuthor(author);
        tBook.setPublishingHouse(publishingHouse);
        bookservice.updateById(tBook);
        return true;
    }
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public Boolean addBook(@RequestParam("nAp") String nAp){
		String str[] = nAp.split("-");
		String bookName = str[0];
		int state = Integer.parseInt(str[1]);
		String author = str[2];
		String publishingHouse = str[3];
        TBook tBook=new TBook();
        tBook.setBookName(bookName);
        tBook.setStoragetime(new Date());
        tBook.setState(state);
        tBook.setAuthor(author);
        tBook.setPublishingHouse(publishingHouse);
        bookservice.insert(tBook);
        return true;
    }
	/**
	 * 测试
	 */
}
