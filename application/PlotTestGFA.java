package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PlotTestGFA {
    private Plot plot1, plot5;

    @BeforeEach
    public void setUp() throws Exception {
        plot1 = new Plot(2, 2, 6, 6);
        plot5 = new Plot(3, 4, 4, 3);
    }

    @AfterEach
    public void tearDown() throws Exception {
        plot1 = plot5 = null;
    }

    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
    }

    @Test
    public void testToString() {
        assertEquals("3,4,4,3", plot5.toString());	
    }
}
