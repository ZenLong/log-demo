# 测试说明
为保证测试对比公平并且易于进行文件比较，日志输出格式都忽略了日期字段，仅输出：级别，线程，类名，消息内容；

## 测试log4j2
- 修改pom.xml文件，激活对spring-boot-starter-log4j2的依赖（去掉注释）; 注意添加exclusions避免log4j2和logback的冲突
- 通过注释log4j2.component.properties来控制对异步/同步的切换，可以方便的观测对比结果;
- 需要引入对com.lmax.disruptor异步框架的依赖

## 测试logback
- 修改pom.xml文件，注释对spring-boot-starter-log4j2的依赖，即可切换到使用logback的方式；
- logback-spring.xml中对于异步的支持，设置了缓冲队列为512


## 总结
从性能观测来说，500000行日志运行10次进行平均值统计：log4j2异步（1450ms左右) > log4j2同步(4200ms) > logback同步(5124ms) > logback异步(6591ms)