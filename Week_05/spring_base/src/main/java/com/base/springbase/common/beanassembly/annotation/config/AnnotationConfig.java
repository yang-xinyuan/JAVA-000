package com.base.springbase.common.beanassembly.annotation.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * 使用一个 AnnotationConfig 类去告诉 Spring IoC
 *
 * 不传任何参数：代表进行扫描，默认是扫描当前包的路径，扫描所有带有 @Component 注解
 * basePackages：它是由 base 和 package 两个单词组成的，而 package 还是用了复数，意味着它可以配置一个 Java 包的数组，Spring 会根据它的配置扫描对应的包和子包，将配置好的 Bean 装配进来
 * basePackageClasses：它由 base、package 和 class 三个单词组成，采用复数，意味着它可以配置多个类， Spring 会根据配置的类所在的包，为包和子包进行扫描装配对应配置的 Bean
 *
 * 对于 【basePackages】 和 【basePackageClasses】 的选择问题：
 * 【basePackages】 的可读性会更好一些，所以在项目中会优先选择使用它，但是在需要大量重构的工程中，尽量不要使用【basePackages】，
 * 因为很多时候重构修改包名需要反复地配置，而 IDE 不会给你任何的提示，而采用【basePackageClasses】会有错误提示。
 */
@ComponentScan(basePackageClasses = com.base.springbase.common.beanassembly.annotation.domain.AnnotationDomain.class)
public class AnnotationConfig {
}
