package hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * object�����е� public boolean equals(Object obj)�������κηǿ�����ֵ x �� y�����ҽ��� x �� y ����ͬһ������ʱ���˷����ŷ��� true��
 * ע�⣺���˷�������дʱ��ͨ���б�Ҫ��д hashCode ��������ά�� hashCode �����ĳ���Э������Э��������ȶ�����������ȵĹ�ϣ�롣���£�
 * (1)��obj1.equals(obj2)Ϊtrueʱ��obj1.hashCode() == obj2.hashCode()����Ϊtrue
 * (2)��obj1.hashCode() == obj2.hashCode()Ϊfalseʱ��obj1.equals(obj2)����Ϊfalse
 * �������дequals����ô�ȽϵĽ��Ƕ���������Ƿ�ָ��ͬһ���ڴ��ַ����д֮��Ŀ����Ϊ�˱Ƚ����������valueֵ�Ƿ���ȡ��ر�ָ������equals�Ƚϰ˴��װ����
 * ����int��float�ȣ���String�ࣨ��Ϊ��������д��equals��hashcode����������ʱ��Ĭ�ϱȽϵ���ֵ���ڱȽ������Զ������ʱ���ǱȽϵ����õ�ַ
 *
 * @author elon
 */
public class HashcodeTest {

    public static void main(String[] args) {
        Map<Name, User> map = new HashMap<>();
        Name name1 = new Name("123456");
        Name name2 = new Name("123456");
        Name name3 = new Name("1234567");
        User user1 = new User();
        user1.setName("xiaoming");
        user1.setSex(1);
        User user2 = new User();
        user2.setName("xiaohong");
        user2.setSex(0);
        map.put(name1, user1);
        map.put(name3, user2);
        System.out.println(map.size());
    }


}


