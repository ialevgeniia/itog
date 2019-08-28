import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPoint3 {
    @Test
    public void testdist () {
        Point p1 = new Point (-5,-10);
        Point p2 = new Point (-2,-3);
        Assert.assertEquals(p1.distance(p2), 7.615773105863909);
    }
}
