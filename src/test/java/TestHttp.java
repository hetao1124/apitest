import com.api.http.HttpBuilder;
import com.api.http.HttpConstants;
import com.api.http.HttpRes;
import com.api.http.HttpSampler;

public class TestHttp {

    public static void main(String[] args) {

        HttpRes res1 = new HttpBuilder()
                .name("第一个请求")
                .url("https://www.baidu2.com")
                .get();

        if (res1.getError() != null) {
            System.out.println(res1.getError());
        } else {
            System.out.println(res1.getMessage());
        }

    }
}
