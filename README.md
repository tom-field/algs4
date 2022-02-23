# idea算法第4版

### 学习环境搭建
+ 官网下载algs4.jar,algs4-data.zip
+ 引入algs4.jar
  - File -> Project Structure -> Modules -> Dependencies添加jar文件路径
+ 解压algs4-data到项目根目录中

### 配置编译
+ 右键->More run/Debug->Modify Run Configuration
+ 点击Modify Options点击后可以配置Redirect Input
  > 这样配置可以直接点击右边的run运行代码，免去了命令行中冗长的输入
  > 比如要运行 java BinarySearch tinyW.txt < tinyT.txt
  > argument参数配置成：$ProjectFileDir$\algs4-data\tinyW.txt
  > Redirect参数配置成：$ProjectFileDir$\algs4-data\tinyT.txt