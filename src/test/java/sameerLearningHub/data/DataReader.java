package sameerLearningHub.data;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List<HashMap<String, String>> getJsonDataToMap() throws Exception {
		// Read File to String
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\sameerLearningHub\\data\\data.json";
		String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
		// String jsonString = FileUtils.readFileToString(new File()); => Deprecated
		// Method

		// String to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonString,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
