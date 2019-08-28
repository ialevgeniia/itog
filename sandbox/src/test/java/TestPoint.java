import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoint {
    @Test
    public void testdist () {
        Point p1 = new Point (5,1);
        Point p2 = new Point (8,9);
        Assert.assertEquals(p1.distance(p2), 8.54400374531753);
    }
}
