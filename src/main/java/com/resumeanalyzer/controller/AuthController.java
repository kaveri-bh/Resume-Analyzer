package com.resumeanalyzer.controller;
import com.resumeanalyzer.model.UserAccount;import com.resumeanalyzer.repository.UserRepository;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;
@Controller public class AuthController {
 private final UserRepository users;private final PasswordEncoder encoder;public AuthController(UserRepository u,PasswordEncoder e){users=u;encoder=e;}
 @GetMapping("/login")String login(){return "login";}@GetMapping("/register")String register(){return "register";}
 @PostMapping("/register")String create(@RequestParam String fullName,@RequestParam String email,@RequestParam String password,Model m){String clean=email.trim().toLowerCase();if(users.existsByEmail(clean)){m.addAttribute("error","Email already registered.");return "register";}if(password.length()<8){m.addAttribute("error","Password must be at least 8 characters.");return "register";}UserAccount u=new UserAccount();u.setFullName(fullName.trim());u.setEmail(clean);u.setPassword(encoder.encode(password));users.save(u);return "redirect:/login?registered";}
}
