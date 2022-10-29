import java.io.*;
import java.util.Map;

public class PrincessesCollections implements CreatingPerson {

    private final Map<Integer, Person> map;

    public PrincessesCollections(Map<Integer, Person> map) {
        this.map = map;
    }

    public void getPersonsList() {
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getPerson());
        }
    }

    public void addPerson(Person person) {
        if (person.checkPerson()) {
            if (!map.containsKey(person.getId())) {
                map.put(person.getId(), person);
                System.out.printf("Princess %s has been added.%n", person.getName());
            } else {
                System.out.println("The Princess exists.");
            }
        }
    }

    public void getPerson(int id) {
        if (map.containsKey(id)) {
            System.out.println(map.get(id).getPerson());
        } else {
            System.out.println("Id was not found.");
        }
    }

    public void updatePerson (Person person) {
        if (map.containsKey(person.getId())) {
            person.checkPerson();
            System.out.printf(String.format("Princess %d %s has been updated.%n",
                    map.get(person.getId()).getId(),
                    map.get(person.getId()).getName())
            );

            Person updatedPerson = map.get(person.getId());
            updatedPerson.setId(person.getId());
            updatedPerson.setName(person.getName());
            updatedPerson.setAge(person.getAge());
            updatedPerson.setHairColor(person.getHairColor());
            updatedPerson.setEyeColor(person.getEyeColor());
        } else {
            System.out.println("Princess was not found");
        }
    }

    public void removePerson(int id) {
        try {
            System.out.printf("Princess \"%s\" has been removed%n", map.get(id).getName());
            map.remove(id);
        } catch (Exception invalidId) {
            System.out.println("Princess was not found.");
        }

    }
    public void addFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                String[] personFields = line.replace(" | ", "&").split("&");
                Person person = createPerson(personFields);
                person.checkPerson();
                map.put(person.getId(), person);
        }
            System.out.println("The file has been added.");

        } catch (Exception e) {
            System.out.println("The file was not added.");
        }
        reader.close();
    }
}
