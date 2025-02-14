import java.util.HashSet;
import java.util.Set;

public class MainUser{
    private int id;
    private String name;
    private Set<Integer> friends;

    public MainUser(int id, String name){
        this.id = id;
        this.name = name;
        this.friends = new HashSet<>();
    }

public int getId(){
    return id;
}
public String getName(){
    return name;
}
public void addFriend(int friendId){
    friends.add(friendId);
}
public Set<Integer> getfriends(){
    return friends;
}
}