package java8programs;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 *
 */
public class JunitUtils {

	/*Map<String, Object> hashmap;

	*//**
	 * @param obj
	 * @return
	 *//*
	public RTMap deserializeJAXBToRTMap(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule module = new SimpleModule("RTMapModule", new Version(1, 0, 0, null, null, null));
		module.addDeserializer(RTMap.class, new RTMapDeserializer());
		objectMapper.registerModule(module);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper.convertValue(obj, RTMap.class);

	}

	*//**
	 * @param obj
	 * @param mockObj
	 * @param field
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 *//*
	@SuppressWarnings("rawtypes")
	public void fieldMock(Object obj, Object mockObj, String field)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class c = obj.getClass();
		Field f = c.getDeclaredField(field);
		f.setAccessible(true);
		f.set(obj, mockObj);
	}

	*//**
	 * @param journey
	 * @param ducmName
	 * @return
	 * @throws IOException
	 *//*
	public DynamicUseCaseModel prepareStubbedDucm(String journey, String ducmName)
			throws IOException {
		FileSystemResourceLoader fsr = new FileSystemResourceLoader();
		DynamicUseCaseModel ducm = new DynamicUseCaseModel(journey);
		hashmap = new HashMap<>();
		String ducmPath = "/src/test/resources/" + ducmName + ".json";
		ObjectMapper mapper = new ObjectMapper();
		hashmap = mapper.readValue(fsr.getResource(ducmPath).getFile(), new TypeReference<Map<String, Object>>() {
		});
		RTMap data = new RTMap(deserializeJAXBToRTMap(hashmap));
		ducm.setData(data);
		return ducm;
	}

	*//**
	 * @param mapName
	 * @return
	 * @throws IOException
	 *//*
	public RTMap prepareRTMap(String mapName) throws IOException {
		FileSystemResourceLoader fsr = new FileSystemResourceLoader();
		hashmap = new HashMap<>();
		String ducmPath = "/src/test/resources/" + mapName + ".json";
		ObjectMapper mapper = new ObjectMapper();
		hashmap = mapper.readValue(fsr.getResource(ducmPath).getFile(), new TypeReference<Map<String, Object>>() {
		});
		return new RTMap(deserializeJAXBToRTMap(hashmap));

	}
*/
}
