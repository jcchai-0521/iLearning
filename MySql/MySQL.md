# MySQL

## 1. 初始MySQL

### 1.1 数据库分类

#### 1.1.1 关系型数据库

- MySQL
- Oracle
- SQL Server
- DB2
- SQLLite

#### 1.1.2 非关系型数据库（NoSQL-Not only SQL）

> 非关系型数据库，对象存储，通过对象本身的属性来决定。

- Redis
- Mon个DB

### 1.2 DBMS（数据库管理系统）

> 数据库管理系统

### 1.3 安装MySQL

#### 1.3.1 压缩包方式安装

- 解压

- 配置环境变量（Path，配置mysql的bin目录即可）

- 创建配置文件my.ini

  - ```ini
    [mysqld]
    basedir=D:\system\mysql-5.7\
    datadir=D:\system\mysql-5.7\data\
    port=3306
    skip-grant-tables
    ```

- 管理员权限执行CMD

- 安装mysql服务

  - 进入到bin目录下，执行mysqld -install

- 初始化数据库

  - ```
    mysqld --initialize-insercure --user=mysql
    ```

- 启动服务
  - net start mysql

- 登录处理
  - mysql -uroot -p

- 修改密码

  - ```sql
    update mysql.user set authentication_string=password('123456') where user='root' and Host='localhost';
    ```

- 刷新授权表
  - flush privileges;

- 删除my.ini的跳过授权表的配置：skip-grant-tables
- 重启mysql，测试连接

### 1.4 安装SQLyog

> 使用较少，暂不整理。

## 2. 数据库操作

### 2.1 操作数据库

1. 创建数据库

   ```sql
   CREATE DATABASE IF NOT EXISTS test;
   ```

2. 删除数据库

   ​	

   ```sql
   DROP DATABASE IF EXISTS test;
   ```

3. 使用数据库

   ```sql
   USE `test`
   ```

4. 查看数据库

   ```sql
   -- 查看所有的数据库
   SHOW databases;
   -- 查看某个数据库
   desc database test;
   ```

5. 查看建库/表语句

   ```sql
   show create database test;
   show create table user;
   ```

   

### 2.2 数据库表列的类型

#### 2.2.1 数值类型

| 数据类型  | 描述                                 | 字节大小            |
| --------- | ------------------------------------ | ------------------- |
| tinyint   | 十分小的数据                         | 1字节               |
| smallint  | 较小的数据                           | 2字节               |
| mediumint | 中等大小的数据                       | 3字节               |
| **int**   | 标准的整数                           | 4字节               |
| bigint    | 较大的数据                           | 8个字节             |
| float     | 浮点数                               | 4个字节             |
| double    | 浮点数                               | 8个字节（精度问题） |
| decimal   | 字符串形式的浮点数，一般用于金融计算 |                     |

#### 2.2.2 字符串类型

| 数据类型 | 描述       | 大小    |
| -------- | ---------- | ------- |
| char     | 固定长度   | 0~255   |
| varchar  | 可变字符串 | 0~65535 |
| tinytext | 微型文本   | 2^8-1   |
| text     | 文本串     | 2^16-1  |

#### 2.2.3 时间类型



| 数据类型  | 描述     | 格式                                     |
| --------- | -------- | ---------------------------------------- |
| data      | 日期格式 | YYYY-MM-DD                               |
| time      | 时间格式 | HH:mm:ss                                 |
| datatime  | 时间格式 | YYYY-MM-DD HH:mm:ss                      |
| timestamp | 时间戳   | long类型（表示从1970.1.1到现在的毫秒数） |
| year      | 年份     |                                          |

#### 2.2.4 null

> 没有值，未知
>
> 注意：不要使用null进行计算，结果也是null

### 2.3 数据库的字段属性（重要）

- unsigned
  - 无符号的整数
  - 声明了该列不能声明为负数
- zerofill
  - 0填充
  - 不足的位数，使用0进行填充。int（3） 5—>005
- 自增
  - 通常理解为自增，自动在上一条记录的基础上+1（1，为步长，可修改）
  - 通常用来设计唯一的主键，必须是整数类型
  - 可自定义设计主键自增的起始值和步长
- 非空
  - null和not null

### 2.4 注意事项

```sql
-- 每张表必须要有的五个字段
-- id 			主键
-- version 		乐观锁
-- is_delete	伪删除
-- gmt_create	创建时间
-- gmt_upadte 	修改时间
```

### 2.5 创建数据库表

![image-20210718214914052](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210718214914052.png)

### 2.6 数据表的类型

- innodb
- myisam

#### 2.6.1 两者比较

|            | MYISAM     | INNODB               |
| ---------- | ---------- | -------------------- |
| 事务支持   | 不支持     | 支持                 |
| 锁         | 表级别的锁 | 行级别锁             |
| 外键约束   | 不支持     | 支持                 |
| 全文索引   | 支持       | 不支持               |
| 表空间大小 | 较小       | 较大，是MYIASM的两倍 |

#### 2.6.2 常规使用操作

- MYIASM 节约空间，查询速度快
- INNODB 安全性高，支持事务，支持多表多用户操作

#### 2.6.3 物理文件的差异

> 所有的数据库文件都存在data目录下，一个文件夹就对应一个数据库。
>
> 数据库本质还是文件的存储！

- INNODB
  - 在data目录下只有一个*.frm文件，以及上级目录下的ibadata1文件
- MyISAM
  - *.frm 表结构定义文件
  - *.myd 数据文件
  - *.myi 索引文件

#### 2.6.4 数据库字符集编码

> 建表时，如果不设置字符集编码的话，会使用mysql默认的字符集编码（Latin1），不支持中文！

- 配置默认的字符集编码
  - 在my.ini中，增加配置：character-set-server=utf-8



### 2.7 表的相关操作

```sql
-- 修改表名
alter table teacher rename as user_teacher;

-- 增加表字段
alter table user_teacher add age int(3) comment '年龄';

-- 修改表的字段，修改约束
alter table user_teacher modify age varchar(3);

-- 重命名字段
alter table user_teacher change age u_age int(3);

-- 删除表字段
alter table user_teacher drop u_age;

-- 删除表
drop table if exists user_teacher;
```

## 3. MySql的数据管理

### 3.1 外键（约束）

> 【阿里巴巴开发手册】不得使用外键与级联，一切外键概念必须在应用层解决！

> 【原因】每次做delete或者update的时候都必须要考虑外键约束，会导致开发的时候很痛苦，测试数据极为不方便！

![image-20210721222255068](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210721222255068.png)

![image-20210721222659516](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210721222659516.png)

### 3.2 DML语言（数据库操作语言）

- 添加-insert

  - ```sql
    -- 单次插入多条数据
    insert into grage (name) values ('大一'),('大二'),('大三')
    ```

    - values前面是可以省略的，不写就是默认所有字段。

- 修改-update

- 删除-delete

### 3.3 delete和truncate的区别

- 相同点
  - 都会删除数据
- 不同点
  - truncate会将自增列重置。
  - truncate不会影响事务

## 4. DQL 数据库查询语言

- 基础查询
- 条件查询
- 排序查询

### 4.1 基础查询

```sql
select 列表 from 表;
# 去重
select distinct from 表;
# 如果某个字段为null,赋值默认值0
select ifnull(字段名,0) as 别名 from 表;
```

### 4.2 条件查询

#### 4.2.1 条件运算符

- < 
- ">"
- =
- <>
- ">="
- <=
- !=
- <=>

#### 4.2.2 逻辑运算符

- and 
- or
- not

#### 4.2.3 模糊查询

- like
  - %
  - _
- between and 
- in 具体的一个或多个值
- is null
- is not null

```sql
# 模糊查询带_的数据，$ 相当于转义字符，跟后面的 ESCAPE 保存一致
select * from 表 where 字段 like '_$_%' ESCAPE '$';
# 范围查询 包含临界值 
select * from where 字段 between 100 and 200;
select * from where 字段 not between 100 and 200;
```



### 4.3 排序查询

### 4.4 联表查询Join（重点）

> 七种JSON理论

![image-20210802223832826](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210802223832826.png)

#### 4.4.1 左连接、右连接、内连接的区别

| 操作       | 描述                                                   |
| ---------- | ------------------------------------------------------ |
| inner join | 如果表中至少有一个，就返回行                           |
| left join  | 以左表为准，会将坐标中返回所有的值，即使右表中没有匹配 |
| right join | 以右表为准，会从右表中返回所有的值，即使左表中没有匹配 |

#### 4.4.2 多表联查

> 当操作两张表进行联合查询时，要进行分析，拆分两个两个的表进行联合查询处理。



#### 4.4.3 自连接

> 自己的表和自己的表连接，核心：一张表拆分为两张一样的表即可。

![image-20210803213038711](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210803213038711.png)

### 4.5 分页和排序

#### 4.5.1 排序

- 升序
  - ASC
- 降序
  - DESC

#### 4.5.2 分页

Limit index, pageSize

### 4.6 子查询

![image-20210803215745138](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210803215745138.png)

## 5. 函数

### 5.1 常用函数

#### 5.1.1 数学函数

```sql
-- 绝对值
select abs(-8);
-- 向上取整
select ceiling(9.4);
-- 向下取整
select floor(9.4);
-- 返回0~1之间的随机数
select rand();
-- 判断一个数的符号
select sign(10);0—>0 -10—>-1 10—>1
```

#### 5.1.2 字符串函数

```

```

![image-20210803221535520](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210803221535520.png)

#### 5.1.3 时间和日期函数

```

```

![image-20210803221742292](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210803221742292.png)

### 5.2 聚合函数





- concat 拼接 

  - ```sql
    select concat('姓名：', 列表) as 新名字 from 表;
    ```

- distinct 去重，放在最前面，对查询结果中的重复的数据去重处理

  - ```sql
    select distinct 字段 from 表名;
    ```

- version()

