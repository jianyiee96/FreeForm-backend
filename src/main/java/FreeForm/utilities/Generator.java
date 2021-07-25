package FreeForm.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator {

    public static String generateRandomString(int length){
        String generatedString = RandomStringUtils.randomAlphabetic(length);
        return generatedString;
    }

}
