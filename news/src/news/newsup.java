package news;

public class newsup {
  private int uid;
  private static String title;
  private static String opentime;
  private static String detial;
  private static String address;
  private static String province;
  private static String username;
  private static String photo;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public static String getTitle() {
	return title;
}
public static void setTitle(String title) {
	newsup.title = title;
}


public static String getOpentime() {
	return opentime;
}
public static void setOpentime(String opentime) {
	newsup.opentime = opentime;
}
public static String getDetial() {
	return detial;
}
public static void setDetial(String detial) {
	newsup.detial = detial;
}
public static String getAddress() {
	return address;
}
public static void setAddress(String address) {
	newsup.address = address;
}
public static String getProvince() {
	return province;
}
public static void setProvince(String province) {
	newsup.province = province;
}

public static String getUsername() {
	return username;
}
public static void setUsername(String username) {
	newsup.username = username;
}
public static String getPhoto() {
	return photo;
}
public static void setPhoto(String photo) {
	newsup.photo = photo;
}

}
