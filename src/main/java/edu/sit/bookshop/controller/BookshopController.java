package edu.sit.bookshop.controller;

import com.alibaba.fastjson.JSONObject;

import edu.sit.bookshop.entity.Book;
import edu.sit.bookshop.entity.User;
import edu.sit.bookshop.entity.WxUser;
import edu.sit.bookshop.service.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookshopController {
    @Autowired
    HelperService helperService;
    @Value("${AppUtil.secret}")
    private String secret;
    @Value("${AppUtil.appId}")
    private String appId;
    @Value("${AppUtil.wxLoginUrl}")
    private String wxLoginUrl;

//    @RequestMapping(value = "/test",method = RequestMethod.POST)
//    public WxUser testcontrol(@RequestBody WxUser wxUsser)//JSONObject jsonObject
//    {
//        System.out.println(wxUsser.toString());
//        WxUser wxUser=new WxUser();
//        wxUser.setNickname("nick");
//        wxUser.setOpenid("open");
//        return wxUser;
//    }
    @RequestMapping("/toLogin")
    public Map<String, Object> doLogin(@RequestBody JSONObject jsonParam){
        //resp.setHeader("Access-Control-Allow-Origin", "*");
        //resp.setContentType("text/html;charset=UTF-8");
        System.out.println(jsonParam.toString());

        String code = jsonParam.getString("code");
        String nickName = jsonParam.getString("name");
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("code:" + code + " nickName:" + nickName );

        String url = wxLoginUrl;
        String param = "?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        url+=param;
        System.out.println(url);

        Map<String, Object> result = new HashMap<>();
        int error = 0;
        Integer state=0;
        try {
            String  map=restTemplate.getForObject(url, String.class);
            System.out.println(map);
            JSONObject obj=JSONObject.parseObject(map);
            String openid = obj.getString("openid");
            String session_key = obj.getString("session_key");
            result.put("openid", openid);
            System.out.println("session_key:" + session_key);
            WxUser wu = new WxUser();
            wu.setOpenid(openid);
            wu.setNickname(nickName);
            state = helperService.saveWxUser(wu);
            result.put("state",state);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            error = -1;
        }
        result.put("state",state);
        result.put("code", error);
        return result;
    }

}
