public class User {
    int id;
    String name;
    String password;
 public User(int id,String name,String password){
    this.id = id;
 this.name = name;
     this.password = password;
 }
 public int getid(){
    return id;
 }
 public String getname(){
    return name;
 }
 public String getpassword(){
    return password;
 }
 public void setid(int id) {
        this.id = id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setpassword(String password) {
        this.password = password;
    }
 public void hienthi(){
    System.out.println("id :" + id + " name : " + name + " password : " + password );
 }
}