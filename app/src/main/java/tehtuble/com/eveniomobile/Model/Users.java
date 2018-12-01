package tehtuble.com.eveniomobile.Model;

public class Users {
    String name, email,  idNum, role;


    public Users(){

    }

    public Users(String name, String email, String idNum, String role) {
        this.name = name;
        this.email = email;
        this.idNum = idNum;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
