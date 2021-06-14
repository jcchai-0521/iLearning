## 配置步骤

1. 首先复制该路径`C:\Windows\System32\drivers\etc`，然后在窗口底部的搜索栏，搜索 **记事本** ，点击 **以管理员身份运行** 进入编辑界面，点击界面左上角的 **文件** ，再点击 **打开** ，会出现文件选择面板，将刚才复制的路径，粘贴到地址栏并回车，跳转后将直达`C:\Windows\System32\drivers\etc`文件夹，右下角选择打开文件类型为 **所有文件（\*.\*）** ，此时会出现`hosts`文件，选择并打开，进入编辑页面，后续步骤将对该文件进行修改并保存。
2. 点击打开 [DNS查询](https://myssl.com/dns_check.html) 网页，按住 `Ctrl+Shift+I` 后，将会弹出控制台，也叫 `Console` ，此时控制台可能会有很多信息妨碍视线，可以通过 `Ctrl+L` 清除所有输出信息。
3. 复制下述代码进入 `Console` 并回车，代码将运行，`Console` 会出现 `[当前进度: xx.xx%]` 的进度提示。

```js
var host_list = [
  'github.com',
  'github.global.ssl.fastly.net',
  'gist.github.com',
  'assets-cdn.github.com',
  'raw.githubusercontent.com',
  'gist.githubusercontent.com',
  'cloud.githubusercontent.com',
  'camo.githubusercontent.com',
  'avatars0.githubusercontent.com',
  'avatars1.githubusercontent.com',
  'avatars2.githubusercontent.com',
  'avatars3.githubusercontent.com',
  'avatars4.githubusercontent.com',
  'avatars5.githubusercontent.com',
  'avatars6.githubusercontent.com',
  'avatars7.githubusercontent.com',
  'avatars8.githubusercontent.com',
]
function rec (wq, fq=[]) {
  if (wq.length)  {
    $.ajax({
      url: `https://myssl.com/api/v1/tools/dns_query`,
      type: 'GET',
      data: {
        qtype: 1,
        host: wq[0],
        qmode: -1,
      }
    }).then(res => {
      try {
        fq.push([wq[0], res.data['86'][0]['answer']['records'][0].value])
        wq.splice(0, 1)
        console.log(`%c[当前进度：${parseInt(100 * (fq.length) / (fq.length + wq.length))}%]`, 'background-color: #67c23a; color: #ffffff;')
      } catch (e) {
        fq.push([wq[0], 'ERROR'])
        wq.splice(0, 1)
        console.log(`%c[当前进度：${parseInt(100 * (fq.length) / (fq.length + wq.length))}%]`, 'background-color: #f56c6c; color: #ffffff;')
      } finally {
        rec(wq, fq)
      }
    })
  } else {
    function downloadText (text) {
      var a = document.createElement('a')
      a.download = 'content.txt'
      a.style.display = 'none'
      var blob = new Blob([text])
      a.href = URL.createObjectURL(blob)
      document.body.appendChild(a)
      a.click()
    }
    var content = '\n# GitHub Start\n' + fq.map(kv => kv[1] + ' ' + kv[0]).join('\n') + '\n# GitHub End\n'
    downloadText(content)
    console.log(`%c${content}`, 'background-color: #fffbe5; color: #614107;')
  }
}
rec(host_list)
```

1. 等待进度到达 `100.00%` 后，输出结果将下载为 `content.txt` ，在刚才打开的 `hosts` 文件编辑界面，找到空白行，将 `content.txt` 文件的内容通过 `Ctrl+A` 全选并复制，然后粘贴进 `hosts` 文件并通过 `Ctrl+S` 进行保存。
2. 点击 `Win+R` 后输入 `cmd` 并回车，在命令行输入`ipconfig/flushdns` (注意，命令有空格，建议直接复制命令) 并回车以刷新 DNS 缓存，然后重启浏览器即可。
3. 若仍然无法访问，还可尝试重新开机。

## 注意事项

1. `Console` 中显示的进度提示 `[当前进度: xx.xx%]` 应当是绿色背景文字，若出现红色背景文字说明出现错误，请重新刷新页面并复制代码运行。
2. 如果以前曾经跟着网上的教程进行过类似的配置操作，请在将内容粘贴进 `hosts` 文件后检查是否存在相同域名的行，请保证每个域名只出现一次。