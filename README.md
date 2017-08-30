# 七牛云图片上传
使用 bootstarp 文件上传学习，

已经打包好 可以在[这里](http://pan.baidu.com/s/1mh8U0tU)下载

此分支是私有化定制的上传工具，如果要使用**修改配置文件**，

做这个东西的原因很简单，就是自己平时写博客的时候用七牛云作为图床，每次上传完图片再去一个一个去找外链太麻烦，而且发现如果使用私有空间，在七牛云给的外链有效期很短，所以就想手动撸一个工具出来。

目标是做一个可以随处使用的七牛云文件上传工具，并实时返回私有文件的外链。

但是实际上，最终做出来的东西什么样并不重要，重要的时候自己在做它的过程中学到的东西。

干巴爹！

# 使用

将项目导入 idea；

修改 core.model.QiNiuAccount 类

执行 gradle - build 打包出 jar 包即可。

# 关于七牛云

- accessKey 和 secretKey 获取

    在 https://portal.qiniu.com/signin 登录后 个人中心 - 秘钥管理。
    
- 关于 cdn 说明

    cdn格式务必为 http://xxx.xx/  一定以 / 结尾
    
    如果不想配置自己的域名可以使用对象存储空间提供的测试域名，
    
    不过对于私有空间建议使用自定义域名。
    
    ![cdn](http://blogqn.maintel.cn/七牛云自定义域名.png?e=3080533207&token=kDSqSAyKGaf8JcHprWP7S4W3hGuz8kDIEhzAufWH:OrlP6IqBEKWqlVMvft7YcA_mCMQ=)
    
 - bucket 是存储空间的名字
# 涉及到的技术

- bootstarp
- jQuary
- springboot
- js等

# 实现功能

- 单个文件上传
- 批量文件上传
- 支持自动返回私有外链
- 只支持上传图片类型文件，其他类型可以自己修改源码

# 上传文件

下载以后解压缩，配置 qiniu.properties 中的值，

使用 java -jar 命令运行 jar 包，浏览器访问 http://localhost:11555。
