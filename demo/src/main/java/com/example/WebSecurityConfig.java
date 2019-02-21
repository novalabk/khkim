package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		//web.ignoring().antMatchers("/**");
	}
	
	
	@Autowired 
	UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
         .csrf().disable()
         .authorizeRequests()
              .antMatchers("/user").hasAuthority("USER")
              .antMatchers("/admin").hasAuthority("ADMIN")
              .anyRequest().authenticated()
              .and()
         .formLogin()
              .and()
         .logout();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userService);
    }




	
//	@Override
//    protected void configure(WebSecurity web) throws Exception {
//		
//		web.ignoring().antMatchers("/**");
//		http.authorizeRequests().antMatchers("/**");
//        http
//        .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout().permitAll();
//   }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("1").roles("USER");
//    }
}
