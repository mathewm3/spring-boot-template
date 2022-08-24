package com.matt.xslt.soaptransform.rest;

import com.matt.util.TemplateLoaderUtility;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestAPI {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to my first spring boot";
    }

    @GetMapping(path = "/soaprequest",
    produces = "application/xml")
    public String soapRequest() throws IOException, TemplateException {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("USER_NAME", "Matt");
        input.put("PASSWORD", "pass123");
        Template template = TemplateLoaderUtility.getTemplate("login/login.ftl");
        StringWriter sw = new StringWriter();
        template.process(input, sw);
//        String response = HttpClientUtils.postData(atsUrl, CommonUtils.getDefaultHeaders(), sw.toString());
        return sw.toString();
    }


}
