package edu.sit.bookshop.service;

import edu.sit.bookshop.entity.User;
import edu.sit.bookshop.entity.WxUser;
import edu.sit.bookshop.repository.WxUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class HelperService {
    @Autowired
    WxUserRepository wxUserRepository;


    public Integer saveWxUser(WxUser wu)
    {
        WxUser wxUser = wxUserRepository.findByOpenid(wu.getOpenid());
        if(wxUser==null)
        {
            wu=wxUserRepository.save(wu);
            return 0;
        }
        else
        {
            if(wxUser.getUser()==null)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
    }
}
