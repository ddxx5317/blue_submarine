package io.blue.submarine.han.core.model.user;

import lombok.Data;
import lombok.ToString;

/**
 * 用户信息.
 *
 * @author shucunbin
 */
@Data
@ToString
public class User {
    private Long id;
    private Integer userId;
    private String name;
}
