/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import CLASS.nhanvien;
import static helper.ShareHelper.resize;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author H2
 */
public class ShareHP {
       public static Image APP_ICON;
    public static int tabSelect = 2;
//    public static final Image APP_ICON;
//
//
//
//    public static boolean saveLogo(File file) {
//        File dir = new File("logos");
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//        File newFile = new File(dir, file.getName());
//        try {
//            Path source = Paths.get(file.getAbsolutePath());
//            Path destination = Paths.get(newFile.getAbsolutePath());
//            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }
//    }
//    static {
//        String file = "/img/fpt.png";
//        APP_ICON = new ImageIcon(ShareHP.class.getResource(file)).getImage();
//    }
////doc logo
//    public static ImageIcon readLogo(String fileName) {
//        File path = new File("logos", fileName);
//        return new ImageIcon(path.getAbsolutePath());
//    }
//chua thong tin ng dang nhap

    /**
     *
     */
    public static nhanvien USER = null;

//xoa thong tin ng dang xuat
    public static void logoff() {
        ShareHP.USER = null;
    }

//    /**
//     * * Kiểm tra xem đăng nhập hay chưa
//     *
//     * @return đăng nhập hay chưa
//     */
    public static boolean authenticated() {
        return ShareHP.USER != null;
    }
        public static Image resize(String url, int width,int height) {
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage();
        Image reImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return reImage;
    }
            public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        Image image = resize(path.getAbsolutePath(), 159, 206);
        return new ImageIcon(image);
    }
}
