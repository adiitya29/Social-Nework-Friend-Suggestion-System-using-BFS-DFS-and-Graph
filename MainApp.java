import java.util.List;

public class MainApp{
    public static void main(String[] args) {
        SocialNetwork scn = new SocialNetwork();
        scn.addUser(1, "A");
        scn.addUser(2, "B");
        scn.addUser(3, "C");
        scn.addUser(4, "D");
        scn.addUser(5, "E");

        scn.addFriendship(1, 2);//A-B
        scn.addFriendship(2, 3);//B-C
        scn.addFriendship(3, 4);//C-D
        scn.addFriendship(4, 5);//D-E


        List<Integer> suggestions = scn.suggestFriends(1);
        System.out.println("friend suggestions for A(user id:1): ");

        if (suggestions.isEmpty()){
            System.out.println("no suggestions available");
        }
        else{
            for(int suggestedId: suggestions){
                System.out.println("->"+scn.getUser(suggestedId).getName());
            }
        }
    }
}