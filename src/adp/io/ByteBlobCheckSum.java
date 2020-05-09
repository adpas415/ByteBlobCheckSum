package adp.io;

import java.security.MessageDigest;

public class ByteBlobCheckSum {

    public static String checkSum(byte[] byteBlob) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.update(byteBlob);

        return encodeHexString(md.digest());

    }

    private static String encodeHexString(byte[] byteArray) {

        StringBuilder hexStringBuffer = new StringBuilder();

        for (byte b : byteArray) hexStringBuffer.append(byteToHex(b));

        return hexStringBuffer.toString();

    }

    private static String byteToHex(byte num) {

        char[] hexDigits = new char[2];

        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);

        return new String(hexDigits);

    }

}
