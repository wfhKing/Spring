# Spring

### Spring的产生
Spring 的出现时因为当时 ****SUN**** 公司 **EJB** 的失败，尤其是在 **EJB2** 的时代，EJB2 需要许多配置文件，还需要配合很多抽象概念才能运用。虽然 **EJB2** 客服了配置方面的冗余，但是对于 **Java EE** 开发而言，更为致命的是对 **EJB** 容器的依赖，也就是 **EJB** 只能在 **EJB** 容器中运行，而 **EJB** 容器又过于笨重，这给一些企业带来了很多困难。在 **EJB** 快发中，需要选择 **EJB** 容器，然后通过这些 **EJB** 容器发布 Bean,应用则可以通过 **EJB** 容器获得对应的 Bean。

### EJB存在的问题：

首先，它运行起来比较慢，因为它要从容器中得到 Bean 需要的大量的远程调用、反射、代理、序列化和反序列化等复杂操作。

其次，过渡依赖 **EJB** 容器，难以达到快速开发和测试的目的，对于测试人员而言需要部署和跟踪 **EJB** 容器，而测试人员不一定有都了解 **EJB**，测试人员应该只需要了解测试方面的方法就可以了，而不是又要去了解开发方面的方法和知识。

### Spring的概述
**Spring**框架最核心的理念是 **IoC(控制反转)** 和 **AOP(面向切面编程)**，其中 **IoC** 是Spring的基础，**AOP**是重要的功能。

- 对于 **POJO** 的潜力开发，提供轻量级和低侵入的编程，可以通过配置（**XML**,**注解**等）来扩展 **POJO** 的功能，通过 依赖注入 的理念去扩展功能，建议通过接口编程，强调 **OOD** 的开发模式理念，降低系统耦合度，提高系统可读性和可扩展性。
- 提供了切面编程，尤其是吧企业的核心应用——数据库应用，通过切面消除了以前复杂的 **try...catch...finally** 代码结构，使得开发人员能够把精力更加集中于业务开发而不是技术本身，也避免了 **try...catch...finally** 语句的滥用。
- 为了整合各个框架和技术的应用，**Spring** 提供了模板类，通过模板可以整合各个框架和技术，比如支持 **Hibernate** 开发的 HibernateTemplate、支持 **MyBatis** 开发的 **SqlSessionTemplate**、支持 **Redis** 开发的 **RedisTemplate** 等，这样就把各种企业用到的技术框架整合到 **Spring** 中，提供了统一的模板，从而使得各种技术用起来更简单。

### Spring IoC 概述
**控制反转** 是一个比较抽象的概念，对于初学者不好理解，我们可以举例说明：

在实际生活中，人们要用到一样东西时，人们的基本想法是去找到这个东西，比如我们想和橙汁，在没有饮品店的日子里，最直观的做法技术，买一台榨汁机、一些橙子，准备开水。**注意** 这是你自己 **“主动”** 创建的过程，也就是一杯橙汁需要主动创建。然而到了今天这个时代，由于饮品店的盛行，已经没有必要自己去榨橙汁。想喝橙汁的想法一出现，第一个想法就是去找到饮品店的联系方式，通过电话、微信等途径描述你的需要、地址和联系方式等，下单准备，过会就会有人送上橙汁了。**注意**这里你并没有 **“主动”** 去创造橙汁，也就是说橙汁是由饮品店提供的，而不是你，但是也完全达到了你的要求。

上面这个例子用到的就是**控制反转**，现实中系统的开发者是一个团队，团队由许多开发者组成，现在假设你在一个电商网站负责开发工作，你熟悉商品交易流程，但是对财务却不知名熟悉，而团队中有些成员对于财务处理十分熟悉，在交易的过程中，商品交易流程需要调度财务的相关接口，才能得以实现，那么你的期望应该是：
- 熟悉财务流程的成员开发对应的接口。
- 接口逻辑尽量简单，内部复杂的业务并不需要自己去了解，你只要通过简单的调度就可以使用。
- 通过简单的描述就能获取这个接口实例，却描述应该尽量简单。

**控制反转**的概念通俗来说就是你对某一领域并不精通，这个时候你可以把创建对象的主动权转交到别人手里，而到时候我们只需要去调用就可以了。

#### Spring IoC容器:
**Spring IoC** 容器的设计主要是基于 **BeanFactory** 和 **ApplicationContext** 这两个接口，其中 **ApplicationContext** 是 **BeanFactory** 的子接口之一，换句话说 **BeanFactory** 是 **Spring IoC** 容器所定义的最底层接口，而 **AppkicationContext** 是 **Spring IoC**容器高级接口之一,并且对 **BeanFactory** 功能做了许多有用的扩展，所有在绝大多数情况下，都会使用 **ApplicationContext** 作为 **Spring IoC** 容器

**BeanFactory** 源码 :

	public interface BeanFactory {
       	String FACTORY_BEAN_PREFIX = "&";

       	Object getBean(String var1) throws BeansException;

       	<T> T getBean(String var1, Class<T> var2) throws BeansException;

       	Object getBean(String var1, Object... var2) throws BeansException;

       	<T> T getBean(Class<T> var1) throws BeansException;

       	<T> T getBean(Class<T> var1, Object... var2) throws BeansException;

       	<T> ObjectProvider<T> getBeanProvider(Class<T> var1);

       	<T> ObjectProvider<T> getBeanProvider(ResolvableType var1);

       	boolean containsBean(String var1);

       	boolean isSingleton(String var1) throws NoSuchBeanDefinitionException;

       	boolean isPrototype(String var1) throws NoSuchBeanDefinitionException;

       	boolean isTypeMatch(String var1, ResolvableType var2) throws NoSuchBeanDefinitionException;

       	boolean isTypeMatch(String var1, Class<?> var2) throws NoSuchBeanDefinitionException;

       	@Nullable
       	Class<?> getType(String var1) throws NoSuchBeanDefinitionException;

       	String[] getAliases(String var1);
	}
从这个接口中，我们可以看出：
- **getBean** 的多方法用于获取配置给 **Spring IoC** 容器的 Bean。从参数类型看可以是 字符串 ，也可以是 **Class** 类型，由于 **Class** 类型可以扩展接口也可以继承父类，所有在一定程度上会存在使用父类类型无法准确获得实例的异常，比如获取学生类，但是学生子类有 **男学生** 和 **女学生** 这两个类，这个时候通过学生类就无法从容器中得到实例，因为容器无法判断具体的实现类。
- **isSingleton** 用于判断是否为单例，如果判断为真，其意思就是该 **Bean** 在容器中是作为一个唯一单例存在的，而 **isPrototype** 则相反，如果判断为真，意思就是当你从容器中获得 **Bean**，容器就为你生成一个新的实例。在默认情况下，**Spring** 会为 **Bean** 创建一个单例，也就是默认情况下 **isSingleton** 返回 **true** ,而 **isPrototype** 返回 **false**.

## Spring AOP
**AOP (Ascept Oriented Programming) 面向切面编程** ，是 **Spring** 最为重要的功能之一。通过预编译方式和运行期动态代理实现程序功能的横向多模板同一控制的一种技术。**AOP** 是 **OOP** 的补充，是 **Spring** 中的一个重要内容。利用 **AOP** 可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提供程序的可重用性，同时提高了开发的效率。**AOP** 可以分为 **静态织入** 与 **动态织入**，**静态织入** 即在编译前将需织入内容写入目标模板中，这样成本非常高。**动态织入** 则不需要改变目标模板。**Spring** 框架实现了 **AOP** ，使得注解配置完成 **AOP** 比使用 **XML** 配置要更加方便与直观。

### 关于 Spring AOP
- 在默认情况下，它基于 **JDK动态代理**， 所有它需要有接口；同时我们也可让它基于 **CGLib** 进行代理
- 一般情况下，要为一个类产生代理，如果它有接口，那么 **Spring** 会采取 **JDK动态代理** 方式；如果没有接口，这时候它就会尝试使用 **CGLib** 的方式进行代理
- **AOP** 的产生不是为了去代替谁，它更多的是运用到如何与容器结合的更好，怎么更好的配合企业级开发

### AOP 术语
- **切面(Aspect)**
	它可以定义各类 **通知**、**切点** 和 **引入** 等内容，然后 **Spring AOP** 会将定义的内容 **织入** 到约定的流程中，在动态代理中可以把它理解成一个拦截器。
- **通知(Advice)**
	它是切面开启后，切面的方法。它根据在代理对象真实方法调用前、后的顺序和逻辑区分，
    1.**前置通知(before)**：在动态代理反射原有对象方法或执行环绕通知前执行的通知功能
    2.**后置通知(after)**: 在动态代理反射原有对象方法或执行环绕通知后执行的通知功能。无论是否抛出异常，它都会被执行
    3.**返回通知(afterReturning)**: 在动态代理反射原有对象方法或执行环绕通知后正常返回(无异常)执行的通知功能。
    4.**异常通知(afterThrowing)**：在动态代理反射原有对象方法或执行环绕通知产生异常后执行的通知功能。
    5.**环绕通知(around)**：在动态代理中，它可以取代当前被拦截对象的方法，提供回调原有被拦截对象的方法。
- **引入**
	引入允许我们在现有的类里添加自定义的类和方法
- **切点**
	这是一个告诉 **Spring AOP** 在什么时候启动拦截并织入对应的流程中，因为并不是所有的开发都需要启动 **AOP** 的，它往往通过正则表达式进行限定
- **连接点**
	连接点对应的是具体需要拦截的东西，比如通过切点的正则表达式去判断哪些方法是连接点，从而织入对应的通知
- **织入(Weaving)**
	它是一个生成代理对象并将切面内容放入到流程中的过程。实际代理的方法分为 **静态代理** 和 **动态代理**。**静态代理** 是在编译 **class** 文件是生成的代码逻辑，但是在 **Spring** 中并不使用这样的方式；**动态代理**，一种是同 **ClassLoader** 也就是在类加载时生成的代码逻辑，但是它在应用程序代码运行前就生成对应的逻辑，另一种是运行期，动态生成代码的方式，这是 **Spring AOP** 所采用的方式， **Spring** 是以  **JDK** 和 **CGLib** 动态代码来生成对象的。

### Spring 对 AOP 的支持
**AOP** 并不是 **Spring** 框架特有的，**Spring** 只是支持 **AOP** 编程的框架之一。每一个框架对 **AOP** 的支持各有特点，有些 **AOP** 能够对方法的参数进行拦截，有些 **AOP** 对方法进行拦截。而 **Spring AOP** 是一种基于方法拦截的 **AOP**，换句话说 **Spring** 只能支持方法拦截的 **AOP**，在 **Spring** 中有4种方法去实现 **AOP** 的拦截功能
- 使用 **ProxyFactoryBean** 和对应的接口实现 **AOP**
- 使用 **XML** 配置 **AOP**
- 使用 **@AspectJ** 注解驱动切面
- 使用 **AspectJ** 注入切面

