package com.resteasy.netty.request;

import org.jboss.resteasy.plugins.server.embedded.SimplePrincipal;
import org.jboss.resteasy.plugins.server.netty.NettySecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;

@Component
@Provider
public class AuthenticationFilter
		implements ContainerRequestFilter {

	protected final Logger logger	= LoggerFactory.getLogger(AuthenticationFilter.class);

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		authenticate(requestContext);
	}

	protected void authenticate(ContainerRequestContext ctx)
			throws IOException {

		Principal principal = new SimplePrincipal("Sample" + System.currentTimeMillis());

		ctx.setSecurityContext(
				new NettySecurityContext(principal, null, "BASIC", true)
				);
	}
}
