package com.springboot.config.fastjson;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 *
 * @author  chengfan
 * @version 2018年6月27日
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		WebMvcConfigurer.super.configureMessageConverters(converters);
		//创建FastJson消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig config = new FastJsonConfig();
        //修改配置返回的过滤
        config.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue
        );
        converter.setFastJsonConfig(config);
        //将Fastjson添加到视图消息转换器列表中
        converters.add(converter);
	}
}
