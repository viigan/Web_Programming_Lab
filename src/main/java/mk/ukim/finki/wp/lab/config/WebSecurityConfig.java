package mk.ukim.finki.wp.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        // Define users with encoded passwords
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin")) // Encode password
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user")) // Encode password
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers(headers -> headers.frameOptions().disable()) //ova e za h2
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/songs/add").permitAll()
                        .requestMatchers("/", "/artists", "/register", "/assets/**","/songs",
                        "/songs/add").permitAll()

                        .requestMatchers("/**").hasRole("ADMIN") // !!!!!Grant full access to admins for all paths
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .permitAll()
                        .defaultSuccessUrl("/songs", true) // Redirect after successful login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // Redirect after logout
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for encoding passwords
    }
}
