# VUE学习

## VUE-router

![image-20210613124113969](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613124113969.png)

### 嵌套路由

![image-20210613145735750](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613145735750.png)

### 路由传参

props

路径传参

​	![image-20210613150015767](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613150015767.png)

![image-20210613150056366](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613150056366.png)

### 路由重定向

​	普通重定向

​	带参数的重定向



### 路由模式

是否带#

默认hash->带#

可进行配置，不带，路由主js中，设置mode:'history'

![image-20210613150748216](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613150748216.png)

锚

![image-20210613150624950](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613150624950.png)

### 404页面设置（一定要在最下面）

![image-20210613150854253](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613150854253.png)

### 路由中的钩子函数

![image-20210613151055431](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613151055431.png)

to -- 目标

from  来源

next 放行

![image-20210613151318566](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613151318566.png)

![image-20210613151333267](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613151333267.png)

### 跨域问题

都是后台来处理

## 浏览器本身的存储功能

![image-20210613151837821](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613151837821.png)

只能存字符串

### 登录拦截

![image-20210613152205788](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613152205788.png)

## VUEX- 状态管理模式

### 安装

```
npm i vuex --save
import Vues from 'vuex'
Vue.use(Vuex)
```

### 刷新后vuex数据消失的解决方案

```
1.保存和获取。
app.vue设置监听
```

![image-20210613200119371](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613200119371.png)

### vuex的模块化

![image-20210613200258589](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210613200258589.png)



## vue cli使用

```html
-- 进行项目创建
http://localhost:8000/project/select
```

