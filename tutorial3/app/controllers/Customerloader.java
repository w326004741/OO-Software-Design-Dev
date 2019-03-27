package controllers;

import play.mvc.Controller;
import play.mvc.With;

import java.io.File;

/**
 * @author Weichen Wang
 * @date 2019/3/27 - 11:41 AM
 * @description: ${description}
 */

// extends Controller, now this class is Controller class
@With(Secure.class) // 保证访问服务器时，未登陆前，保证只显示/secure/login page。 无论输入任何其他的url(/admin.)
public class Customerloader extends Controller {

    // call loader.html page(view.Application folder)
    public static void loader() {
        render();
    }

    public static void uploadJSON(File jsonData) {
        try {
            Application.class.getResourceAsStream(jsonData.getPath());

            /** Add code for JSON processing */

            flash.success("File uploaded successfully and database updated");
        } catch (Exception e) {
            flash.error("Unknown exception");
            e.printStackTrace();
        }
        System.out.println("File Path: " + jsonData); // 输出上传文件的完整路径
        loader(); // call loader.html again
//        index(); // return index.html(回到index.html)
    }
}
