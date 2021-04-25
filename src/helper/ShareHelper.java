package helper;


import CLASS.Nhanvien_1;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class ShareHelper {

    public static Image APP_ICON;
    public static int tabSelect = 2;

    ShareHelper() {
// Tải biểu tượng ứng dụng
        String file = "/com/polypro/icon/fpt.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }

    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     *
     * @param file là đối tượng file ảnh
     * @return chép được hay khôngPROJECT DOCUMENT SAMPLE PROJECT - ỨNG DỤNG
     * PHẦN MỀM PAGE 61
     */
    public static boolean saveLogo(File file) {
        File dir = new File("logos");
// Tạo thư mục nếu chưa tồn tại
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
// Copy vào thư mục logos (đè nếu đã tồn tại)
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Image resize(String url, int width,int height) {
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage();
        Image reImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return reImage;
    }
 public static Nhanvien_1 USER = null;
    /**
     * Đọc hình ảnh logo chuyên đề
     *
     * @param fileName là tên file logo
     * @return ảnh đọc được
     */
    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        Image image = resize(path.getAbsolutePath(), 159, 206);
        return new ImageIcon(image);
    }
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
//    public static Nhanvien USER = null;

    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
//    public static void logoff() {
//        ShareHelper.USER = null;
//    }

    /**
     * Kiểm tra xem đăng nhập hay chưa
     *
     * @return đăng nhập hay chưa
     */
//    public static boolean authenticated() {
//        return ShareHelper.USER != null;
//    }
}
