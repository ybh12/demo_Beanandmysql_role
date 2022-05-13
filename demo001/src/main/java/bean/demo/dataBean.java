package bean.demo;

public class dataBean {
	 //定义成员变量
	 private int id_user;
	 private String account;
	 private String password;
	 private String username;
	 private String gender; 
	 private String department;
	 private String access_rights; 
	 
	 public dataBean() {
	  
	 }
	 
	 public dataBean(int id_user, String account, String password, String username, String gender, String department,
	   String access_rights) {
	  super();
	  this.id_user = id_user;
	  this.account = account;
	  this.password = password;
	  this.username = username;
	  this.gender = gender;
	  this.department = department;
	  this.access_rights = access_rights;
	 }
	 
	 
	 public int getId_user() {
	  return id_user;
	 }
	 public void setId_user(int id_user) {
	  this.id_user = id_user;
	 }
	 public String getAccount() {
	  return account;
	 }
	 public void setAccount(String account) {
	  this.account = account;
	 }
	 public String getPassword() {
	  return password;
	 }
	 public void setPassword(String password) {
	  this.password = password;
	 } 
	 public String getUsername() {
	  return username;
	 }
	 public void setUsername(String username) {
	  this.username = username;
	 }
	 public String getGender() {
	  return gender;
	 }
	 public void setGender(String gender) {
	  this.gender = gender;
	 }
	 public String getDepartment() {
	  return department;
	 }
	 public void setDepartment(String department) {
	  this.department = department;
	 }
	 public String getAccess_rights() {
	  return access_rights;
	 }
	 public void setAccess_rights(String access_rights) {
	  this.access_rights = access_rights;
	 }
		
	}
	 
	