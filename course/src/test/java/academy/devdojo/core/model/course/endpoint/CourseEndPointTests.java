package academy.devdojo.core.model.course.endpoint;

import academy.devdojo.core.model.Course;
import academy.devdojo.core.model.course.CourseApplicationTests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rafson.Rafson;
import com.rafson.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CourseEndPointTests extends CourseApplicationTests {


    @Test
    public void findAllSuccess() throws Exception {

         Response response = new Rafson().get(baseURi + port + "/v1/admin/course");

        Course course1 = new Course();
        course1.setId(1L);
        course1.setTitle("curse springboot devdojo");

        Course course2 = new Course();
        course2.setId(2L);
        course2.setTitle("curso springboot e ionic educando web");

        List<Course> listaEsperada = new ArrayList<>();
        listaEsperada.add(course1);
        listaEsperada.add(course2);



        JSONObject obj = new JSONObject(response.getBody());
        JSONArray resultsArr = obj.getJSONArray("content");
        String content = resultsArr.toString();

        Type collectionType = new TypeToken<List<Course>>() {
        }.getType();
        List<Course> listaAtual = new Gson().fromJson(content, collectionType);


       assertEquals(listaEsperada,listaAtual);

    }
}
