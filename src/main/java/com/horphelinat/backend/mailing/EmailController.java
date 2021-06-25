package com.horphelinat.backend.mailing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public  class  EmailController {
 
    @Autowired
    public JavaMailSender emailSender;
    @ResponseBody
    public Boolean sendSimpleEmail(String dest,String Obg,String Mssg ) {
    	System.out.println(dest);
    	System.out.println(Obg);
    	System.out.println(Mssg);
        
        try {
        	emailSender = new MailConfig().getJavaMailSender();
        	// Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();
             
            message.setTo(dest);
            message.setSubject(Obg);
            message.setText(Mssg);
            // Send Message!
            this.emailSender.send(message);
            return true;
        }catch (Exception e) {
			System.out.println(e);
			 return false;
		}
         
    }
 
}