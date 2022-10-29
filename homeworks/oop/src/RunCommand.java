import java.lang.reflect.Field;
import java.util.Objects;

public class RunCommand implements CreatingPerson{

    private String command;
    private String[] parameters;
    private PrincessesCollections princessesCollections;

    public RunCommand(String command, String[] parameters, PrincessesCollections princessesCollections) {
        this.command = command;
        this.parameters = parameters;
        this.princessesCollections = princessesCollections;
    }

    public void run() {
        String SYNTAX_ERROR = "Syntax error";
        Field[] FIELDS = Person.class.getDeclaredFields();
        boolean CHECK = (parameters != null) && (parameters.length == FIELDS.length);

        switch (this.command) {
            case "list" -> {
                if ((parameters != null)){
                    System.out.println(SYNTAX_ERROR);
                } else {
                    this.princessesCollections.getPersonsList();
                }
            }
            case "add" -> {
                if (CHECK)  {
                    this.princessesCollections.addPerson(Objects.requireNonNull(createPerson(parameters)));
                } else  {
                    System.out.println(SYNTAX_ERROR);
                }
            }
            case "get" -> {
                if (parameters == null || parameters.length > 1)  {
                    System.out.println(SYNTAX_ERROR);
                } else {
                    this.princessesCollections.getPerson(Integer.parseInt(parameters[0]));
                }
            }
            case "update" -> {
                if (CHECK) {
                    this.princessesCollections.updatePerson(createPerson(parameters));
                } else {
                    System.out.println(SYNTAX_ERROR);
                }
            }
            case "delete" -> {
                if (parameters != null) {
                    this.princessesCollections.removePerson(Integer.parseInt(parameters[0]));
                } else {
                    System.out.println(SYNTAX_ERROR);
                }
            }
            case "help" -> System.out.println("list\nadd\nget\nupdate\ndelete\nexit");
            case "exit" -> {}
            default -> System.out.println("The command does not exist");
        }
    }
}
