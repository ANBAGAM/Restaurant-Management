package com.restaurant.data;

public class Login {
private long loginid;
private String password;


@Override
public String toString() {
	return "Login [loginid=" + loginid + ", password=" + password + "]";
}
public long getLoginid() {
	return loginid;
}
public void setLoginid(long loginid) {
	this.loginid = loginid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
