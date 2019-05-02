# 测试说明
- 本项目主要用于演示日志配置最小化所需项，并且进行了常用日志框架Logback和Log4j2的横向比较。
- 为保证测试对比公平并且易于进行文件比较，日志输出格式都忽略了日期字段，仅输出：级别，线程，类名，消息内容；

## 测试log4j2
- 修改pom.xml文件，激活对spring-boot-starter-log4j2的依赖（去掉注释）; 注意添加exclusions避免log4j2和logback的冲突

```
	<!-- 日志 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-log4j2</artifactId>
	</dependency>
```
- 需要引入对com.lmax.disruptor异步框架的依赖
```
	<!-- 异步日志依赖包 -->
	<dependency>
		<groupId>com.lmax</groupId>
		<artifactId>disruptor</artifactId>
		<version>3.4.2</version>
	</dependency>
```

- 通过注释log4j2.component.properties来控制对异步/同步的切换，可以方便的观测对比结果;
```
	Log4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
```

## 测试logback
- 修改pom.xml文件，注释对spring-boot-starter-log4j2的依赖，即可切换到使用logback的方式；
- logback-spring.xml中对于异步的支持，设置了缓冲队列为512


## 总结
从性能观测来说，500000行日志运行10次进行平均值统计：log4j2异步（1450ms左右) > log4j2同步(4200ms) > logback同步(5124ms) > logback异步(6591ms)