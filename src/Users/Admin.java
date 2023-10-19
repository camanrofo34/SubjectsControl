package Users;

public class Admin extends Person{
    boolean permission;
    public Admin(String id, String name, String lastName, String birthday, String mail,boolean permission) {
        super(id, name, lastName, birthday, mail);
        this.permission=permission;
    }

    public boolean isPermission() {
        return permission;
    }
}
