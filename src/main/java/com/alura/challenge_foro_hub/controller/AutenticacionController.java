package com.alura.challenge_foro_hub.controller;
import com.alura.challenge_foro_hub.dto.DatosAutenticacion;
import com.alura.challenge_foro_hub.dto.DatosRegistroUsuario;
import com.alura.challenge_foro_hub.dto.DatosTokenJWT;
import com.alura.challenge_foro_hub.infra.security.TokenService;
import com.alura.challenge_foro_hub.model.Usuario;
import com.alura.challenge_foro_hub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacionController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacion datosAutenticacion) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacion.login(), datosAutenticacion.password());
        var autenticacion = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }

    @PostMapping("/register")
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        if (usuarioRepository.findByLogin(datosRegistroUsuario.getLogin()) != null) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
        var usuario = new Usuario();
        usuario.setLogin(datosRegistroUsuario.getLogin());
        usuario.setPassword(passwordEncoder.encode(datosRegistroUsuario.getPassword()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

}
