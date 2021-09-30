package com.example.mybatisplusgenerator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * mybatis plus 代码生成器
 * 文档地址https://mp.baomidou.com/guide/generator-new.html#%E5%BF%AB%E9%80%9F%E5%85%A5%E9%97%A8
 *
 * @author lsx
 * @date 2021/9/30 11:39
 */
public class MyBatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                "jdbc:mysql://mysql-uat.boxuegu.com:3307/crm",
                "crm",
                "uatdjasiasfds"
        )
                .globalConfig(builder -> {
                    builder.author("lsx") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\work\\idea_work_space\\mybatis-plus-generator\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("data") // 设置父包名
                            .moduleName("data") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\work\\idea_work_space\\mybatis-plus-generator\\src\\main\\java")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_clue") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
