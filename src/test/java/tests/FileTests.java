package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;


@Epic("QA.GURU automation course")
@Story("File tests")
@Tag("file")
class FileTests {

    @Test
    void successfulFileCheck() {

        assertTrue(true);

    }


}