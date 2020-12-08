# 轻聊 APP开发文档（更新中...）

## 说明

## 功能截图

## 技术框架

## 提交记录
**第一次提交 2020.11.11**
- 初始化工程文件
- 封装BaseActivity基类
- 封装BaseFragment基类
- 分包common负责提取一些常规操作、lang负责存储字符串类型数据，方便多语言切换
- app\build.gradle、common\build.gradle添加依赖库
- 添加图片资源文件、xml资源文件等

**第二次提交 2020.11.13**
- MainActivity界面布局封装
- 底部导航栏的封装
- 头像、顶部导航背景、点击效果
- 导航栏切换效果的实现

**第三次提交 2020.11.13**
- 修改文件名
- 修改背景、布局等

**第四次提交 2020.11.13**
- 封装Fragment工具类，用于解决fragment的切换
- 实现浮动按钮的切换动画

**第五次提交 2020.11.14**
- 封装图片选择器类GalleyView
- 修复了 Activity基类初始化控件空指针异常Bug

**第六次提交 2020.11.14**
- 修复了 选择图片时右上角显示
- 添加了 Toast提示
- 完成了图片选择器框架

**第七次提交 2020.11.14**
- 添加了 ucrop 图片剪切库
- 添加了 GalleryFragment类，实现选择图片

**第八次提交 2020.11.15**
- 初步实现了头像图片的剪裁

**第九次提交 2020.11.15**
- 剪裁完成后对图片加载

**第十次提交 2020.11.15**
- 添加了 集合工具类 CollectionUtil
- 添加了 对文件流的操作工具类 StreamUtil
- 添加了 对文件或者字符串进行Hash算法，返回MD5值 HashUtil
- 添加了 Bitmap 工具类 BitmapUtil
- 添加了 时间工具类 DateTimeUtil
- 添加了 PicturesCompressor

**第十一次提交 2020.11.15**
- 添加动态权限类 PermissionsFragment
- 完善申请权限逻辑
- 添加启动页 判断是否获得权限；没有权限就弹出申请

**第十二次提交 2020.11.15**
- 配置阿里云oss存储
- 修复了 “Android P系统限制了明文流量的网络请求”->在xml文件夹下新建一个 network_security_config.xml，并在Manifest.xml中添加配置

**第十三次提交 2020.12.7**
- 登录、注册背景图着色

**第十四次提交 2020.12.7**
- 登录注册fragment在同一个activity切换
- 注册界面布局
- 登录界面布局
- BasePresenter、BaseContract基类的封装
- 添加NetWork类
- 添加RemoteService接口：网络请求的所有接口都在里面
- 实现注册功能、与接口互调

**第十五次提交 2020.12.8**
- 启动页动画
- 登录页面布局
- 创建持久化包
- 启动界面逻辑

**第十六次提交 2020.12.8**
- 添加全局广播接收器 MessageReceiver
- 配置个推，配置个推框架进行设备绑定

**第十七次提交 2020.12.8**
- 添加数据库
- 初始化数据库
- 创建 DBFlow的数据库过滤字段 DBFlowExclusionStrategy
- 创建数据库基本信息类 AppDatabase
- 保存用户信息到持久化xml文件中