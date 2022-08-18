package com.QA.Tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.matchers.ContainsExactText;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class SelenideDownloadTest {


    ClassLoader cl = SelenideDownloadTest.class.getClassLoader();


    @Test
    void downloadTest() throws IOException {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/junit-bom/README.md");
        File textFile = $("#raw-url").download();
        InputStream is = new FileInputStream(textFile);
        try {  //try + finally нужен, если вдруг возникнет исключение в любом случае файнали сработает is.close()
            byte[] fileContent = is.readAllBytes();
            String strContent = new String(fileContent, StandardCharsets.UTF_8);
            assertThat(strContent).contains("JUnit 5");
        } finally {
            is.close();
        }
    }

    @Test
    void pdfParsingTest() throws Exception {
        InputStream stream = cl.getResourceAsStream("pdf/NumbersOfJuly.pdf");
        PDF pdf = new PDF(stream);
        Assertions.assertEquals(1, pdf.numberOfPages);
        assertThat(pdf, new ContainsExactText("044525974"));
        //InputStream is = new FileInputStream("pdf/NumbersOfJuly.pdf");
    }

    @Test
    void xlsParsingTest() throws Exception {
        InputStream stream = cl.getResourceAsStream("xls/file_example_XLS_10.xls");
        XLS xls = new XLS(stream);
        //String stringCellValue = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        String stringCellValue = xls.excel.getSheetAt(1).getRow(1).getCell(1).getStringCellValue();
        org.assertj.core.api.Assertions.assertThat(stringCellValue).contains("JUnit 5");
    }

    @Test
    void csvParsingTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("csv/testFile.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            List<String[]> content = reader.readAll();
            org.assertj.core.api.Assertions.assertThat(content).contains(
                    new String[]{"Name", " Surname"},
                    new String[]{"Vadim", " Fazlyev"},
                    new String[]{"Ravil", " Razetdinov"}
            );
        }
    }

    @Test
    void zipParsingTest() throws Exception {
        ZipFile zf = new ZipFile(new File("/Users/c0ldeyes/IdeaProjects/Selenium/src/test/resources/zip/file_example_XLS_10xls.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("zip/file_example_XLS_10xls.zip"));
        ZipEntry entry;

        while ((entry = is.getNextEntry()) != null) {
            // if (entry.isDirectory()) {
            //    System.out.println();


            org.assertj.core.api.Assertions.assertThat(entry.getName()).isEqualTo("file_example_XLS_10.xls");
            try (InputStream inputStream = zf.getInputStream(entry)) {
                //checks
            }
        }
    }
}

// ДЗ: Разбор зип файлов и их содержимых


// try (InputStream is = new FileInputStream(textFile)) - современный способ сделать finally
// в try указываем блок ресурсов, который нужно будет закрыть
// finally тут уже не нужен
// Input/output - работают с массивами байт
// reader/writer - работаю с массивами символ