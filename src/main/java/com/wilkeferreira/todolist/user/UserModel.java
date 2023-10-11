
package com.wilkeferreira.todolist.user;

import lombok.Data;

/**
 * cria getter e setter automaticos
 * https://projectlombok.org/setup/maven
 ********************************
 * import lombok.Data;
 * import lombok.Getter;
 * import lombok.Setter;
 ********************************
 * @Data -> cria getter e setter
 * @Getter -> cria getter
 * @Setter -> cria setter
 ********************************
 */
@Data
public class UserModel {
    private String username;
    private String name;
    private String password;

}
