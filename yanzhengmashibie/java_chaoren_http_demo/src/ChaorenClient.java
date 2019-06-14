
public class ChaorenClient {
    private String user;
    private String password;
    private String softid;
    private String baseUrl = "http://apib.sz789.net:88/";
    //private HttpRequestUtil httpClient = new HttpRequestUtil();
    private static String hexStr =  "0123456789ABCDEF";

    public static String BinaryToHexString(byte[] bytes){
        String result = "";
        String hex = "";
        for(int i=0;i<bytes.length;i++){
            //字节高4位
            hex = String.valueOf(hexStr.charAt((bytes[i]&0xF0)>>4));
            //字节低4位
            hex += String.valueOf(hexStr.charAt(bytes[i]&0x0F));
            result +=hex;
        }
        return result;
    }

    public ChaorenClient(String user,String password,String softid){
        this.user = user;
        this.password = password;
        this.softid = softid;
    }

    public String GetUserInfo(){
        String url = baseUrl + "GetUserInfo.ashx";
        String param = String.format("username=%s&password=%s",this.user,this.password);
        String re = HttpRequestUtil.sendPost(url,param,false);
        return re;
    }

    public String CloudOcr(byte[] img){
        String url = baseUrl + "RecvByte.ashx";
        String imagedata = BinaryToHexString(img);
        String param = String.format("username=%s&password=%s&softid=%s&imgdata=%s",this.user,this.password,this.softid,imagedata);
        String re = HttpRequestUtil.sendPost(url,param,false);
        return re;
    }
}
