package com.chris.importer;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.chris.bean.Yellow", "com.chris.bean.Blue"};
    }
}
