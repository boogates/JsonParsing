package utils;

import exceptions.ParameterIsNotJsonStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseUtilsTest {

    @Test
    void parseJsonToStudentDirect_Success() throws ParameterIsNotJsonStringException {
        String sampleString = "{'firstName':'Huseyin','lastName':'Ergin','birthYear':1986}";
        var resultingPerson = ParseUtils.parseJsonToStudentDirect(sampleString);
        assertEquals("Huseyin", resultingPerson.getFirstName());
        assertEquals("Ergin", resultingPerson.getLastName());
        assertEquals(1986, resultingPerson.getBirthYear());
    }

    @Test
    void parseJsonToStudentDirect_SuccessWithDifferentKeyValues() throws ParameterIsNotJsonStringException {
        String sampleString = "{'first-name':'Huseyin','last-name':'Ergin','year':1986}";
        var resultingPerson = ParseUtils.parseJsonToStudentDirect(sampleString);
        assertEquals("Huseyin", resultingPerson.getFirstName());
        assertEquals("Ergin", resultingPerson.getLastName());
        assertEquals(1986, resultingPerson.getBirthYear());
    }

    @Test
    void parseJsonToStudentDirect_NotJsonString() {
        String sampleString = "__{'firstName':'Huseyin','lastName':'Ergin','birthYear':1986}";
        assertThrows(ParameterIsNotJsonStringException.class, () -> {
            var resultingPerson = ParseUtils.parseJsonToStudentDirect(sampleString);
        });
    }

    @Test
    void parseJsonToStudentManual_Success() throws ParameterIsNotJsonStringException {
        String sampleString = "{'firstName':'Huseyin','lastName':'Ergin','birthYear':1986}";
        var resultingPerson = ParseUtils.parseJsonToStudentDirect(sampleString);
        assertEquals("Huseyin", resultingPerson.getFirstName());
        assertEquals("Ergin", resultingPerson.getLastName());
        assertEquals(1986, resultingPerson.getBirthYear());
    }
}