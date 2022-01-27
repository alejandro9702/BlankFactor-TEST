package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

    public String generateRandomEmail() {
        return RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
    }

}


