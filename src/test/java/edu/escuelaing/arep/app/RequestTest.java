package edu.escuelaing.arep.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class RequestTest {

    @Test
    public void testParseQueryString() {
        Request req = new Request("name=Nick&age=21");

        assertEquals("Nick", req.getValues("name"));
        assertEquals("21", req.getValues("age"));
    }

    @Test
    public void testEmptyQueryString() {
        Request req = new Request("");
        assertNull(req.getValues("name"));
    }

    @Test
    public void testNullQueryString() {
        Request req = new Request(null);
        assertNull(req.getValues("name"));
    }
}
