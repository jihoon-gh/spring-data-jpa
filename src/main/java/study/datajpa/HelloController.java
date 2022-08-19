package study.datajpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/files")
    public List<String> filesRead() throws FileNotFoundException, IOException {
        List<String> body = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("https://weato-newsletters.s3.ap-northeast-2.amazonaws.com/%ED%99%88%ED%8E%98%EC%9D%B4%EC%A7%80%EA%B8%B0%EC%82%AC_%EB%AA%A9%EC%9A%95%EC%8A%B5%EA%B4%80.html"));
        while(true){
            String line = br.readLine();
            if(line==null) break;
            else body.add(line);
        }
        return body;
    }
}
