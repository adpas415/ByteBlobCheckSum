package adp.io;

import java.security.MessageDigest;

public class ByteBlobCheckSum {

    public static String checkSum(byte[] byteBlob) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(byteBlob);

        return encodeHexString(md.digest());

    }

    private static String encodeHexString(byte[] byteArray) {

        StringBuffer hexStringBuffer = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++)
            hexStringBuffer.append(byteToHex(byteArray[i]));

        return hexStringBuffer.toString();

    }

    private static String byteToHex(byte num) {

        char[] hexDigits = new char[2];

        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);

        return new String(hexDigits);

    }

}
