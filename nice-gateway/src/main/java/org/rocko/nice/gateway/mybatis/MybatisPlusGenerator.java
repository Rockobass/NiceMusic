package org.rocko.nice.gateway.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MybatisPlusGenerator {
    private final static String dbUrl = "jdbc:mysql://rm-bp1n1jv17973394m50o.mysql.rds.aliyuncs.com:3306/nice_base";

    private final static String username = "babymo";

    private final static String password = "Qwer13579";

    private final static String driverName = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/nice-gateway/src/main/java");
        gc.setOpen(false);
        gc.setFileOverride(true);//再次生成文件是否覆盖之前文件
        gc.setServiceName("%sServiceInterface");//Service类命名方式，Service为接口类
        gc.setMapperName("%sMapper");//Mapper类命名方式
        gc.setXmlName("%sMapper");//Mapper对应xml文件命名方式
        gc.setServiceImplName("%sService");//Service实现类命名方式
        gc.setControllerName("%sController");//实体类的Controller生成方式，一般不需要，后文配置不生成Controller类
        gc.setDateType(DateType.ONLY_DATE);
//        gc.setSwagger2(true);//支持swagger2
        mpg.setGlobalConfig(gc);


        DataSourceConfig dsc = new DataSourceConfig();
        // 数据库配置,修改成自己的url，用户名密码
        dsc.setUrl(dbUrl);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setModuleName("gateway");
        pc.setParent("org.rocko.nice");
//        pc.setEntity("model.dbModel");//配置实体类包名
        pc.setMapper("mybatis.mapper");//配置Mapper类包名
//        pc.setService("service.interfaces");//配置Service类包名
        pc.setServiceImpl("dbService");
//        pc.setController("controller");//配置Controller类包名
        mpg.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        /*
            配置需要生成代码的表名，多个表用逗号隔开
            strategy.setInclude("table1","table2");
        */
        strategy.setInclude("path2role");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);//实体类应用lombok模式
        strategy.setRestControllerStyle(true);
//        strategy.setLogicDeleteFieldName("deleted");
//        TableFill gmt_created = new TableFill("gmt_created", FieldFill.INSERT);
//        TableFill gmt_modified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
//        ArrayList<TableFill> tableFills = new ArrayList<>();
//        tableFills.add(gmt_created);
//        tableFills.add(gmt_modified);
//        strategy.setTableFillList(tableFills);
//        strategy.setVersionFieldName("version");
        mpg.setStrategy(strategy);

        TemplateConfig tmp = new TemplateConfig();
        // 不生成Controller和xml文件
        tmp.setController("");
        tmp.setXml(null);
        tmp.setService("");
        tmp.setServiceImpl("");
//        tmp.setMapper("");

        mpg.setTemplate(tmp);
        mpg.execute();
    }
}
