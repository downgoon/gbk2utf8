# converting files encoding in some path from GBK to UTF8

## how to run

``java -jar gbk2utf8-0.0.1-SNAPSHOT-all.jar $src-gbk-path $dst-utf8-path``

for help, run ``java -jar gbk2utf8-0.0.1-SNAPSHOT-all.jar``

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