package com.example.springboot;

import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VTDParserTest {

    private static final String DTD_OUTPUT_XML = "dtd_output.xml";
    private static final String EXTERNAL_OUTPUT_XML = "external_output.xml";
    private static final String PARAMETER_OUTPUT_XML = "parameter_output.xml";

    @Test
    public void testExternalXmlParser() throws Exception {
        try {
            final byte[] contents = getFileContent("src/test/resources/external.xml");
            VTDGen vtdGen = new VTDGen();
            vtdGen.setDoc(contents);
            vtdGen.parse(false);
            VTDNav vtdNav = vtdGen.getNav();
            vtdNav.dumpXML(EXTERNAL_OUTPUT_XML);
        }
        finally {
            final File outputFile = new File(EXTERNAL_OUTPUT_XML);
            if (outputFile.exists()) {
                outputFile.delete();
            }
        }
    }

    @Test
    public void testParameterParser() throws Exception {
        try {
            final byte[] contents = getFileContent("src/test/resources/parameter.xml");

            VTDGen vtdGen = new VTDGen();
            vtdGen.setDoc(contents);
            vtdGen.parse(false);
            VTDNav vtdNav = vtdGen.getNav();
            vtdNav.dumpXML(PARAMETER_OUTPUT_XML);
        }
        finally {
            final File outputFile = new File(PARAMETER_OUTPUT_XML);
            if (outputFile.exists()) {
                outputFile.delete();
            }
        }
    }

    @Test
    public void testDTDParser() throws Exception {
        try {
            final byte[] contents = getFileContent("src/test/resources/dtd.xml");
            VTDGen vtdGen = new VTDGen();
            vtdGen.setDoc(contents);
            vtdGen.parse(false);
            VTDNav vtdNav = vtdGen.getNav();
            vtdNav.dumpXML(DTD_OUTPUT_XML);
        }
        finally {
            final File outputFile = new File(DTD_OUTPUT_XML);
            if (outputFile.exists()) {
                outputFile.delete();
            }
        }
    }

    public byte[] getFileContent(final String fileName) throws IOException {
        Path path = Paths.get(fileName);
        final byte[] contentBytes = Files.readAllBytes(path);
        return contentBytes;
    }
}
