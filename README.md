# MyBatis
MyBatis

准备动作<br />
1、启动H2数据库服务端<br />
2、运行InitMain初始化数据库<br />
<br />
原始Dao开发方法<br />
1、在配置文件中配置环境信息<br />
2、在配置文件中配置Sql映射文件<br />
3、编写Sql映射文件<br />
4、通过Resources类加载配置文件<br />
5、通过SqlSessionFactoryBuilder的build方法得到SqlSessionFactory<br />
6、通过SqlSessionFactory的openSession得到SqlSession<br />
7、通过SqlSession的insert、update、selectOne、selectList、delete等方法操作数据库<br />
<br />
Mapper代理开发方法<br />
1、在配置文件中配置环境信息<br />
2、在配置文件中配置Mapper包名<br />
3、在Mapper包里编写Sql映射文件<br />
4、通过Resources类加载配置文件<br />
5、通过SqlSessionFactoryBuilder的build方法得到SqlSessionFactory<br />
6、通过SqlSessionFactory的openSession得到SqlSession<br />
7、通过SqlSession的getMapper方法得到Mapper代理对象<br />
8、调用Mapper代理对象的方法操作数据库<br />




