package Model;
public abstract class User {
    private String id;
    private String name;
    private String sex;

    public User(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Sex='" + sex + '\'' +
                '}';
    }
}
