package com.seetaface2.init;

import com.cnsugar.ai.face.SeetafaceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

/**
 * @author Yaosh
 * @version 1.0
 * @commpany 星瑞国际
 * @date 2020/8/20 14:49
 * @return
 */
@Controller
@Order(2)
public class SeetaFaceInit implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(SeetaFaceInit.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("init seetaface ...");
        SeetafaceBuilder.build();
        logger.info("init seetaface success ...");
    }

}
