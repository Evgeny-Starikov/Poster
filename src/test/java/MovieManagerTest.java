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
    public void shouldShowAllUnderLimit() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентельмены"};
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
    public void shouldShowLastBeforeManuallySetLimit() {
        MovieManager manager = new MovieManager(7);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testShowLastManuallySetLimit() {

        MovieManager manager = new MovieManager(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastManuallySetAfterLimit() {

        MovieManager manager = new MovieManager(4);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");

        String[] expected = {"Джентельмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastManuallySetOneAfterLimit() {

        MovieManager manager = new MovieManager(1);

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastManuallyZero() {

        MovieManager manager = new MovieManager(0);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAll() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");


        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентельмены", "Человек-невидимка", "Тролли. Мировой тур", "Номер один"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOnlyLastMoviesWithinLimit() {
        MovieManager manager = new MovieManager(5);

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