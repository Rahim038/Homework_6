package Homework_6;

import java.util.Arrays;
import java.util.Objects;
public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    @Override
    public String toString() {
        if (getPet() == null && getChildren().length == 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    '}';
        } else if (getPet() != null && getChildren().length == 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ",\n pet=" + pet +
                    '}';
        } else if (getPet() == null && getChildren().length != 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ",\n children=" + Arrays.toString(children) +
                    '}';
        }
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ",\n children=" + Arrays.toString(children) +
                ",\n pet=" + pet +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Homework_6.Family)) return false;
        if (obj == this) return true;

        Homework_6.Family family = (Homework_6.Family) obj;
        return mother.equals(family.mother) && father.equals(family.father) && Arrays.equals(children, family.getChildren());
    }
    @Override
    public void finalize() throws Throwable {
        System.out.println(this + " object collected by Garbage Collector");
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(this.mother, this.father);
        result = 31 * result + Arrays.hashCode(this.children);
        return result;
    }
    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.pet = getPet();
        father.setFamily(this);
        mother.setFamily(this);
    }
    public void addChild(Human child){
        child.setFamily(this);
        Human[] newChildren = Arrays.copyOf(this.children,this.children.length + 1);
        newChildren[newChildren.length-1] = child;
        this.children=newChildren;
    }
    public boolean deleteChild(int index) {
        if (index > this.children.length - 1) return false;
        Human[] newChildren = new Human[this.children.length - 1];
        int counter = 0;
        for (int i = 0; i < this.children.length; i++) {
            if (i != index) {
                newChildren[counter++] = this.children[i];
            }
        }
        this.children[index].setFamily(null);
        this.children = newChildren;
        return true;
    }
    public int countFamily(){
        return this.children.length + (mother != null ? 1 : 0) + (father != null ? 1 : 0);
    }
    public void describePet() {
        String slyLevel = "";
        if (getPet().getTrickLevel() >= 50) {
            slyLevel = "he is very sly";
        } else {
            slyLevel = "almost not sly";
        }
        System.out.println("I have a " + getPet().getSpecies() + ", he is " + getPet().getAge() + " years old, " + slyLevel);
    }
    public void greetPet() {
        System.out.println("Hello," + getPet().getNickName());
    }
    public void feedPet(boolean feedTime) {
        if (feedTime) {
            System.out.println("Hm... I will feed " + getPet().getNickName());
        } else {
            System.out.println("I think " + getPet().getNickName() + " is not hungry.");
        }
    }
    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human[] getChildren() {
        return children;
    }
    public void setChildren(Human[] children) {
        this.children = children;
    }
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
}