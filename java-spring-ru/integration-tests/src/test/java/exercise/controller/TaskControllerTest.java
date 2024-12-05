package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
    @Test
    public void testShow() throws Exception {
        var faker = new Faker();
        var task = new Task();
        task.setTitle(faker.lorem().sentence(1));
        task.setDescription(faker.lorem().sentence(3));
        taskRepository.save(task);
        var request = get("/tasks/" + task.getId());
        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body.contains(task.getDescription())
                && body.contains(task.getTitle()));
    }

    @Test
    public void testCreate() throws Exception {
        var faker = new Faker();
        var task = new Task();
        task.setTitle(faker.lorem().sentence(1));
        task.setDescription(faker.lorem().sentence(3));
        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(task));

        var result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();

        assertThat(taskRepository.findByTitle(task.getTitle()).isPresent()
                && taskRepository.findById(task.getId()).isPresent()
                && taskRepository.findByTitle(task.getTitle()).get().equals(taskRepository.findById(task.getId()).get()));
    }

    @Test
    public void testDelete() throws Exception {
        var faker = new Faker();
        var task = new Task();
        task.setTitle(faker.lorem().sentence(1));
        task.setDescription(faker.lorem().sentence(3));
        taskRepository.save(task);
        var request = delete("/tasks/" + task.getId());
        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        assertThat(taskRepository.findAll().isEmpty());
    }

    @Test
    public void testUpdate() throws Exception {
        var task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .create();
        taskRepository.save(task);
        var newTask = new HashMap<>();
        newTask.put("title", "New Title");

        var request = put("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(newTask));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        task = taskRepository.findById(task.getId()).get();
        assertThat(task.getTitle()).isEqualTo(("New Title"));
    }

    // END
}
