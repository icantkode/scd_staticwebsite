package com.scd.scdweb.Waitlister;

import com.scd.scdweb.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prelaunch")
public class WaitlisterController {

    @Autowired
    WaitlisterService waitlisterService;
    @Autowired
    EmailService ems;

    @PostMapping("/submit")
    public String persistWaitLister(@RequestParam String first_name, @RequestParam String last_name, @RequestParam String email) {
        System.out.println(first_name + last_name + email);

        Waitlister waitlister = new Waitlister(email, first_name, last_name);
        waitlisterService.save(waitlister);

        ems.sendEmail(email, "Thankyou for joining the waitlist!", "Hello " + first_name + ",\n" + "Thank you for signing up for the waitlist of Space Invaders 2! We are excited to have you on board.\n" +
                "By joining the waitlist, you'll be among the first to experience Space Invaders 2 in its beta version. Your feedback is valuable to us, and we can't wait to hear what you think.\n" + "Stay tuned for updates and exclusive sneak peeks. We'll keep you posted on all things Space Invaders 2!\n" +
                "Thank you again for your support!\n" +
                "Best regards,\nYour Space Invaders 2 Team"
        );
        ems.sendEmail("ashersiddique127@gmail.com", "someone joined the Space Invaders 2 waitlist", email + " just joined Space Invaders 2 waitlist.");

        return "redirect:http://localhost:8080/thankyou.html";
    }

}
