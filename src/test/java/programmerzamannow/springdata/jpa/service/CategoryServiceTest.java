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
        // jika transaction ketemu dengan exception, maka proses didalam transactional akan dibatalkan
        // misalnya insert data ini akan dibatalkan
        assertThrows(RuntimeException.class, () -> {
            categoryService.create();
        });
    }

    @Test
    void failed() {
        // transactional tidak akan berjalan, karena dipanggil dalam object yang sama
        // Inilah cara kerja transactional, karena di AOP, maka harus dipanggil dari luar object
        assertThrows(RuntimeException.class, () -> {
            categoryService.test();
        });
    }

    @Test
    void programmatic() {
        // otomatis rollback, karena ketemu error
        // INI CARA MANUAL menggunakan transactionOperations
        assertThrows(RuntimeException.class, () -> {
            categoryService.createCategories();
        });
    }

}