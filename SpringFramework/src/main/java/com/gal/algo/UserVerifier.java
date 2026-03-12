package com.gal.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserVerifier {

    @Autowired
    OtpGenerator otpGenerator;

    @Autowired
    OtpGenerator fourDigitOtpGenerator;

    @Autowired
    OtpGenerator sixDigitOtpGenerator;

    @Autowired
    public UserVerifier(OtpGenerator otpGenerator){
        super();
        System.out.println("Constructor setting the otpGenerator" + otpGenerator);
        this.otpGenerator = otpGenerator;
    }

    @Autowired
    public void setUserVerifier(OtpGenerator otpGenerator){
        System.out.println("Setting setter otpGenerator" + otpGenerator);
        this.otpGenerator = otpGenerator;
    }

    public OtpGenerator getOtpGenerator(){
        return otpGenerator;
    }
    public void verifyUser(){
        String otp = otpGenerator.getOtp();
        if(otp != null){
            System.out.println("User verified");
        }
        else{
            System.out.println("verification failed");
        }
        System.out.println(otpGenerator);
        System.out.println(sixDigitOtpGenerator);
        System.out.println(fourDigitOtpGenerator);
    }

}







//it automatically connect, it says within this obj i need an otp generator, take one otp generator and inject here
//it can be written on a variable, constructor
//autowired on constructor will check the parameter injected about what it performs
