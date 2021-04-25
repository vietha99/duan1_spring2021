/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author ADMIN
 */
public class Validate {

    StringBuilder sb = new StringBuilder();

    // kiểm tra tài khoản đăng nhập
    public static boolean checkNull(String text) {
        if (text.isBlank()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkNgay(String ngay) {
        String reDa = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
        if (!ngay.matches(reDa)) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean checkEmail(String email) {
        String reEmail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (!email.matches(reEmail)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkSDT(String SDT) {
            String reSDT = "[0]{1}[1-9]{9}";
        if (!SDT.matches(reSDT)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkSo(String So) {
        try {
            if (Double.parseDouble(So) < 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
      public static boolean checkSoint(String So) {
        try {
            if (Integer.parseInt(So) < 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
//
//	// kiểm tra mật khẩu đăng nhập
//	public  boolean checkPassword( String password) {
//		if (password.isBlank()) {
//			sb.append( "Mật khẩu không được để trống");
//			return false;
//		}
//		if (password.length() < 8 || password.length() > 50) {
//			sb.show(component, "Mật khẩu phải có độ dài từ 8 đến 50 ký tự");
//			return false;
//		}
//		return true;
//	}
//
//	// hàm kiểm tra mật khẩu cũ forrm đổi mật khẩu người dùng
//	public static boolean checkOldPasswordChange(Component component, String oldPassword) {
//		if (oldPassword.isBlank()) {
//			EntityMessage.show(component, "Chưa nhập mật khẩu cũ");
//			return false;
//		}
//		if (!oldPassword.equals(EntityAuthorization.USER.getMatKhau())) {
//			EntityMessage.show(component, "Mật khẩu cũ không chính xác");
//			return false;
//		}
//		return true;
//	}
//
//	// hàm kiểm tra mật khẩu mới form đổi mật khẩu
//	public static boolean checkNewPasswordChange(Component component, String newPassword) {
//		if (newPassword.length() == 0) {
//			EntityMessage.show(component, "Chưa nhập mật khẩu mới");
//			return false;
//		}
//		if (newPassword.length() < 8 || newPassword.length() > 50) {
//			EntityMessage.show(component, "Mật khẩu phải có độ dài từ 8 - 50 ký tự");
//			return false;
//		}
//		return true;
//	}
//
//	// hàm kiểm tra xác nhận mật khẩu form đổi mật khẩu
//	public static boolean checkConfirmNewPasswordChange(Component component, String confirmNewPassword) {
//		if (confirmNewPassword.length() == 0) {
//			EntityMessage.show(component, "Chưa nhập xác nhận mật khẩu mới");
//			return false;
//		}
//		return true;
//	}
//
//	// kiểm tra số nguyên dương
//	public static boolean checkPositiveNumber(Component component, String number) {
//		String regex = "\\d+";
//		if (number.isBlank()) {
//			EntityMessage.show(component, "Vui lòng nhập số lượng");
//			return false;
//		}
//		try {
//			if (!number.matches(regex) || Integer.parseInt(number) <= 0) {
//				EntityMessage.show(component, "Nhập số nguyên dương");
//				return false;
//			}
//		} catch (Exception e) {
//			EntityMessage.show(component, "Nhập số nguyên dương");
//			return false;
//		}
//		return true;
//	}
//
//	// kiểm mã hóa đơn
//	public static boolean checkIdNumber(Component component, String idNumber) {
//		String regex = "\\d+";
//		if (idNumber.isBlank()) {
//			EntityMessage.show(component, "Vui lòng nhập một số");
//			return false;
//		}
//		try {
//			if (!idNumber.matches(regex) || Integer.parseInt(idNumber) <= 0) {
//				EntityMessage.show(component, "Nhập số nguyên dương");
//				return false;
//			}
//		} catch (Exception e) {
//			EntityMessage.show(component, "Nhập số nguyên dương");
//			return false;
//		}
//		return true;
//	}
//
//	// check tên tiếng việt
//	public static boolean checkName(Component component, String name) {
//		if (name.isBlank()) {
//			EntityMessage.show(component, "Họ tên không được để trống");
//			return false;
//		}
//		String regx = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹý\s]+$";
//		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
//		Matcher matcher = pattern.matcher(name);
//		if (!matcher.find()) {
//			EntityMessage.show(component, "Họ tên không hợp lệ");
//			return false;
//		}
//		return true;
//	}
//
//	// kiểm tra số điện thoại
//	public static boolean checkPhoneNumber(Component component, String phoneNumber) {
//		String regex = "(84|0)+([0-9]{9})\\b";
//		if (phoneNumber.isBlank()) {
//			EntityMessage.show(component, "Số điện thoại không được để trống");
//			return false;
//		}
//		if (!phoneNumber.matches(regex)) {
//			EntityMessage.show(component, "Số điện thoại không hợp lệ");
//			return false;
//		}
//		return true;
//	}
//
//	// kiểm tra số tiền
//	public static boolean checkMoney(Component component, String money) {
//		String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
//		if (money.isBlank()) {
//			EntityMessage.show(component, "Số tiền không được để trống");
//			return false;
//		}
//		if (!money.matches(regex)) {
//			EntityMessage.show(component, "Số tiền không hợp lệ");
//			return false;
//		}
//		return true;
//	}
//
//	// check birth of date > 18 years old
//	public static boolean checkNgaySinh(Component component, Date date, boolean check) {
//		if (date == null && check ==true) {
//			EntityMessage.show(component, "Ngày sinh trống");
//			return false;
//		}
//		if(date == null) {
//			return false;
//		}
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		int yearOfBirth = calendar.get(Calendar.YEAR);
//		calendar.setTime(new Date());
//		int yearNow = calendar.get(Calendar.YEAR);
//		if (yearNow - yearOfBirth <= 18) {
//			EntityMessage.show(component, "Ngày sinh phải trên 18 tuổi");
//			return false;
//
//		}
//		return true;
//
//	}
//
//	// validate email
//	public static boolean checkEmail(Component component, String email) {
//		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
//		if (email.isBlank()) {
//			EntityMessage.show(component, "Email trống");
//			return false;
//		}
//		if (!email.matches(regexEmail)) {
//			EntityMessage.show(component, "Email không hợp lệ");
//			return false;
//		}
//		return true;
//	}
//}
}
