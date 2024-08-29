package com.app.usuarios.auth;



import java.util.Date;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.usuarios.jwt.JwtService;
import com.app.usuarios.service.UsuarioService;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;

import com.app.usuarios.entity.Role;
import com.app.usuarios.entity.Usuario;
import com.app.usuarios.entity.UserRepository;




@Service
@RequiredArgsConstructor
public class AuthService {
	
  	@Autowired
	private UsuarioService usuarioService;

    private final UserRepository userRepository;
    private final JwtService jwtService = new JwtService();
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
    	Date fechaActual = new Date();
    	Usuario user = Usuario.builder()
    			.login(request.getLogin())
    			.username(request.getUsername())
    			.password(passwordEncoder.encode( request.getPassword()))
	            .nombre(request.getNombre())
	            .client(request.getClient())
		    	.email(request.getEmail())
		    	.fechaalta(fechaActual)
		    	.fechabaja(request.getFechabaja())
		    	.status(request.getStatus())
		    	.intentos(request.getIntentos())
		    	.fecharevocado(request.getFecharevocado())
		    	.fecha_vigencia(request.getFecha_vigencia())
		    	.no_acceso(request.getNo_acceso())
		    	.apellido_paterno(request.getApellido_paterno())
		    	.apellido_materno(request.getApellido_materno())
		    	.area(request.getArea())
		    	.fechamodificacion(request.getFechamodificacion())
		    	.role(Role.USER)
	        .build();

    	userRepository.save(user);

       
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

}
