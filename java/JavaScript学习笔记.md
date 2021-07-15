# JavaScript学习笔记

## 1. CSS预处理器

> 用一种专门的编程语言，进行web页面样式设计，再通过编辑器转化为正常的CSS文件，以供项目使用。

- SASS：基于Ruby，通过服务端处理，功能强大，解析效率高。需要学习Ruby语言，上手难度高于LESS。
- LESS：基于nodejs，通过客户端处理，使用简单，功能比SASS简单，解析效率也低于SASS，但在实际开发中足够了，所以我们后台人员如果需要的话，建议使用LESS。

## 2. JS（了解）

- ES5（全部浏览器都支持）
- ES6（主流浏览器支持）

### 2.1 JS框架

jQuery

Angular

React

VUE

Axios

### 2.2 UI框架

- Ant-design 阿里巴巴出品，基于React的UI框架
- Element-ui、Iview、ice：饿了么出品，基于VUE的UI框架
- Bootstrap Twitter退出的一个用于前端开发的开源工具包
- AmazeUI：妹子UI，一块H5跨前端框架

### 2.3 JS构建工具

- Babel：JS编译工具，主要用于浏览器不支持的ES新特性，比如用于编译TypeScript
- WebPack：模块打包器，主要用于打包、压缩、合并及按序加载

### 2.4 三端统一 混合开发（Hybrid App）

> 主要目的是实现一套代码三端统一（PC、Android、.apl、IOS：.ipa）并能够调用到设备底层硬件（如：传感器、GPS、摄像头等）。

打包方式：

- 云打包：HBuild—>HBuildX，DCloud出品；API Cloud
- 本地打包：Cordova（前身是PhoneGap）

### 2.5 后端技术

- Express ：NodeJs框架
- Koa：简化的Express
- NPM：项目综合管理工具，类似Maven
- YARN：NPM的替代方案，类似Maven和Gradle的关系。

### 2.6 主流前端框架

**VUE**

等等，还未整理完成……

## 3. JavaScript（ECMAScript）

### 3.1 基本语法

- 所有变量的定义都使用var

### 3.2 数据类型

- number （不区分整数和小数）
  - NaN not a number
  - Infinity 无穷大
  - isNaN(NaN) 判断是否是NaN
  - 精度损失问题（应尽量避免浮点数进行计算处理）

- 字符串

- 布尔值

- 逻辑运算

- 比较运算符

  - =

  - == 类型可以不一样，值一样即可

  - === 

  - > 坚持不要使用==

- null 空
- undefined 未定义
- 数组[]
  - 定义方式尽量使用[]方式

- 对象{}

#### 3.2.1 字符串

- 转义字符 \
  - ASCll字符  \x41
  - unicode字符： \uxxxx lu4e2d

- 多行字符串编写

  - `反引号

  - ```javascript
    var a = `adshad
    dasdsada
    asdadasd`;
    console.log(a);
    ```

- 模板字符串

  - ```javascript
    let name = "xiaohuihui";
    let age = 3;
    let msg = `你好啊，${name}`;
    ```

- 字符串属性
- 字符串的可变性
  - 不可变
- 大小写转换

- indexOf
- substring

#### 3.2.2 数组

> Array可以包含任意的数据类型

![image-20210704221901235](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210704221901235.png)

- 长度可赋值修改
  - 如果赋值长度小于原有的数组长度，那么元素会丢失

- indexOf
- slice数组截取，返回一个新的数组
- push添加元素
- pop 弹出尾部一个数据
- unshift 压入头部数据
- shift 弹出头部数据
- sort 排序
- reverse 元素反转
- contact 拼接，返回一个新的数组
  - contact([1,2,3])

- join 使用特殊的字符打印数组信息
- 多维数组[][]

### 3.3 对象

- 对象赋值，直接使用=进行赋值即可
- 使用一个不存在的对象属性时，不会报错。值为undefined
- 动态删减属性 delete 对象.属性名
- 动态添加属性 
  - 直接对象.新属性即可

- 判断属性值是否在这个对象中
  - "属性名" in 对象 
  - js中所有的属性名都是字符串类型
  - 对象.hasOwnProperty("属性名")

### 3.4 流程控制（其他内容都是和java相似）

- if
- 循环
  - while循环
  - for循环
  - do-while
  - forEach(function (item){})
  - for(var num in array)   num是索引！！！
  - for (var val of array) val就是具体的值

### 3.5 Map和Set（ES6新增）

#### 3.5.1 Map

```javascript
var map = new Map();
map .set("admin", "123456");
console.log(map.get("admin"));

// 遍历处理
for (var val of map)
```

#### 3.5.2 Set集合

```javascript
// 去重处理
var set = new Set([1,2,3,4,1]);
set.set(1);
set.delete(key);
set.has(key);
```



### 3.4 严格检查模式Strick

```javascript
// 使用严格检查模式，预防js的随意性导致产生的一些问题。
// 必须写在js文件的第一行
"use strick";
```

- 局部变量建议使用let去定义



## 4. 函数

### 4.1 参数问题arguments

>  如果参数不匹配时，可以通过arguments来获取相关参数

### 4.2 获取多余的参数rest(ES6特性)

```javascript
function abs(a, b, ...rest)
{
	
}
```

### 4.3 变量的作用域

#### 4.3.1 全局变量

- window是最大的全局变量

- 方法也可以看做是全局变量的一个属性

- 所有的全局变量都会绑定到window上

  - 如果不同的js文件中使用了相同的全局变量，如何减少冲突？

    - 一般定义一个唯一全局变量

    - ```javascript
      var globalVar = {}
      globalVar.name = "";
      globalVar.add = function(a, b){
          return a + b;
      }
      ```

#### 4.3.2 局部变量

- 关键字 let(ES6新特性)

- 测试代码

  - ```javascript
    function add()
    {
        for (var i =0; i <=100; i++)
        {
            console.log(i);
        }
        
        // 此处，i已经出了作用域，但是依然能够使用
        console.log(i + 1);
    }
    
    // 如果使用let，则可以保证局部变量的作用域。建议使用let来定义局部变量
    ```

- 作用域提升

  - ```javascript
    function test()
    {
      var x = "q" + y;
      console.log(x);
      var y = "y";
    }
    
    test();
    ```

    - ```
      qundefined
      ```

  - js执行引擎，自动提升了y的声明，但是不会提升变量的赋值

    - ```javascript
      function test()
      {
      	var y;
        	var x = "q" + y;
        	console.log(x);
        	y = "y";
      }
      ```

      

#### 4.3.3 常量（只读变量）

> 在ES6之前，定义常量的方式：
>
> ​		只有使用全部大写字母命令的变量就是常量；

- ES6新增关键字：const

### 4.4 方法

> 方法就是把函数放在对象里面，对象只有两个东西：属性和方法

```javascript
var test = {
    name: "abc",
    birth: 2000,
    age: function()
    {
        return new Date().getFullYear() - this.birth;
    }
}
```

#### 4.4.2 写法二

```javascript
function getAge()
{
    return new Date().getFullYear() - this.birth;
}

var test = {
    name: "abc",
    birth: 2000,
    age: getAge
}

// test.getAge();
// getAge() —> NaN
```

### 4.5 使用apply进行this对象的指定

```javascript
// 这样，就可以将this指向test对象，执行getAge时，this.birth就是获取的test对象的属性
getAge.apply(test, [])
```

### 4.6 内部对象

> 标准对象

```javascript
typeof 123;
typeof "abc";
typeof [];
typeof {};
typeof true;
typeof NaN;
typeof Math.abs;
typeof undefined;
```

#### 4.6.1 Date

- getMonth() --0~11月
- getTime() -- 时间戳
  - new Date(1626099892286);

#### 4.6.2 JSON (了解BOSN，二进制的JSON)

- javaScript Object Notation JS对象简谱，是一种轻量级的数据交换格式
- 简介和清晰的层次结构使得JSON成为理想的数据交换语言
- 易于人阅读和编写，同时也易于机器解析和生成，并有效地提升网络传输效率

##### 4.6.2.1 对象转JSON

```javascript
JSON.stringify(obj);
```

##### 4.6.2.2 JSON转对象

```javascript
JSON.parse('{"name": "hehe"}')
```

## 5. 面向对象编程

### 5.1 原型继承

```javascript
var Student = {
    name: "呵呵",
    age: 18,
    run: function()
    {
        console.log(this.name + " run....");
    }
};

var xaioming = {
    name: "xiaoming"
};

// 通过原型设置，实现的继承的功能
xiaoming._proto_ = Student;
```

### 5.2 class继承

> ES6新增class关键字，本质还是_proto_

```javascript
class Student{
    constructor(name){
        this.name = name;
    }
}

class XiaoStudent extends Student{
    constructor(name, age){
        super(name);
        this.age = age;
    }
}
```

### 5.3 原型链

> 在JavaScript中，每个函数都有一个prototype属性，这个属性指向函数的原型对象。

- 构造函数
- 原型
- 实例

> 每个构造函数都有一个原型对象，原型对象都包含一个指向构造函数的指针，而实例都包含一个执行原型对象的内部指针，那么加入我们让原型对象等于另一个类型的实例，结果会怎样？显然，此时的原型对象将包含一个执行另一个原型的指针，相应的，另一个原型中也包含着一个指向另一个构造函数的指针。假设另一个原型又是另一个类型的实例，那么上述关系依然成立。如此层层递进，就构成了实例与原型的链条。这就是所谓的原型链。

> Object.prototype._proto_ === null

#### 5.3.1 null和undefined的区别

- [ ] ![image-20210713214722177](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210713214722177.png)

## 6. 操作BOM对象（重点）

> BOM：浏览器对象模型

### 6.1 window对象（重要）

> window表示浏览器窗口

### 6.2 navigator

> 可查看浏览器版本
>
> 不建议这些属性来判断和编写代码，原因是可以进行修改处理！！！

### 6.3 screen

> 代表屏幕尺寸

- screen.width
- screen.height

### 6.4 location（重要）

> 当前页面的URL信息

- host
- href
- protocol
- reload()  // 刷新页面
- location.assign("http://xxx.com"); // 页面跳转

### 6.5 document

> document代表当前的页面，HTML的DOM文档树

### 6.6 history（不建议使用）

> 历史记录

- history.forward()
- history.back()

## 7. DOM操作

> 文档对象模型。整个浏览器网页就是一个DOM树形结构

- 更新

- 遍历

- 删除
  - 先获取父节点，然后通过父节点删除自己

- 添加
  - append
  - createElement
  - insertBefore--插入

## 8. 操作表单（验证）

> 表单的目的，就是为了提交数据。

### 8.1 提交表单

> MD5加密密码处理
>
> https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.js

```javascript
/*
 * JavaScript MD5
 * https://github.com/blueimp/JavaScript-MD5
 *
 * Copyright 2011, Sebastian Tschan
 * https://blueimp.net
 *
 * Licensed under the MIT license:
 * https://opensource.org/licenses/MIT
 *
 * Based on
 * A JavaScript implementation of the RSA Data Security, Inc. MD5 Message
 * Digest Algorithm, as defined in RFC 1321.
 * Version 2.2 Copyright (C) Paul Johnston 1999 - 2009
 * Other contributors: Greg Holt, Andrew Kepert, Ydnar, Lostinet
 * Distributed under the BSD License
 * See http://pajhome.org.uk/crypt/md5 for more info.
 */

/* global define */

;(function ($) {
  'use strict'

  /*
  * Add integers, wrapping at 2^32. This uses 16-bit operations internally
  * to work around bugs in some JS interpreters.
  */
  function safeAdd (x, y) {
    var lsw = (x & 0xffff) + (y & 0xffff)
    var msw = (x >> 16) + (y >> 16) + (lsw >> 16)
    return (msw << 16) | (lsw & 0xffff)
  }

  /*
  * Bitwise rotate a 32-bit number to the left.
  */
  function bitRotateLeft (num, cnt) {
    return (num << cnt) | (num >>> (32 - cnt))
  }

  /*
  * These functions implement the four basic operations the algorithm uses.
  */
  function md5cmn (q, a, b, x, s, t) {
    return safeAdd(bitRotateLeft(safeAdd(safeAdd(a, q), safeAdd(x, t)), s), b)
  }
  function md5ff (a, b, c, d, x, s, t) {
    return md5cmn((b & c) | (~b & d), a, b, x, s, t)
  }
  function md5gg (a, b, c, d, x, s, t) {
    return md5cmn((b & d) | (c & ~d), a, b, x, s, t)
  }
  function md5hh (a, b, c, d, x, s, t) {
    return md5cmn(b ^ c ^ d, a, b, x, s, t)
  }
  function md5ii (a, b, c, d, x, s, t) {
    return md5cmn(c ^ (b | ~d), a, b, x, s, t)
  }

  /*
  * Calculate the MD5 of an array of little-endian words, and a bit length.
  */
  function binlMD5 (x, len) {
    /* append padding */
    x[len >> 5] |= 0x80 << (len % 32)
    x[((len + 64) >>> 9 << 4) + 14] = len

    var i
    var olda
    var oldb
    var oldc
    var oldd
    var a = 1732584193
    var b = -271733879
    var c = -1732584194
    var d = 271733878

    for (i = 0; i < x.length; i += 16) {
      olda = a
      oldb = b
      oldc = c
      oldd = d

      a = md5ff(a, b, c, d, x[i], 7, -680876936)
      d = md5ff(d, a, b, c, x[i + 1], 12, -389564586)
      c = md5ff(c, d, a, b, x[i + 2], 17, 606105819)
      b = md5ff(b, c, d, a, x[i + 3], 22, -1044525330)
      a = md5ff(a, b, c, d, x[i + 4], 7, -176418897)
      d = md5ff(d, a, b, c, x[i + 5], 12, 1200080426)
      c = md5ff(c, d, a, b, x[i + 6], 17, -1473231341)
      b = md5ff(b, c, d, a, x[i + 7], 22, -45705983)
      a = md5ff(a, b, c, d, x[i + 8], 7, 1770035416)
      d = md5ff(d, a, b, c, x[i + 9], 12, -1958414417)
      c = md5ff(c, d, a, b, x[i + 10], 17, -42063)
      b = md5ff(b, c, d, a, x[i + 11], 22, -1990404162)
      a = md5ff(a, b, c, d, x[i + 12], 7, 1804603682)
      d = md5ff(d, a, b, c, x[i + 13], 12, -40341101)
      c = md5ff(c, d, a, b, x[i + 14], 17, -1502002290)
      b = md5ff(b, c, d, a, x[i + 15], 22, 1236535329)

      a = md5gg(a, b, c, d, x[i + 1], 5, -165796510)
      d = md5gg(d, a, b, c, x[i + 6], 9, -1069501632)
      c = md5gg(c, d, a, b, x[i + 11], 14, 643717713)
      b = md5gg(b, c, d, a, x[i], 20, -373897302)
      a = md5gg(a, b, c, d, x[i + 5], 5, -701558691)
      d = md5gg(d, a, b, c, x[i + 10], 9, 38016083)
      c = md5gg(c, d, a, b, x[i + 15], 14, -660478335)
      b = md5gg(b, c, d, a, x[i + 4], 20, -405537848)
      a = md5gg(a, b, c, d, x[i + 9], 5, 568446438)
      d = md5gg(d, a, b, c, x[i + 14], 9, -1019803690)
      c = md5gg(c, d, a, b, x[i + 3], 14, -187363961)
      b = md5gg(b, c, d, a, x[i + 8], 20, 1163531501)
      a = md5gg(a, b, c, d, x[i + 13], 5, -1444681467)
      d = md5gg(d, a, b, c, x[i + 2], 9, -51403784)
      c = md5gg(c, d, a, b, x[i + 7], 14, 1735328473)
      b = md5gg(b, c, d, a, x[i + 12], 20, -1926607734)

      a = md5hh(a, b, c, d, x[i + 5], 4, -378558)
      d = md5hh(d, a, b, c, x[i + 8], 11, -2022574463)
      c = md5hh(c, d, a, b, x[i + 11], 16, 1839030562)
      b = md5hh(b, c, d, a, x[i + 14], 23, -35309556)
      a = md5hh(a, b, c, d, x[i + 1], 4, -1530992060)
      d = md5hh(d, a, b, c, x[i + 4], 11, 1272893353)
      c = md5hh(c, d, a, b, x[i + 7], 16, -155497632)
      b = md5hh(b, c, d, a, x[i + 10], 23, -1094730640)
      a = md5hh(a, b, c, d, x[i + 13], 4, 681279174)
      d = md5hh(d, a, b, c, x[i], 11, -358537222)
      c = md5hh(c, d, a, b, x[i + 3], 16, -722521979)
      b = md5hh(b, c, d, a, x[i + 6], 23, 76029189)
      a = md5hh(a, b, c, d, x[i + 9], 4, -640364487)
      d = md5hh(d, a, b, c, x[i + 12], 11, -421815835)
      c = md5hh(c, d, a, b, x[i + 15], 16, 530742520)
      b = md5hh(b, c, d, a, x[i + 2], 23, -995338651)

      a = md5ii(a, b, c, d, x[i], 6, -198630844)
      d = md5ii(d, a, b, c, x[i + 7], 10, 1126891415)
      c = md5ii(c, d, a, b, x[i + 14], 15, -1416354905)
      b = md5ii(b, c, d, a, x[i + 5], 21, -57434055)
      a = md5ii(a, b, c, d, x[i + 12], 6, 1700485571)
      d = md5ii(d, a, b, c, x[i + 3], 10, -1894986606)
      c = md5ii(c, d, a, b, x[i + 10], 15, -1051523)
      b = md5ii(b, c, d, a, x[i + 1], 21, -2054922799)
      a = md5ii(a, b, c, d, x[i + 8], 6, 1873313359)
      d = md5ii(d, a, b, c, x[i + 15], 10, -30611744)
      c = md5ii(c, d, a, b, x[i + 6], 15, -1560198380)
      b = md5ii(b, c, d, a, x[i + 13], 21, 1309151649)
      a = md5ii(a, b, c, d, x[i + 4], 6, -145523070)
      d = md5ii(d, a, b, c, x[i + 11], 10, -1120210379)
      c = md5ii(c, d, a, b, x[i + 2], 15, 718787259)
      b = md5ii(b, c, d, a, x[i + 9], 21, -343485551)

      a = safeAdd(a, olda)
      b = safeAdd(b, oldb)
      c = safeAdd(c, oldc)
      d = safeAdd(d, oldd)
    }
    return [a, b, c, d]
  }

  /*
  * Convert an array of little-endian words to a string
  */
  function binl2rstr (input) {
    var i
    var output = ''
    var length32 = input.length * 32
    for (i = 0; i < length32; i += 8) {
      output += String.fromCharCode((input[i >> 5] >>> (i % 32)) & 0xff)
    }
    return output
  }

  /*
  * Convert a raw string to an array of little-endian words
  * Characters >255 have their high-byte silently ignored.
  */
  function rstr2binl (input) {
    var i
    var output = []
    output[(input.length >> 2) - 1] = undefined
    for (i = 0; i < output.length; i += 1) {
      output[i] = 0
    }
    var length8 = input.length * 8
    for (i = 0; i < length8; i += 8) {
      output[i >> 5] |= (input.charCodeAt(i / 8) & 0xff) << (i % 32)
    }
    return output
  }

  /*
  * Calculate the MD5 of a raw string
  */
  function rstrMD5 (s) {
    return binl2rstr(binlMD5(rstr2binl(s), s.length * 8))
  }

  /*
  * Calculate the HMAC-MD5, of a key and some data (raw strings)
  */
  function rstrHMACMD5 (key, data) {
    var i
    var bkey = rstr2binl(key)
    var ipad = []
    var opad = []
    var hash
    ipad[15] = opad[15] = undefined
    if (bkey.length > 16) {
      bkey = binlMD5(bkey, key.length * 8)
    }
    for (i = 0; i < 16; i += 1) {
      ipad[i] = bkey[i] ^ 0x36363636
      opad[i] = bkey[i] ^ 0x5c5c5c5c
    }
    hash = binlMD5(ipad.concat(rstr2binl(data)), 512 + data.length * 8)
    return binl2rstr(binlMD5(opad.concat(hash), 512 + 128))
  }

  /*
  * Convert a raw string to a hex string
  */
  function rstr2hex (input) {
    var hexTab = '0123456789abcdef'
    var output = ''
    var x
    var i
    for (i = 0; i < input.length; i += 1) {
      x = input.charCodeAt(i)
      output += hexTab.charAt((x >>> 4) & 0x0f) + hexTab.charAt(x & 0x0f)
    }
    return output
  }

  /*
  * Encode a string as utf-8
  */
  function str2rstrUTF8 (input) {
    return unescape(encodeURIComponent(input))
  }

  /*
  * Take string arguments and return either raw or hex encoded strings
  */
  function rawMD5 (s) {
    return rstrMD5(str2rstrUTF8(s))
  }
  function hexMD5 (s) {
    return rstr2hex(rawMD5(s))
  }
  function rawHMACMD5 (k, d) {
    return rstrHMACMD5(str2rstrUTF8(k), str2rstrUTF8(d))
  }
  function hexHMACMD5 (k, d) {
    return rstr2hex(rawHMACMD5(k, d))
  }

  function md5 (string, key, raw) {
    if (!key) {
      if (!raw) {
        return hexMD5(string)
      }
      return rawMD5(string)
    }
    if (!raw) {
      return hexHMACMD5(key, string)
    }
    return rawHMACMD5(key, string)
  }

  if (typeof define === 'function' && define.amd) {
    define(function () {
      return md5
    })
  } else if (typeof module === 'object' && module.exports) {
    module.exports = md5
  } else {
    $.md5 = md5
  }
})(this)
```

### 8.2 密码加密处理小技巧

- 密码输入框不设置name属性
  - 这样可以保证抓包时获取不到密码信息
  - 同时也可以让密码框不进行闪烁
- 设置一个隐藏域来保存密码输入框的md5加密后的字符串信息

## 9. jQuery

> jQuery就是javascript封装的方法库。write less，do more。
>
> cdn
>
> https://jquery.cuishifeng.cn/

## 其他

IDEA设置ES版本：Settings—>languages & Frameworks —>Javascript—>JavaScript Languages Version

![image-20210704214235733](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20210704214235733.png)
