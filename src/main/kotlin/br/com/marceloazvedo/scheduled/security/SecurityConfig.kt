package br.com.marceloazvedo.scheduled.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(private val userDetailsService: UserDetailsService) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/h2").permitAll() // H2 database access
                .antMatchers(HttpMethod.POST,"/clients").permitAll() // create a user
                .antMatchers(HttpMethod.POST, "/session").permitAll() // get session
                .anyRequest().authenticated()
                .and()

                // filter the requisition of the login
                .addFilterBefore(JWTSessionFilter("/session",  authenticationManager()),
                        UsernamePasswordAuthenticationFilter::class.java)

                // filter the others requisitions to verify the JWT presence in header
                .addFilterBefore(JWTAuthorizationFilter(authenticationManager()),
                        UsernamePasswordAuthenticationFilter::class.java)
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(userDetailsService)
    }

}