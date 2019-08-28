import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoint2 {
    @Test
    public void testdist () {
        Point p1 = new Point (0,0);
        Point p2 = new Point (0,0);
        Assert.assertEquals(p1.distance(p2), 0.0);
    }
}
