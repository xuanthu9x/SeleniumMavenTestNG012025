package bai10_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo_Annotations_Class2 {
    @BeforeClass
    public void beforeClass2() {
        System.out.println("Chạy trước tất cả các test trong class 2 này");
    }
    @AfterClass
    public void afterClass2() {
        System.out.println("Chạy sau tất cả các test trong class 2 này");
    }
    @Test
    public void testLogout(){
        System.out.println("Kiểm thử logout success");
    }
}
