package pro1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main5Test
{
    @Test
    void test01()
    {
        // TODO 5.2: Oprav test
        assertEquals(
                "J20,J21,J22,J23,J24",
                Main5.roomsSummary("KIKM",2024)
        );
    }
}