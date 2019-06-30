package com.training.mjunction.product.review.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.GitInfoContributor;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.info.GitProperties;
import org.springframework.stereotype.Component;

/**
 * Default Service health indicator to be used. This indicator will be used in addition to the spring actuator '/health' endpoint.
 *
 * Note: It's completely optional for applications if it doesn't need to do anything extra for default health other than spring health endpoint.
 */
@Component
public class UserSvcsInfoContributer extends GitInfoContributor {

	@Autowired
	public UserSvcsInfoContributer(final GitProperties properties) {
		super(properties);
	}

	@Override
	public void contribute(final Builder builder) {
		builder.withDetail("Info", "userInfo").withDetail("git", generateContent()).withDetail("gitDetails", getProperties()).build();
	}

}
