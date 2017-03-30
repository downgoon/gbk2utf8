# converting files encoding in some path from GBK to UTF8

## how to run

### for any platform

``java -jar gbk2utf8-0.1.1-SNAPSHOT-all.jar $src-gbk-path $dst-utf8-path``

for help, run ``java -jar gbk2utf8-0.1.1-SNAPSHOT-all.jar``

**NOTE**

>a precompiled package is available at [v0.1.1 Releases](https://github.com/downgoon/gbk2utf8/releases/tag/v0.1.1), you can go to this page and download it directly.

### for Mac platform  (64bit)

- download [gbk2utf8-0.1.1.pkg](https://github.com/downgoon/gbk2utf8/releases/download/v0.1.1/gbk2utf8-0.1.1.pkg)
- double click it and install
- run command

```
$ gbk2utf8        # converting from gbk2 to utf8
Usage: Gbk2Utf8 <src-gbk-path> <dst-utf8-path> [include-extension (default 'java')]
$ gbk2utf8 convert
Usage: Gbk2Utf8 <src-gbk-path> <dst-utf8-path> [include-extension (default 'java')]
$ gbk2utf8 pkgreanme   # package renaming
Usage: Gbk2Utf8 <src-gbk-path> <dst-utf8-path> [include-extension (default 'java')]
$ gbk2utf8 version
0.1.1
```

**NOTE**
>``gbk2utf8-0.1.1.pkg`` will be installed in /usr/local/gbk2utf8 directory and a softlink /usr/local/bin/gbk2utf8 (linking to /usr/local/gbk2utf8/bin/gbk2utf8) will be created. 

![installing gbk2utf8-0.1.1.pkg](https://cloud.githubusercontent.com/assets/23731186/24492177/081a1266-155d-11e7-91bd-207fd2c9a2f7.png)


### for Ubuntu platform  (64bit)

- download
```
wget  https://github.com/downgoon/gbk2utf8/releases/download/v0.1.1/gbk2utf8_0.1.1_armhf.deb
```

- install
```
dpkg -i gbk2utf8_0.1.1_armhf.deb
```

- run

```
$ gbk2utf8        # converting from gbk2 to utf8
Usage: Gbk2Utf8 <src-gbk-path> <dst-utf8-path> [include-extension (default 'java')]
$ gbk2utf8 convert
Usage: Gbk2Utf8 <src-gbk-path> <dst-utf8-path> [include-extension (default 'java')]
$ gbk2utf8 pkgreanme   # package renaming
Usage: Gbk2Utf8 <src-gbk-path> <dst-utf8-path> [include-extension (default 'java')]
$ gbk2utf8 version
0.1.1
```



-----

## how to build

	git clone https://github.com/downgoon/gbk2utf8.git
	cd gbk2utf8
	mvn clean package
	java -jar target/gbk2utf8-0.0.1-SNAPSHOT-all.jar $src-gbk-path $dst-utf8-path
	
## Highlight

* **recursive** converting all necessary files in the specified path
* **encoding detective** do nothing to files not encoded in GBK in specified path 

---

## package rename  (a new tool)

``java -cp ./gbk2utf8-0.0.1-SNAPSHOT-all.jar io.downgoon.tools.PackageRename $src-gbk-path $dst-utf8-path <src-path> <dst-path> <original-package-prefix> <alternative-package-prefix>``

---

## 反馈问题

如果您有不清楚的地方或更好的建议，请在**Issue**中给我们反馈。
操作步骤如下：

1. 找到**Issue**入口
![Issue入口](https://cloud.githubusercontent.com/assets/23731186/20863916/7075a704-ba17-11e6-8d18-3670c59c5781.png)

2. 新建**Issue**
![新建Issue](https://cloud.githubusercontent.com/assets/23731186/20863922/beb848ae-ba17-11e6-93e9-4a6278d8816a.png)

3. 别忘了最好设置一个**Issue**类型
![反馈问题](https://cloud.githubusercontent.com/assets/23731186/20863944/254c597a-ba18-11e6-9df7-d6f23ca1cf7e.png)


