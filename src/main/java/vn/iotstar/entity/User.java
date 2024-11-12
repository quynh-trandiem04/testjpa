package vn.iotstar.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users") 
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(length = 15)
    private String phone;

    @Column(name = "password", nullable = false, length = 32)
    private String passWord;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "signup_date")
    private Date signupDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "is_admin")
    private boolean isAdmin;

    public User() {
        super();
    }

    public User(String email, String fullName, String phone, String passWord, Date signupDate, Date lastLogin,
                boolean isAdmin) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.passWord = passWord;
        this.signupDate = signupDate;
        this.lastLogin = lastLogin;
        this.isAdmin = isAdmin;
    }

    // Các getter và setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", fullName=" + fullName + ", phone=" + phone + ", passWord="
                + passWord + ", signupDate=" + signupDate + ", lastLogin=" + lastLogin + ", isAdmin=" + isAdmin + "]";
    }

	public int getIs_admin() {
		// TODO Auto-generated method stub
		return 0;
	}
}
