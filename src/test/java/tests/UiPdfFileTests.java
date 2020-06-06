package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;


@Epic("QA.GURU automation course")
@Story("File tests")
@Tag("file")
@Tag("pdf")
class UiPdfFileTests {

    @Test
    void successfulSearchForTextInPdfFile() throws IOException {
//        Configuration.reportsFolder = <desired location for downloaded files>; чтобы поменять путь скачанных файлов
        String expectedFileText = "pdf_file.pdf";

        String jenkinsLogin = "testuser";
        String jenkinsPassword = "testpassword%";

        open("https://jenkins.autotests.cloud/login");
        $(byName("j_username")).val(jenkinsLogin);
        $(byName("j_password")).val(jenkinsPassword).pressEnter();
        $(withText(jenkinsLogin)).shouldBe(Condition.visible);

        open("https://jenkins.autotests.cloud/job/files_job/ws/src/test/resources/files/");

        File actualFile = $("[href='pdf_file.pdf']").download();

        PDF pdf = new PDF(actualFile);
        assertThat(pdf, PDF.containsText(expectedFileText));
    }

}