import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.testng.Assert;

public class ReadJsonFile {

	public static void main(String[] args) {
		try {
			
			String pathseparator = File.separator;
	        String fileName = System.getProperty("user.dir") + pathseparator + "src" + pathseparator + "test"
	                + pathseparator + "resources" + pathseparator +"course.json";
			Object obj=new JSONParser().parse(new FileReader(fileName));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray ja = (JSONArray) jsonObject.get("player");

			int count = 0;

			System.out.println();
			int size = ja.size();
			for (int i = 0; i < size; i++) {
				JSONObject jsonObject1 = (JSONObject) ja.get(i);
				System.out.println(jsonObject1.get("country"));
				String countryName = (String) jsonObject1.get("country");
				if (!(countryName.equalsIgnoreCase("India"))) {
					count++;
				}

			}

			// checking whether team has only 4 foreign players
			Assert.assertEquals(count, 4,"team should have only 4 foreign players");
			int rolesCount=0;
			for (int i = 0; i < size; i++) {
				JSONObject jsonObject1 = (JSONObject) ja.get(i);
				System.out.println(jsonObject1.get("country"));
				String roleName = (String) jsonObject1.get("role");
				if (roleName.equalsIgnoreCase("wicket-keeper")) {
					rolesCount++;
				}

			}
			
			if(rolesCount<1) {
				Assert.assertTrue(false,"0 wicket keeper is there in team");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
