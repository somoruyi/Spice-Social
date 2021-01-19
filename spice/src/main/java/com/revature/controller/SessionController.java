
/*
 * package com.revature.controller;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.revature.models.Login;
 * 
 * 
 * 
 * @CrossOrigin(origins = {"http://localhost:4200","http://localhost:8088" },
 * allowCredentials = "true")
 * 
 * @RestController public class SessionController {
 * 
 * 
 * @GetMapping(value = "login", produces = "application/json")
 * public @ResponseBody String login(HttpServletRequest req) {
 * 
 * HttpSession session = req.getSession();
 * 
 * String userName=req.getParameter("username"); String
 * passWord=req.getParameter("password");
 * 
 * User incomingUser = new User(1, userName, passWord);
 * 
 * session.setAttribute("loggedInUser", incomingUser);
 * 
 * return "You've succesfully logged in"; }
 * 
 * 
 * @GetMapping(value = "logout", produces = "application/json")
 * public @ResponseBody String logout(HttpSession session) {
 * 
 * session.invalidate();
 * 
 * return "You've succesfully logged out"; }
 * 
 * 
 * @GetMapping(value = "getCurrentInfo") public @ResponseBody Login
 * getLoggedInUser(HttpSession session){
 * 
 * Login currentUser;
 * 
 * currentUser = (Login) session.getAttribute("loggedInUser");
 * 
 * if(currentUser == null) { return null; }
 * 
 * return currentUser;
 * 
 * }
 * 
 * 
 * }
 */