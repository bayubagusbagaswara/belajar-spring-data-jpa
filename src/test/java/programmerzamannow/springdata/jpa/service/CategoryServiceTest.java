package programmerzamannow.springdata.jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void success() {
        // transactional berjalan sukses
        assertThrows(RuntimeException.class, () -> {
            categoryService.create();
        });
    }

    @Test
    void failed() {
        // transactional tidak akan berjalan, karena dipanggil dalam object yang sama
        assertThrows(RuntimeException.class, () -> {
            categoryService.test();
        });
    }

}