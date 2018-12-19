package BMS.system.service.impl;

import BMS.system.entity.TBook;
import BMS.system.mapper.TBookMapper;
import BMS.system.service.TBookService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YangChao
 * @since 2018-12-10
 */
@Service
public class TBookServiceImpl extends ServiceImpl<TBookMapper, TBook> implements TBookService {
	@Autowired
	private TBookMapper tbookMapper;
	/*@Override
	public List<TBook> findByPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		//使用PageHelp设置分页
		PageHelper.startPage(pageNum, pageSize);//分页核心代码
		EntityWrapper<TBook> wrapper=new EntityWrapper<TBook>();
		List<TBook>  books=tbookMapper.selectList(wrapper);
		List<TBook> books=tbookMapper.findAll();
		PageInfo<TBook> pageInfo=new PageInfo<>(books);
		return books;
	}*/

	@Override
	public List<TBook> findByPage(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return tbookMapper.findByPage((pageNum - 1) * pageSize, pageSize);
	}

	
}
