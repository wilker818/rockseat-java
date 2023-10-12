package com.wilkeferreira.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wilkeferreira.todolist.user.IUserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Pegar a autenticacao (usuario e senha)
        var autenticacao = request.getHeader("Authorization");
        var authEncoded = autenticacao.substring("Basic".length()).trim();

        byte[] authDecode = Base64.getDecoder().decode(authEncoded);

        var authString = new String(authDecode);

        // ["wilker", "123456"]
        String[] credentials = authString.split(":");
        String userName = credentials[0];
        String password = credentials[1];

        System.out.println("Autenticacao");
        System.out.println(userName);
        System.out.println(password);

        // Validar usuario
        var user = this.userRepository.findByUsername(userName);
        if (user == null) {
            response.sendError(401);
        } else {
            // validar senha
            var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            if (passwordVerify.verified) {

                // Segue viagem
                filterChain.doFilter(request, response);
            } else {
                response.sendError(401);
            }

        }

    }

}
