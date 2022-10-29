import java.util.Arrays;

public class Person {

    private int id;
    private String name;
    private int age;
    private String hairColor;
    private String eyeColor;

    public Person(int id, String name, int age, String hairColor, String eyeColor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    public boolean checkPerson() {
        boolean result = true;

        String[] validHairColor = {
                "Black",
                "Blonde",
                "Platinum-blonde",
                "Strawberry-blonde",
                "Red",
                "Brown",
        };
        String[] validEyeColor = {
                "Brown",
                "Blue",
                "Violet",
                "Hazel",
        };


        if (id < 0) {
            System.out.println("The Id value cannot be negative.");
            result = false;
        }
        if ((name.length() == 0) || (name.length() > 30)) {
            System.out.println("The name value can contain from 1 to 30 characters.");
            result = false;
        }
        if (age < 0 || age>99) {
            System.out.println("The age value can be from 0 to 99.");
            result = false;
        }
        if (!Arrays.asList(validHairColor).contains(hairColor)){
            System.out.println("The hair color may be as follows: " + Arrays.toString(validHairColor));
            result = false;
        }
        if (!Arrays.asList(validEyeColor).contains(eyeColor)){
            System.out.println("The eye color may be as follows: " + Arrays.toString(validEyeColor));
            result = false;
        }
        return result;
    }

    public String getPerson() {
        return String.format(
                """
                        %s
                        Age: %d
                        Hair: %s
                        Eyes: %s
                        """,
                name, age, hairColor, eyeColor
        );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
}
