import org.testng.annotations.Test;

public class AutoRect {
    @Test
    public void testArea () {
        Rectangle r = new Rectangle(3,4);

        assert r.area() == 11;
    }
}
