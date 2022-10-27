package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
class ListGraph {
    private Set<User> listGraph = new HashSet<>();

    public ListGraph() {
    }

    public Set<User> getListGraph() {
        return listGraph;
    }

    public void setListGraph(Set<User> listGraph) {
        this.listGraph = listGraph;
    }
    public User getUser(User user) {
        if (!listGraph.contains(user)) return null;
        for (User storedUser : listGraph) {
            if (storedUser.equals(user)) return storedUser;
        }
        return null;
    }
    public void put(User userA, User userB) {
        if (!listGraph.contains(userA)){
            listGraph.add(userA);
        }
        if (!listGraph.contains(userB)) {
            listGraph.add(userB);
        }
        listGraph.forEach(i -> {
            if (i.equals(userA)) i.getFriends().add(userB);
            if (i.equals(userB)) i.getFriends().add(userA);
        });
    }
}
class User implements Comparable<User> {
    private String id;
    private List<User> friends = new ArrayList<>();
    private int point;

    public User(String id) {
        this.id = id;
    }



    public String getId() {
        return id;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addOnePoint() {
        this.point += 1;
    }

    public void addTenPoint() {
        this.point += 10;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public int compareTo(User o) {
        if (o.getPoint() - getPoint() != 0) {
            return o.getPoint() - this.getPoint();
        }
        return this.getId().compareTo(o.getId());
    }
}
