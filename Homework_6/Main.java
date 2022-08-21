package Homework_6;

public class Main {
    public static void main(String[] args) {

        Pet spider = new Pet(Species.SPIDER, "Awful", 21, 34, new String[]{"running", "biting"});
        Pet dog = new Pet(Species.DOG, "Charax", 2, 51, new String[]{"eating", "drinking"});
        Human father = new Human("Mike", "Alba", 1968 );
        Human mother = new Human("Valentina", "Alba", 1970);

        Family family = new Family(mother, father);

        Human child = new Human("Jessica", "Smith", 2000, 88,
                new String[][]{{DayofWeek.MONDAY.name(), "go to gym"}}, family);

        family.addChild(child);
        family.addChild(child);

        family.setPet(spider);

        System.out.println(family.countFamily());
        System.out.println(family);

        family.deleteChild(1);
        System.out.println(family.countFamily());


    }




}