package LamaczHasel;

import java.util.Random;

/**
 *
 * @author bartosz.kalinowski
 */
public class Worker {

    private String name;
    private String surname;
    private Date birth;

    public Worker(String name, String surname, Date birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String initials() {
        return name.substring(0, 1) + surname.substring(0, 1);
    }

    @Override
    public String toString() {
        return initials() + birth;
    }

    public static Worker getRandomWorker() {
        Random r = new Random();

        String name = "";
        name += (char) (r.nextInt(26) + 65);
        int length = r.nextInt(10) + 3;
        for (int i = 0; i < length; i++) {
            name += (char) (r.nextInt(26) + 97);
        }
        String surname = "";
        surname += (char) (r.nextInt(26) + 65);
        length = r.nextInt(13) + 3;
        for (int i = 0; i < length; i++) {
            surname += (char) (r.nextInt(26) + 97);
        }
        Date date = new Date(r.nextInt(110) + 1900, r.nextInt(12) + 1, r.nextInt(31) + 1);

        return new Worker(name, surname, date);
    }
}
