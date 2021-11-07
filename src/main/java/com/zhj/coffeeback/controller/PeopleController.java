package com.zhj.coffeeback.controller;

import com.zhj.coffeeback.entity.People;
import com.zhj.coffeeback.service.MailService;
import com.zhj.coffeeback.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/api/People/")
public class PeopleController
{
    @Autowired
    PeopleService peopleService;
    @Autowired
    MailService mailService;

    @RequestMapping(value = "ExistPeople/{idstr:\\d+}", method = RequestMethod.POST)
    public boolean ExistPeople(@PathVariable String idstr)
    {
        return peopleService.ExistPeople(Integer.parseInt(idstr));
    }

    @RequestMapping(value = "JudgePassword", method = RequestMethod.POST)
    public int JudgePassword(@RequestBody People people)
    {//密码相同返回ID
        String peoplerightpassword = peopleService.getPasswordByName(people.getName());
        if (peoplerightpassword != null && peoplerightpassword.equals(people.getPassword()))
        {
            return peopleService.getIdByName(people.getName());
        }
        else
        {
            return 0;
        }
    }

    @RequestMapping(value = "AddPeople", method = RequestMethod.POST)
    public int AddPeople(@RequestBody People people)
    {
        String peoplename = people.getName();
        if (!peopleService.SameName(peoplename))
        {
            peopleService.addPeople(people);

            //为新人新建数据表
            people.setId(peopleService.getIdByName(peoplename));
            peopleService.addPeoplecaffeinelist(people);
            peopleService.addnewState(people.getId(), new Date());
            return peopleService.getnewId();
        }
        else
        {
            return 0;
        }
    }

    @RequestMapping(value = "getNameById/{idstr:\\d+}", method = RequestMethod.POST)
    public String getNameById(@PathVariable String idstr)
    {
        return peopleService.getNameById(Integer.parseInt(idstr));
    }

    @RequestMapping(value = "updatePasswordById", method = RequestMethod.POST)
    public void updatePasswordById(@RequestParam("id") int id,
                                   @RequestParam("password") String password)
    {
        peopleService.updatePasswordById(id, password);
    }

    @RequestMapping(value = "updateNameById", method = RequestMethod.POST)
    public Boolean updateNameById(@RequestParam("id") int id,
                                  @RequestParam("name") String name)
    {
        if (!peopleService.SameName(name))
        {
            peopleService.updateNameById(id, name);
            return true;
        }
        else
        {
            return false;
        }
    }

    @RequestMapping(value = "deletePeopleById", method = RequestMethod.POST)
    public void deletePeopleById(@RequestParam("id") int id)
    {
        peopleService.deletePeopleById(id);
    }

    @RequestMapping(value = "SentPasswordMail", method = RequestMethod.POST)
    public Boolean SentPassword(@RequestParam("username") String name)
    {
        if (peopleService.ExistPeopleByName(name))
        {
            int user_id = peopleService.getIdByName(name);
            String to = peopleService.GetEmailById(user_id);
            String password = peopleService.GetPasswordById(user_id);
            mailService.SendTextMail(to, "您请求找回的密码", "您的密码为：" + password);
            return true;
        }
        else
        {
            return false;
        }
    }
}
