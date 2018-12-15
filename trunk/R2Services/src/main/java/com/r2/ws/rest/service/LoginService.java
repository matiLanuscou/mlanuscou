package com.r2.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.r2.ws.rest.vo.UserVO;

@Path("/r2")
public class LoginService {
	
	@POST
	@Path("/loginUser")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public UserVO validateUser(UserVO user){
		user.setValidUser(false);
		if(user.getUser().equals("R2") && user.getPassword().equals("password") ){
			user.setValidUser(true);
		}
		user.setPassword("############################");
		return user;
	}
	
	@GET
	@Path("/getUser")
	@Produces({MediaType.APPLICATION_JSON})
	public UserVO getUser(@QueryParam("id") int  id){
		UserVO user = new UserVO();
		user.setId(id);
		user.setUser("User_" + id);
		user.setPassword("#######");
		return user;
	}
	
	 @GET
	 @Path("/getUser/{id}")
	 @Produces({MediaType.APPLICATION_JSON})
	 public UserVO getUserById(@PathParam("id") int id) {
		 UserVO user = new UserVO();
			user.setId(id);
			user.setUser("UserById_" + id);
			user.setPassword("#######");
			return user;
	 }

}
