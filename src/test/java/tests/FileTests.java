package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.FileUtils;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


@Epic("QA.GURU automation course")
@Story("File tests")
@Tag("file")
class FileTests {

    @Test
    void successfulSearchForTextInFile() {
        String expectedFileText = "Here is your text3 in file!";
        String actualFileText = new FileUtils().readStringFromFile("src/test/resources/files/file.txt");
        System.out.println("Actual text from file: \n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));

//        assertTrue(actualFileText.contains(expectedFileText),
//                "\nExpected text: \n" + expectedFileText + "\n" +
//                "Actual text: \n" + actualFileText);
    }

    @Test
    void successfulSearchForTextInFileRoot() {
        String expectedFileText = "Here is your text3 in file!";
        String actualFileText = new FileUtils().readStringFromFile("file_root.txt");
        System.out.println("Actual text from file: \n" + actualFileText);

        assertThat(actualFileText, containsString(expectedFileText));
    }

}