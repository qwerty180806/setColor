import app.Circle;
import misc.Vector2d;

public class Test {


    @org.junit.Test
   public void test1() {
        Circle circle = new Circle(new Vector2d(1, 2), new Vector2d(2, 1));
        Vector2d p = new Vector2d(3, 4);
        assert !circle.contains(p);
    }

    @org.junit.Test
    public void test2() {
        Circle circle = new Circle(new Vector2d(7, 0), new Vector2d(-3, 2));
        Vector2d p = new Vector2d(9, 7);
        assert circle.contains(p);
    }

    @org.junit.Test
    public void test3() {
        Circle circle = new Circle(new Vector2d(2.39, -2.39), new Vector2d(7.77, 7.77));
        Vector2d p = new Vector2d(5, 5);
        assert circle.contains(p);
    }

    @org.junit.Test
    public void test4() {
        Circle circle = new Circle(new Vector2d(4.93, 1.7), new Vector2d(6.39, -6));
        Vector2d p = new Vector2d(-5, -7);
        assert !circle.contains(p);
    }
}
