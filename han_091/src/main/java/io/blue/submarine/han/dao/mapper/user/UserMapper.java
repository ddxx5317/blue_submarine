package io.blue.submarine.han.dao.mapper.user;

import io.blue.submarine.han.core.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 Mapper.
 *
 * @author shucunbin
 */
@Mapper
public interface UserMapper {
    int insert(User user);
    User findByUserId(@Param("user_id") Integer userId);

    User findByName(@Param("name") String name);
}
