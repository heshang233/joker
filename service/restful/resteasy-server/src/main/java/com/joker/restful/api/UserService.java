package com.joker.restful.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author huangsy
 * @date 2018/1/27 13:04
 */
@Path("/users")
public interface UserService {
    @GET
    public String get();
}
