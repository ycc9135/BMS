package BMS;

import javax.sql.DataSource;

import org.junit.Test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MP {
	/**
	 * 代码生成，实例代码
	 */
	@Test
	public void testGenerator() {
		//1.全局配置
		GlobalConfig config=new GlobalConfig();
		config.setActiveRecord(true)//是否支持AR
		      .setAuthor("YangChao")//作者
		      .setOutputDir("F:\\JAVA\\Test\\BMS\\src\\main\\java")
		      .setFileOverride(true)//文件覆盖
		      .setIdType(IdType.AUTO)//主键策略
		      .setServiceName("%sService")//设置生成的Service接口的名字首字母是否为I
		      .setBaseResultMap(true)
		      .setBaseColumnList(true);
		      
		//2.数据源配置
		DataSourceConfig dataSourceConfig=new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL)
		.setDriverName("com.mysql.jdbc.Driver")
		.setUrl("jdbc:mysql://localhost:3306/bms")
		.setUsername("root")
		.setPassword("123456");
		//3.策略配置
		StrategyConfig strategyConfig=new StrategyConfig();
		strategyConfig.setCapitalMode(true)//全局大写命名
		.setDbColumnUnderline(true)//指定表名，字段名是否使用下划线
		.setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
		//.setTablePrefix("tbl_")
		.setInclude("t_book");
		//4.包名策略配置
		PackageConfig packageConfig=new PackageConfig();
		/*packageConfig.setEntity("org.boot.yc.entity");
		packageConfig.setMapper("org.boot.yc.mapper");
		packageConfig.setService("org.boot.yc.service");
		packageConfig.setController("org.boot.yc.controller");*/
		packageConfig.setParent("BMS.system")
		             .setMapper("mapper")
		             .setService("service")
		             .setController("controller")
		             .setEntity("entity")
		             .setXml("mapper");
		             
		//5.整合配置
		AutoGenerator autoGenerator=new AutoGenerator();
		autoGenerator.setGlobalConfig(config)
		             .setDataSource(dataSourceConfig)
		             .setStrategy(strategyConfig)
		             .setPackageInfo(packageConfig);
		//6.执行
		autoGenerator.execute();
	}

}