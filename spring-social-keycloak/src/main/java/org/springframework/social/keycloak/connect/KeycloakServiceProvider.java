/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.keycloak.connect;

import org.springframework.social.keycloak.api.Keycloak;
import org.springframework.social.keycloak.api.impl.KeycloakTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * Github ServiceProvider implementation.
 * @author ali akbar azizkhani
 */
public class KeycloakServiceProvider extends AbstractOAuth2ServiceProvider<Keycloak> {

	public KeycloakServiceProvider(String clientId, String clientSecret) {
		super(createOAuth2Template(clientId, clientSecret));
	}

	private static OAuth2Template createOAuth2Template(String clientId, String clientSecret) {
		OAuth2Template oAuth2Template = new OAuth2Template(clientId, clientSecret,
				"http://localhost:8080/auth/realms/master/protocol/openid-connect/auth",
				"http://localhost:8080/auth/realms/master/protocol/openid-connect/token");
		oAuth2Template.setUseParametersForClientAuthentication(true);
		return oAuth2Template;
	}

	public Keycloak getApi(String accessToken) {
		return new KeycloakTemplate(accessToken);
	}

}
