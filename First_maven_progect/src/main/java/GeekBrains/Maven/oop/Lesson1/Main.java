package GeekBrains.Maven.oop.Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.setRun(3);
        human.setJump(2);

        Robot robot = new Robot();
        robot.setRun(1);
        robot.setJump(2);

        Cat cat = new Cat();
        cat.setRun(5);
        cat.setJump(1);

        ArrayList<Member> membersList = new ArrayList<Member>();
        membersList.add(human);
        membersList.add(robot);
        membersList.add(cat);

        Wall wall = new Wall();
        wall.setHeight(3);

        Bypath bypath = new Bypath();
        bypath.setLength(2);

        List<Let> objectsList = new ArrayList<Let>();
        objectsList.add(wall);
        objectsList.add(bypath);

        for (int i = 0; i < membersList.size(); i++) {
            for (int j = 0; j < objectsList.size(); j++) {
                if (membersList.get(i).kann()) {
                    membersList.get(i).run(objectsList.get(j).getLength());
                }
                if (membersList.get(i).kann()) {
                    membersList.get(i).jump(objectsList.get(j).getHeight());
                }
            }
        }
    }
}
