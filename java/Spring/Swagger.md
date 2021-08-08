# Swagger

> 号称世界上最流行的API框架。RestFul API文档在线自动生成工具—>API文档与API定义同步更新。

## 1. 如何使用Swagger

### 1.1 SpringBoot集成Swagger

#### 1.1.1 添加依赖

```xml
<!-- Swagger -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<!-- 文档 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
    <exclusions>
        <exclusion>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
        </exclusion>
        <exclusion>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-models</artifactId>
    <version>1.5.21</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>1.8.5</version>
</dependency>
```



#### 1.1.2 添加配置类

```java
package cn.com.jchen.study.config;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                // 核心：读取把那个包下面的方法作为接口，只能是：controller
                .apis(RequestHandlerSelectors.basePackage("cn.com.jchen.study.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("APP项目数据接口")
                .description("在线体验文档")          .termsOfServiceUrl("https://api.lc.com/api")
                .contact("lc")
                .version("1.0")
                .build();
    }
}
```

#### 1.1.3 运行项目访问

##### 旧版访问

http://ip:port/swagger-ui.html

##### 新版访问

http://ip:port/doc.html

## 2. Swagger注解

- 控制器类
  - [@Api](https://github.com/Api)(description = “用户管理”) // 控制器说明
- 控制器的方法
  - [@ApiOperation](https://github.com/ApiOperation)(value = “用户注册”) //方法的功能说明
  - [@ApiImplicitParam](https://github.com/ApiImplicitParam)(name = “user”, value = “用户对象”) // 方法的参数说明
- 实体类
  - [@ApiModel](https://github.com/ApiModel)(description = “用户实体”) // 实体类的说明
- 实体类的属性
  - [@ApiModelProperty](https://github.com/ApiModelProperty)(value = “用户编号”,required=true) // 属性说明
- 其他
  - 再类上加上[@ApiIgnore](https://github.com/ApiIgnore)，那这个类上使用的所有swagger注解都失效



```java
/**
     * 在完成上述配置之后，其实就已经可以产生帮助文档了，但是这样的文档主要针对请求本身，而描述主要来源于函数等命名产生。
     * 对用户体验不好，我们通常需要自己增加一些说明来丰富文档内容。如果：
     * 加入
     *
     * @ApiIgnore 忽略暴露的 api
     * @ApiOperation(value = "查找", notes = "根据用户 ID 查找用户")
     * 添加说明
     * <p>
     * <p>
     * 其他注解：
     * @Api ：用在类上，说明该类的作用
     * @ApiImplicitParams ：用在方法上包含一组参数说明
     * @ApiResponses ：用于表示一组响应
     * 完成上述之后，启动springboot程序，
     * 旧访问：http://localhost:8080/swagger-ui.html
     * 新访问：http://localhost:8080/doc.html
     * @ApiOperation() 用于方法；表示一个http请求的操作
     * value用于方法描述
     * notes用于提示内容
     * tags可以重新分组（视情况而用）
     * @ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
     * name–参数名
     * value–参数说明
     * required–是否必填
     * @ApiModel()用于类 ；表示对类进行说明，用于参数用实体类接收
     * value–表示对象名
     * description–描述
     * 都可省略
     * @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
     * value–字段说明
     * name–重写属性名字
     * dataType–重写属性类型
     * required–是否必填
     * example–举例说明
     * hidden–隐藏
     * @ApiIgnore()用于类或者方法上，可以不被swagger显示在页面上 比较简单, 这里不做举例
     * @ApiImplicitParam() 用于方法
     * 表示单独的请求参数
     * @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
     * name–参数ming
     * value–参数说明
     * dataType–数据类型
     * paramType–参数类型
     * example–举例说明
     */
```

