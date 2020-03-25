package com.cczu.ddd.config.Security;

public class MySecurityConfig {

}
/**
 * 1、引入SpringSecurity；
 * 2、编写SpringSecurity的配置类；
 * 		@EnableWebSecurity   extends WebSecurityConfigurerAdapter
 * 3、控制请求的访问权限：
 * 		configure(HttpSecurity http) {
 * 		 	http.authorizeRequests().antMatchers("/").permitAll()
 * 		 		.antMatchers("/level1/**").hasRole("VIP1")
 * 		}
 * 4、定义认证规则：
 * 		configure(AuthenticationManagerBuilder auth){
 * 		 	auth.inMemoryAuthentication()
 * 		 		.withUser("zhangsan").password("123456").roles("VIP1","VIP2")
 * 		}
 * 5、开启自动配置的登陆功能：
 * 		configure(HttpSecurity http){
 * 		 	http.formLogin();
 * 		}
 * 6、注销：http.logout();
 * 7、记住我：Remeberme()；
 */
//@EnableWebSecurity
    //先不使用，很多细节问题，如记住我登陆没有session，登陆需要绑定方法，无法获得参数
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //super.configure(http);
//        //定制请求的授权规则
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/**.css").permitAll()
//                .antMatchers("/**.js").permitAll()
//                .antMatchers("/**.jpg").permitAll()
//                .antMatchers("/**.png").permitAll()
//                .antMatchers("/layui/**").permitAll()
//                .antMatchers("/wec").hasRole("VIP1")//这里允许所有人访问
//                .antMatchers("/level1/**").hasRole("VIP1")  //这里需要固定角色才可以访问
//                .antMatchers("/level2/**").hasRole("VIP2")
//                .antMatchers("/level3/**").hasRole("VIP3");
//
//        //开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
//        http.formLogin().usernameParameter("username").passwordParameter("password")
//                .loginPage("/").loginProcessingUrl("/login")
//                .successForwardUrl("/loginstatus?ac=1&username=username&password=password")
//                .failureForwardUrl("/loginstatus?ac=2");
//        //1、/login来到登陆页
//        //2、重定向到/login?error表示登陆失败
//        //3、更多详细规定
//        //4、默认post形式的 /login代表处理登陆
//        //5、一但定制loginPage；那么 loginPage的post请求就是登陆
//
//
//        //开启自动配置的注销功能。
//        http.logout().logoutSuccessUrl("/");//注销成功以后来到首页
//        //1、访问 /logout 表示用户注销，清空session
//        //2、注销成功会返回 /login?logout 页面；
//
//        //开启记住我功能  开启功能后要考虑session是否丢失
//        http.rememberMe()
//                .useSecureCookie(true)
//                .tokenValiditySeconds(259200);
//        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
//        //点击注销会删除cookie
//
//    }
//
//    //定义认证规则
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
//                .and()
//                .withUser("lisi").password("123456").roles("VIP2","VIP3")
//                .and()
//                .withUser("wangwu").password("123456").roles("VIP1","VIP3")
//                .and()
//                .withUser("ddd").password("ddd").roles("VIP1","VIP3");
//
//    }

