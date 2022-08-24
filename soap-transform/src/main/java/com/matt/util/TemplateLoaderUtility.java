package com.matt.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class TemplateLoaderUtility {
    private static Configuration cfg = null;
    static {
        Version version = new Version(2, 3, 20);
        cfg = new Configuration(version);
        // Where do we load the templates from:
//        https://freemarker.apache.org/docs/pgui_config_templateloading.html
        cfg.setClassForTemplateLoading(TemplateLoaderUtility.class, "/templates");

//        TemplateLoader ftl1 = null;
//        TemplateLoader ftl2 = null;
//        try {
//            ftl1 = new FileTemplateLoader(new File("/tmp/templates"));
//            ftl2 = new FileTemplateLoader(new File("/usr/data/templates"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        TemplateLoader ctl = new ClassTemplateLoader(TemplateLoaderUtility.class, "/com/example/templates");
//        MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[][] { ftl1, ftl2, ctl });
//        cfg.setTemplateLoader(mtl);

        // Some other recommended settings:
//        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    }

    public static Template getTemplate(String templateName) throws IOException {
        return cfg.getTemplate(templateName);
    }
}
