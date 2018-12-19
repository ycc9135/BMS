package BMS.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import BMS.system.entity.TBook;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YangChao
 * @since 2018-12-10
 */
public interface TBookService extends IService<TBook> {
	/**
	 * 分页
	 */
	/*public List<TBook> findByPage(int pageNum,int pageSize);*/
	public List<TBook> findByPage(Integer page,Integer rows);



}
