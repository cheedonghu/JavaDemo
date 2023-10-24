package usage.advanced.serializable;

import model.advanced.serializable.ClassWithSerializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author: east
 * @date: 2023/10/24
 */

public class SerializableUsage {
    /**
     * 序列化相关操作 todo 未完成
     */
    public void testSerializable() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("ClassWithSerializable.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            ClassWithSerializable classWithSerializable = new ClassWithSerializable("name", "age");
            objectOutputStream.writeObject(classWithSerializable);
            System.out.println("write done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SerializableUsage serializableUsage = new SerializableUsage();
        serializableUsage.testSerializable();
    }
}
