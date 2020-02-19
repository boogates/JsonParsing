package utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import domain.Person;
import exceptions.ParameterIsNotJsonStringException;

public class ParseUtils {

    public static Person parseJsonToPersonDirect(String jsonString) throws ParameterIsNotJsonStringException {
        if(jsonString.startsWith("{")){
            String sampleString = jsonString;
            Gson gson = new Gson();
            Person person = gson.fromJson(sampleString, Person.class);
            return person;
        }
        else{
            throw new ParameterIsNotJsonStringException();
        }

    }

    public static Person parseJsonToPersonManual(String jsonString) {
        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(jsonString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        var firstName = rootObject.getAsJsonPrimitive("name").getAsString();
        var lastName = rootObject.getAsJsonPrimitive("last").getAsString();
        var year = rootObject.getAsJsonPrimitive("dob").getAsInt();
        return new Person(firstName, lastName, year);
    }

}
