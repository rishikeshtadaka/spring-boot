package com.ecommerce.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class TestController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("localization")
    public String localization(){
        Locale local= LocaleContextHolder.getLocale();
        return this.messageSource.getMessage("hello.world",null,"Default Message",local);
    }

    @Autowired
    private DatabaseConfiguration databaseConfiguration;
    @RequestMapping("db-configurations")
    public DatabaseConfiguration getDbConfigurations(){
        return databaseConfiguration;
    }


}
