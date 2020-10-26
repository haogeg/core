package cn.net.rainier.openApi.controller;

import cn.net.rainier.global.config.ServerConfig;
import cn.net.rainier.global.entity.ResponseEntity;
import cn.net.rainier.global.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


/**
 * @program: remote-lab
 *
 * @description: 远程控制端口
 *
 * @author: jinhao
 *
 * @create: 2020-09-15 17:26
 **/

@RestController
@RequestMapping("/remoteApi/")
@RefreshScope
public class RemoteApiController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @CrossOrigin(origins = "*",maxAge = -1)
    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public ResponseEntity chatAesKey(@RequestParam(value= "userName", required = false) String userName,@RequestParam(value= "password", required = false) String password) {

        String host = ServerConfig.getUrl();

        return new ResponseEntity("欢迎"+userName+"登录,"+"当前ip地址为"+host);
    }

}
