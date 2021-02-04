package JavaPVT.HW_19_2;

public class FamilyPerson {
    private Family family = new Family();

    public FamilyPerson addLastName(String lastName) {
        family.setLastName(lastName);
        return this;
    }

    public FamilyPerson addMother(Person mother) {
        family.setMother(mother);
        return this;
    }

    public FamilyPerson addFather(Person father) {
        family.setFather(father);
        return this;
    }

    public FamilyPerson addChildren(Person child) {
        family.setChildren(child);
        return this;
    }

    public Family createFamily(){
        Family newFamily = family;
        family = null;
        return newFamily;
    }
}
