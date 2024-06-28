import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.MovieManager;

public class MovieManagerTest {


    @Test
    public void testAddZero() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddOneMovie() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddSeveralMovies() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Отель Белград");
        manager.addMovie("Вперед");

        String[] expected = {"Бладшот", "Отель Белград", "Вперед"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastBeforeSetLimit() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastBeforeCurrentLimit() {
        int limit = 7;
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
