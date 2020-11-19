package com.base.springbase.common.beanassembly.autowire.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * 或者也可以在 XML 文件中声明去哪里做扫描
 * <context:component-scan base-package="com.chenhj.autowiredbean" />
 */
@ComponentScan(basePackages = {"com.base.springbase.common.beanassembly.autowire.domain"})
public class AutowireConfig {
}
