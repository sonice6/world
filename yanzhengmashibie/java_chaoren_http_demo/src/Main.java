import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.Exception;
import javax.imageio.ImageIO;
public class Main {
    public static byte[] toByteArrayFromFile(String imageFile) throws Exception {
        InputStream is = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(imageFile);
            byte[] b = new byte[1024];
            int n;
            while ((n = is.read(b)) != -1) {
                out.write(b, 0, n);
            }// end while
        } catch (Exception e) {
            throw new Exception("System error,SendTimingMms.getBytesFromFile", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }// end try
            }// end if
        }// end try
        return out.toByteArray();
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        ChaorenClient httpClient = new ChaorenClient("youruser","yourpass","3696");
        String re = httpClient.GetUserInfo();
        System.out.println(re);

        byte[] img = toByteArrayFromFile("image.jpg");
        String re2 = httpClient.CloudOcr(img);
        System.out.println(re2);
    }
}
