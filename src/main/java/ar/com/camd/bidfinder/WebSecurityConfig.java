package ar.com.camd.bidfinder;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/user/order", true)
						.permitAll())
				.logout(logout -> logout                                                
			            .logoutUrl("/logout"));
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("christian")
//				.password("christian")
//				.roles("ADM")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Bean
	public UserDetailsManager users(BCryptPasswordEncoder encoder) {
//		UserDetails christian = User.builder()
//			.username("christian")
//			.password(encoder.encode("christian"))
//			.roles("ADM")
//			.build();
//		UserDetails ariel = User.builder()
//			.username("ariel")
//			.password(encoder.encode("ariel"))
//			.roles("ADM")
//			.build();
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//		users.createUser(christian);
//		users.createUser(ariel);
		return users;
	}
}