package by.bury.universe.demo.service.impl;


import by.bury.universe.demo.dao.LordDao;
import by.bury.universe.demo.entity.Lord;
import by.bury.universe.demo.service.LordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@SpringBootTest

class LordServiceImplTest {

    @Mock
    private LordDao lordDao;

    @InjectMocks
    private LordService lordService = new LordServiceImpl();

    @Autowired
    private LordService lordService2;


    @BeforeEach
    void setMockOutput() {
        Lord lord = new Lord();
        lord.setId(1);
        lord.setName("Test1");
        lord.setAge(1);
        Lord lord2 = new Lord();
        lord2.setId(2);
        lord2.setName("Test2");
        lord2.setAge(2);
        List<Lord> lordList = new ArrayList<>();
        lordList.add(lord);
        lordList.add(lord2);
        when(lordDao.getTenYoungLords()).thenReturn(lordList);
        when(lordDao.getLordSlackers()).thenReturn(lordList);
    }

    @Test
    @DisplayName("Save lord")
    void saveLord() {
        Lord lord = new Lord();
        lord.setName("TestLord");
        lord.setAge(4000);
        lordService2.saveLord(lord);
        Lord newLord = lordService2.getLord(lord.getId());
        Assertions.assertEquals(lord, newLord);
        lordService2.deleteLord(lord.getId());
    }


    @Test
    @DisplayName("Get ten younger lords")
    void getTenYoungLords() {
        Lord lord1 = new Lord();
        lord1.setId(1);
        lord1.setName("Test1");
        lord1.setAge(1);
        Lord lord2 = new Lord();
        lord2.setId(2);
        lord2.setName("Test2");
        lord2.setAge(2);
        List<Lord> lordList = new ArrayList<>();
        lordList.add(lord1);
        lordList.add(lord2);
        Assertions.assertEquals(lordList, lordService.getTenYoungLords());

    }

    @Test
    @DisplayName("Get lord slackers")
    void getLordSlackers() {
        Lord lord1 = new Lord();
        lord1.setId(1);
        lord1.setName("Test1");
        lord1.setAge(1);
        Lord lord2 = new Lord();
        lord2.setId(2);
        lord2.setName("Test2");
        lord2.setAge(2);
        List<Lord> lordList = new ArrayList<>();
        lordList.add(lord1);
        lordList.add(lord2);
        Assertions.assertEquals(lordList, lordService.getLordSlackers());
    }
}