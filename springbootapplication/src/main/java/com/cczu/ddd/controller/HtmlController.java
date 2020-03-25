package com.cczu.ddd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ddd
 * @create 2020-03-19    19:03
 **/
@Controller
public class HtmlController {
    @RequestMapping("/lyear_main")
    public String lyear_main(){
        return "lyear_main";
    }
    @RequestMapping("/lyear_forms_elements")
    public String lyear_forms_elements(){
        return "lyear_forms_elements";
    }
    @RequestMapping("/lyear_js_datepicker")
    public String lyear_js_datepicker(){
        return "lyear_js_datepicker";
    }
    @RequestMapping("/lyear_pages_doc")
    public String lyear_pages_doc(){
        return "lyear_pages_doc";
    }
    @RequestMapping("/lyear_ui_buttons")
    public String lyear_ui_buttons(){
        return "lyear_ui_buttons";
    }
}
