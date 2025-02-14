import java.util.*;

public class SocialNetwork {
    private Map<Integer, MainUser> users; 
    private Map<Integer, List<Integer>> friendships;

    public SocialNetwork() {
        users = new HashMap<>();
        friendships = new HashMap<>();
    }

  
    public void addUser(int id, String name) {
        users.put(id, new MainUser(id, name));
        friendships.put(id, new ArrayList<>());
    }

 
    public void addFriendship(int userId1, int userId2) {
        if (users.containsKey(userId1) && users.containsKey(userId2)) {
            friendships.get(userId1).add(userId2);
            friendships.get(userId2).add(userId1);
        }
    }

 
    public List<Integer> suggestFriends(int userId) {
        List<Integer> suggestions = new ArrayList<>();
        if (!users.containsKey(userId)) return suggestions;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(userId);
        visited.add(userId);
        int level = 0;

        while (!queue.isEmpty() && level < 2) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int currentUser = queue.poll();
                for (int friend : friendships.get(currentUser)) {
                    if (!visited.contains(friend)) {
                        visited.add(friend);
                        queue.add(friend);
                        if (level == 2) {
                            suggestions.add(friend);
                        }
                    }
                }
            }
        }


        System.out.println("User " + userId + " direct friends: " + friendships.get(userId));
        System.out.println("Friend suggestions (level 2): " + suggestions);

        return suggestions;
    }


    public MainUser getUser(int userId) {
        return users.get(userId);
    }
}