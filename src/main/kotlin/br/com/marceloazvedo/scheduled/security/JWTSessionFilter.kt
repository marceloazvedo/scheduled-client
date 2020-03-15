package br.com.marceloazvedo.scheduled.security

import br.com.marceloazvedo.scheduled.dto.SessionUserDTO
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTSessionFilter : AbstractAuthenticationProcessingFilter {

    constructor(url: String, authenticationManager: AuthenticationManager) : super(AntPathRequestMatcher(url)) {
        this.authenticationManager = authenticationManager
    }

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val sessionUser = ObjectMapper()
                .readValue(request!!.inputStream, SessionUserDTO::class.java)
        return authenticationManager
                .authenticate(
                        UsernamePasswordAuthenticationToken(
                                sessionUser.email,
                                sessionUser.password,
                                emptyList()))
    }

    override fun successfulAuthentication(request: HttpServletRequest?,
                                          response: HttpServletResponse?,
                                          chain: FilterChain?,
                                          authResult: Authentication?) {
        val token = JWT.create()
                .withSubject((authResult!!.principal as User).username)
                .withExpiresAt(Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstant.SECRET))
        response!!.addHeader(SecurityConstant.HEADER_STRING, SecurityConstant.TOKEN_PREFIX + token)
    }

}