# 基于SSM框架的管理系统


#### 介绍
基于SSM框架的管理系统 _简洁版_ ；

实现 **登录** 、 **注册** 、 **增** 、 **删** 、 **改** 、 **查** ；

可继续完善增加前端、校验、其他功能等；

可作为SSM项目开发练习基础模型；

 **课程设计** 、 **毕业设计** 开发基础；

任何复杂的框架都是简单的知识组合并延伸的，学好基础知识才是最重要的；

此项目简单，便于理解基本原理，为复杂SSM复杂项目的开发打下基础。


#### 环境准备
开发平台：Idea 2019

数据库：MySQL 5.0.22

服务器：Tomcat 9.0.37

注意：需要安装IDEA开发平台、MySQL数据库和Tomcat服务器，版本不一定完全一致，做好版本适应性配置即可。



#### 项目结构

1.数据库及Java代码文件
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/165559_8bfe047a_9956838.png "project.png")

2.Jsp等前端代码
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/165613_14e94533_9956838.png "project2.png")

3.Tomcat服务器配置与运行

![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/165625_22caa822_9956838.png "Tomcat.png")
4.MySQL数据库
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/165705_aa359eed_9956838.png "MySQL.png")

#### 基本原理

1. 相关概念

 **Spring** 

    Spring是一个开源框架，是2003年兴起的轻量级的Java开发框架,为解决企业应用开发的复杂性而创建的。简单来说，Spring是一个轻量级的控制反转（IOC）和面向切面（AOP）的容器框架。日常开发中IOC容器使用较多，可以装载Bean，即Java中的类，不用在每次使用类的时候初始化，很少出现关键字new。另外spring的AOP，事务管理等等也会经常使用。

    IOC:

    控制反转，是一种降低对象之间耦合关系的设计思想。如：租赁房屋，平常租房需要自己逐个小区寻找房屋，然后使用了IOC之后，即需找一个租房中介，把对房屋的需求告诉中介，就可以直接找到合适的房屋。即把需求交给了第三方，有第三方帮助你完成你的需求，中介就相当于spring容器。

    AOP:

    面向切面编程，是面向对象开发的一种补充，允许开发人员在不改变原来模型的基础上动态的修改模型以满足新的需求，如：动态的增加日志、安全或异常处理等。AOP使业务逻辑各部分间的耦合度降低，提高程序可重用性，提高开发效率。


 **SpringMVC** 

    Spring MVC分离了控制器、模型对象、分派器以及处理程序对象的角色，这种分离让它们更容易进行定制。

    SpringMVC工作流程：

        1.用户向服务器发送请求，请求被Spring前端控制Servelt DispatcherServlet捕获；

        2.DispatcherServlet对请求URL进行解析，得到请求资源标识符（URI）。然后根据该URI，调用HandlerMapping获得该Handler配置的所有相关的对象（包括Handler对象以及Handler对象对应的拦截器），最后以HandlerExecutionChain对象的形式返回；

        3.DispatcherServlet 根据获得的Handler，选择一个合适的HandlerAdapter。（附注：如果成功获得HandlerAdapter后，此时将开始执行拦截器的preHandler(...)方法）

        4.提取Request中的模型数据，填充Handler入参，开始执行Handler（Controller)。在填充Handler的入参过程中，根据你的配置，Spring将帮你做一些额外的工作：

            HttpMessageConveter：将请求消息（如Json、xml等数据）转换成一个对象，将对象转换为指定的响应信息

            数据转换：对请求消息进行数据转换。如String转换成Integer、Double等

            数据根式化：对请求消息进行数据格式化。 如将字符串转换成格式化数字或格式化日期等

            数据验证：验证数据的有效性（长度、格式等），验证结果存储到BindingResult或Error中

        5.Handler执行完成后，向DispatcherServlet返回一个ModelAndView对象；

        6.根据返回的ModelAndView，选择一个适合的ViewResolver（必须是已经注册到Spring容器中的 ViewResolver)返回给DispatcherServlet；

        7.ViewResolver 结合Model和View，来渲染视图

        8.将渲染结果返回给客户端。

![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/165810_cbd1dbe4_9956838.png "springMVC.png")


 **MyBatis** 

    MyBatis是一个基于Java的持久层框架。MyBatis消除了几乎所有的JDBC代码和参数的手工设置以及结果集的检索。MyBatis使用简单的XML或注解用于配置和原始映射，将接口和Java的POJOs（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录。MyBatis是对Jdbc的封装，让数据库底层操作变的透明。Mybatis的操作都是围绕一个sqlSessionFactory实例展开的。mybatis通过配置文件关联到各实体类的Mapper文件，Mapper文件中配置了每个类对数据库所需进行的sql语句映射。在每次与数据库交互时，通过sqlSessionFactory拿到一个sqlSession，再执行sql命令。


2. 实现流程


    0.数据库database-

    1.实体类com.pojo-，定义对象的属性。

    2.mapper-Mapper.xml（Mybatis），其中定义功能，对应要对数据库进行的那些操作，比如insert、selectAll、selectByKey、delete、update等。

    3.com.dao-Mapper.java，将Mapper.xml中的操作按照id映射成Java函数。

    4.com.Service-Service.java，为控制层提供服务，接受控制层的参数，完成相应的功能，并返回给控制层。

    5.com.controller-Controller.java，连接页面请求和服务层，获取页面请求的参数，通过自动装配，映射不同的URL到相应的处理函数，并获取参数，对参数进行处理，之后传给服务层。

    6.Jsp-前端JSP页面调用，请求哪些参数，需要获取什么数据。


    DataBase ===> pojo ===> Mapper.xml ===> dao ===> Service ===> controller ===> Jsp


3. 基本原理

    SSM框架是spring MVC ，spring和mybatis框架的整合，是标准的MVC模式，将整个系统划分为表现层，controller层，service层，dao层

spring MVC负责请求的转发和视图管理,负责controller和jsp的，也就是视图层；

    spring实现业务对象管理,提供对象的，利用其IOC与AOP贯穿于整个项目。为各个层之间提供对象创建和注入，解耦合。比如我的这个项目提供了dao层的对象；

    mybatis作为数据对象的持久化引擎，负责数据库的连接（不用jdbc了），与spring整合后，配合spring可提供dao层对象。


    持久层：DAO层（mapper）

    DAO层：DAO层主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此，DAO层的设计首先是设计DAO的接口，然后在Spring的配置文件中定义此接口的实现类，然后就可在模块中调用此接口来进行数据业务的处理，而不用关心此接口的具体实现类是哪个类，显得结构非常清晰，DAO层的数据源配置，以及有关数据库连接的参数都在Spring的配置文件中进行配置。

    业务层：Service层

    Service层：Service层主要负责业务模块的逻辑应用设计。首先设计接口，再设计其实现的类，接着再在Spring的配置文件中配置其实现的关联。这样我们就可以在应用中调用Service接口来进行业务处理。Service层的业务实现，具体要调用到已定义的DAO层的接口，封装Service层的业务逻辑有利于通用的业务逻辑的独立性和重复利用性，程序显得非常简洁。
    表现层：Controller层（Handler层）

    Controller层:Controller层负责具体的业务模块流程的控制，在此层里面要调用Service层的接口来控制业务流程，控制的配置也同样是在Spring的配置文件里面进行，针对具体的业务流程，会有不同的控制器，我们具体的设计过程中可以将流程进行抽象归纳，设计出可以重复利用的子单元流程模块，这样不仅使程序结构变得清晰，也大大减少了代码量。

    View层：

    View层与控制层结合比较紧密，需要二者结合起来协同工发。View层主要负责前台Jsp页面的表示。



#### 页面展示

1.登录页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/170046_debe2f1c_9956838.png "login.png")


2.注册页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/170058_9f191a51_9956838.png "register.png")

3.主页
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/170108_d107647b_9956838.png "index.png")

4.展示页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/170123_380829d5_9956838.png "get.png")

5.新增页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/170132_ff984e4c_9956838.png "add.png")

6.删除页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/170139_12071491_9956838.png "delete.png")

7.修改页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1105/170150_744aa8e9_9956838.png "update.png")


#### 注意

    1.MySQL 版本5.0以上与8.0以上配置有些许差异，需要调整

    根据 jdbc.properties 文件中的提示，选择合适的数据库驱动 driver。

  ` ` # MySQL 5.Xjdbc.driver=com.mysql.jdbc.Driver``
    > # MySQL 8.Xjdbc.driver=com.mysql.cj.jdbc.Driver

    2.运行项目前提前配置好MySQL数据库、Tomcat服务器、IDEA maven依赖库

    3.本系统仅实现简单功能，仅为更好理解SSM原理，需进一步完善更多功能及健壮性


#### LICENSE

zjzhou


#### about me

    一个爱学习、爱分享、爱交流的程序员；

    欢迎关注个人微信公众号【Java烂笔头】，一起交流、共同进步；
    


