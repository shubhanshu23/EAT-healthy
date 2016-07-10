package com.example.dell1.cameraup;

/**
 * Created by dell1 on 26-05-2016.
 */
public class Config {
    // File upload url (replace the ip with your server address)
  public static final String FILE_UPLOAD_URL = "http://192.168.1.4/AndroidFileImage/fileUpload.php?string1="+new Data().imname;
    //public static final String FILE_UPLOAD_URL1 = "http://192.168.43.57:9091/matjava2/getimagename.jsp?string1="+new Data().imname;
   // public static final String FILE_UPLOAD_URL = "http://192.168.43.57/AndroidFileImage/test.php";
    // Directory name to store captured images and videos
    public static final String IMAGE_DIRECTORY_NAME = "Android File Upload";
}
