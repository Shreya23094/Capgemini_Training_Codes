package com.gal.algo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component(value = "fourDigitOtpGenerator")
@Primary
public class FourDigitOtpGenerator implements OtpGenerator {
    @Override
    public String getOtp(){
        return ""+ new Random().nextInt(10000);
    }
}
