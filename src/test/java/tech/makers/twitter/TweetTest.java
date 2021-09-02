package tech.makers.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TweetTest {
    private Clock mockClock;

    @BeforeEach
    void setup() {
        String expectedTime = "2021-01-01T01:00:00Z";
        ZoneId zoneid = ZoneId.systemDefault();
        mockClock = Clock.fixed(Instant.parse(expectedTime), zoneid);
    }

    @Test
    void testConstructs() {
        Tweet subject = new Tweet("Hello, world!", mockClock);
        assertEquals("Hello, world!", subject.getBody());
        assertEquals(null, subject.getId());
        assertEquals(LocalDateTime.now(mockClock), subject.getCreatedAt());
    }

    @Test
    void testToString() {
        Tweet subject = new Tweet("Hello, world!", mockClock);
        assertEquals("Tweet[id=null, body='Hello, world!', createdAt=" + LocalDateTime.now(mockClock) + "]", subject.toString());
    }
}
