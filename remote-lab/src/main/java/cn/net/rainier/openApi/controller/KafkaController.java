package cn.net.rainier.openApi.controller;

import cn.net.rainier.global.config.ServerConfig;
import cn.net.rainier.global.entity.ResponseEntity;
import cn.net.rainier.global.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


/**
 * @program:
 *
 * @description: kafka使用接口
 *
 * @author: jinhao
 *
 * @create: 2020-10-19 17:26
 **/

@RestController
@RequestMapping("/kafka/")
@RefreshScope
public class KafkaController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @CrossOrigin(origins = "*",maxAge = -1)
    @RequestMapping(value = "/send", method= RequestMethod.GET)
    public ResponseEntity kafkaSend(@RequestParam(value= "userName", required = false) String userName,@RequestParam(value= "password", required = false) String password) {

        String host = ServerConfig.getUrl();
        kafkaProducer.send("欢迎"+userName+"登录,"+"当前ip地址为"+host);

        return new ResponseEntity("生产者发送请求");
    }



}
