# CSS笔记

## 1. 学习目标

- CSS是什么
- CSS怎么用
- CSS选择器
- 美化网页（文字、阴影、超链接、列表、渐变……）
- 盒子模型
- 浮动
- 定位
- 网页动画等

> 将菜鸟教程的相关CSS内容学习了解一遍。

## 2. CSS是什么

Cascading Style sheet 层叠样式表

### 2.2 发展史

- CSS 1.0 
- CSS 2.0 DIV（块） + CSS，HTML与CSS结构分离的思想，网页变得简单，易于SEO
- CSS 2.1 浮动、定位
- CSS 3.0 圆角、阴影、动画等（需要关注浏览器的兼容性）

## 3. 语法

### 3.1 基础语法

```css
<style>
	选择器{
        @import url("相对路径");
		声明1;
		声明2;
		声明3;
	}
<style>
```

### 3.2 Html与CSS分离

```css
/*使用link标签*/
<link rel="stylesheet" href="相对路径" />
```

## 4. CSS的优势

1. 内容和表现分离
2. 网页结构表现统一，可以实现服用
3. 样式十分丰富
4. 建立使用独立于HTML的css文件
5. 利用SEO，容易被搜索引擎收录！

## 5. 样式优先级

1. 行内样式
2. 内部样式（style标签）
3. 外部样式（外部css文件）

> 优先级：就近原则。外部样式和内部样式的位置决定谁的优先级更高！
>
> 链接式，使用的较少。是CSS2.1 版本特有的

## 6. 选择器（重点）

> 作用：选择页面上的某一个或者某一类元素

### 6.1 基本选择器

- 标签选择器

- 类选择器

- id选择器

  > 选择器的优先级：ID选择器 > 类选择器 > 标签选择器 

### 6.2 层次选择器

6.2.1 后代选择器

```css
body p{
	backgroud:red;
}
```

6.2.2 子选择器

```css
body>p{
	background:green;
}
```

6.2.3 相邻兄弟选择器（向下，只选一个）

```css
.active + p{
	background:black;
}
```

6.2.4 通用选择器（选中元素往下所有的兄弟元素）

```css
.active~p{
	background:yellow;
}
```

### 6.3 结构伪类选择器

> 伪类用来过滤条件

```css
/*ul下第一个和最后一个li*/
ul li:first-child{
    background:white;
}

ul li:last-child{
    background:blue;
}

/*选中p元素父级的第一个元素，并且是当前元素生效*/
p:nth-child(1){
    
}

/*选中父元素下的p元素类型的第二个*/
p:nth-of-type(2){
    
}
```

### 6.4 属性选择器

```css
/*存在id属性的元素*/
a[id]{
    background:yellow;
}

/*id属性等于first的元素*/
a[id=first]{
    background:yellow;
}

/*class属性中包含links
= 表示绝对等于
*= 包含
^= 以*开头
$= 以*结尾
*/
a[class*=links]{
    background:yellow;
}

/*href属性中以http开头*/
a[href^=http]{
	background:yellow;
}

/*以pdf结尾的属性*/
a[href$=pdf]{
    
}
```

## 7. 美化网页

### 7.1 为什么要美化网页

1. 有效的传递页面信息
2. 美化网页，网页漂亮才能吸引用户
3. 凸显页面主题
4. 提高用户的体验

### 7.2 字体样式

```
斜体 粗体 字号/行高 字体
```

### 7.3 文本样式

- 颜色
  - color
- 文本对齐方式
  - text-align
- 首行缩进
  - text-indent:2em
- 行高（块的高度和行高相等的话就可以垂直居中）
  - line-height
- 装饰（下划线、删除线等）
  - text-decoration :underline;line-through;overline

- 阴影
  - text-shadow:阴影颜色、水平偏移、垂直偏移，阴影半径

### 7.4 颜色

```
1.英文单词
2.RGB（red green blue）:
	#000000
	#FFFFFF
	#00FFFF
	#FF0000
	rgb(0, 255, 255)
	0-F
	0-255
	
3.RBGA(A表示透明度)
	取值范围0-1
	rgba(0,255,255,0.5)
```

### 7.5 超链接伪类

```css
/*悬停*/
a:hover{}
/*鼠标按住不放开*/
a:active{}
/*未访问*/
a:link{}
/*访问后*/
a:visited{}
```

> 写a标签样式的同时一般会写a:hover的样式

### 7.6 列表

- 取消有序/无须列表的圆点/序号
  - list-style:none;

### 7.7 背景

```css
/*默认平铺*/
background-image:url("img/a.jpg")
/*水平平铺*/
background-repeat:repeat-x
/*垂直平铺*/
background-repeat:repeat-y
/*	no-repeat;*/

/*background的组合写法
	颜色
	背景图
	x轴定位
	y轴定位
	平铺方式
*/
background: red url("") 200px 10px no-repeat;
background-position: 200px 10px;
```

### 7.8 渐变

- 径向渐变
- 圆形渐变

> 直接使用已经实现的渐变内容即可。

## 8. 盒子模型

- margin 外边距
- border 边框
  - 粗细、样式、颜色
- padding 内边距

> 一般都先会将样式初始化

### 8.1 边框

### 8.2 外边距

- 元素居中（块元素、且宽度有具体数值）
  - margin: 0 auto;

### 8.3 内边距

### 8.4 圆角边框

- 头像

### 8.5 阴影

- box-shadow : 10px 10px 100px yellow
- 盒子背景闪光

## 9. 浮动

### 9.1 标准文档流

- 块级元素

  - h1-h6
  - p
  - div
  - ……

- 行内元素

  - img
  - a
  - span
  - strong
  - ……

  > 块级元素内可以包含行内元素，行内元素则不能包含块级元素

### 9.2 display

- display:block; 设置行内元素变成块元素
- display:inline-block; 时块元素，但是可以行内联
- display:inline;
- display:none;

### 9.3 浮动float

清除浮动

- clear:both;

- **使用float就需要考虑父级边框塌陷的问题**

### 9.4 clear 清除浮动

clear属性

- right 右侧不允许有浮动
- left
- both 两侧不允许有浮动，可以单独一行
- none;

### 9.5 父级边框塌陷问题

- 增加父级元素的高度
- 空div，清除浮动
- 使用overflow
  - overflow:hidden;

- 父类添加伪类（推荐使用的方式）

  - ```css
    #father:after{
    	content: "";
    	display:block;
    	clear:both;
    }
    ```

#### 9.5.1 overflow

#### 9.5.2 小结

> 解决父级边框塌陷的问题

1. 浮动元素后增加空div，并设置样式clear:both;
2. 设置父元素的高度
3. 设置父元素设置属性overflow：hidden，进行切除
4. 父类增加伪类，其实是对第一个方法的css实现（推荐使用）

## 10. 定位

### 10.1 定位类型

- 相对定位 position：relative

  - 是相对于自己之前的位置进行指定的偏移。

  - top

  - right

  - bottom

  - right

  - > 相对定位的话，它仍然在标准文档流中，原来的位置会被保留。

- 绝对定位

  - position:absolute;

  - 没有父元素的绝对定位下，相对是相对于浏览器

  - 在父级元素内进行移动，一般不存在复制

  - > 绝对定位，不保留原来的位置。

- 固定定位fixed
  - 导航栏，返回顶部
- z-index
  - 图层0-999



### 10.2 测试代码

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body, div,a{
            margin: 0;
            padding: 0;
        }

        #box{
            width: 300px;
            height: 300px;
            margin: 0 auto;
            border: 0px solid #000;
        }

        a{
            text-decoration: none;
            display: block;
            width: 100px;
            height: 100px;
            color: #bc94d7;
            border: 0px;
            line-height: 100px;
            text-align: center;
        }
        a:hover{
            background: aqua;
        }

        .a-center{

        }

        .a2, .a4{
            position: relative;
            left: 200px;
            top: -100px;
        }

        .a5{
            position: relative;
            top: -300px;
            left: 100px;
        }

    </style>
</head>
<body>
    <div id="box">
        <a href="#" class="a1">链接一</a>
        <a href="#" class="a2">链接二</a>
        <a href="#" class="a-center">链接三</a>
        <a href="#" class="a4">链接四</a>
        <a href="#" class="a5">链接五</a>
    </div>
</body>
</html>
```



## 11. 动画

## 相关样式积累

- 设置圆角
  - border-radius:24px;
    - 左上 右上 右下 左下
  
- 水平对齐
  - 需要有参照物，比如：span和img
    - img,span{vertical-align:middle}

- a标签去掉下划线
  - text-decoration:none;

- 透明
  - opacity 0-1;
  - filter:alpha(opacity=50)   (IE8)



```





font-size
font-weight
text-indent
line-height
list-style:none;
```

## 网站积累

```
https://www.grabient.com/
-- 渐变图示
模板之家
Element
飞冰

门户网站
后台管理网站

https://processon.com/
-- 在线绘图
```

