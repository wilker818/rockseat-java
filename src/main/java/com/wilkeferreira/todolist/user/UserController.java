package com.wilkeferreira.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ## MODIFICADORES ##
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * String (texto)
     * Integer (int) numeros inteiros
     * Double (double) numeros 0.0000
     * Float (float) numeros 0.000
     * char (F)
     * Date (data)
     * void
     */

    @PostMapping("/")
    public void create(@RequestBody UserModel userModel) {
        System.out.println(userModel.getUsername());
    }

}
