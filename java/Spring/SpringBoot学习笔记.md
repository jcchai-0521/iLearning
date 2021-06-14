# SpringBoot学习笔记

## 相关依赖

### pom依赖

```

```



## application的相关配置

### application.yml配置

```yml
# DataSource Config
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://192.168.237.138:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: blog
    password: blog
mybatis-plus:
  mapper-locations: classpath*:/mapper/**Mapper.xml
server:
  port: 9081
```



### application.properties配置



## 跨域

###  方式一：SpringBoot统一配置管理

```java
// 新增跨域配置
/**
 * 跨域全局配置
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{
    /**
     * 配置跨域信息
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        /**
         * 1.访问路径
         * 2.请求来源
         * 3.请求方法
         * 4.是否允许携带（证书、token等）
         * 5.最大响应时间
         */
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "null")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
```



## 个性化的配置

```html
-- 服务调度任务配置
http://cron.qqe2.com
--Banner生成
http://www.bootschool.net/ascii
```

