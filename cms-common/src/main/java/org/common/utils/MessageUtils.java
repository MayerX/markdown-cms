package org.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageUtils {

    private static final Logger logger = LoggerFactory.getLogger(MessageUtils.class);
    private static final Map<String, String> messageCache = new ConcurrentHashMap<>(); // 用于缓存消息

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    /**
     * 获取指定消息，使用当前语言环境
     * 支持自动校验和日志记录
     * @param code 消息键
     * @return 对应的消息内容，如果找不到则返回默认消息
     */
    public static String getMessage(String code) {
        return getMessage(code, null, null, "No message found for code: " + code);
    }

    /**
     * 获取指定消息，使用当前语言环境
     * 支持自动校验和日志记录
     * @param code 消息键
     * @param args 消息参数
     * @return 对应的消息内容
     */
    public static String getMessage(String code, Object[] args) {
        return getMessage(code, args, null, "No message found for code: " + code);
    }

    /**
     * 根据指定的Locale获取消息
     * 支持自动校验和日志记录
     * @param code 消息键
     * @param locale 指定的语言环境
     * @return 对应的消息内容
     */
    public static String getMessage(String code, Locale locale) {
        return getMessage(code, null, locale, "No message found for code: " + code);
    }

    /**
     * 获取带参数的消息，指定Locale
     * 自动校验code值并处理
     * @param code 消息键
     * @param args 消息参数
     * @param locale 指定的语言环境
     * @param defaultMessage 默认消息（如果code不存在时返回的消息）
     * @return 对应的消息内容或默认消息
     */
    public static String getMessage(String code, Object[] args, Locale locale, String defaultMessage) {
        locale = (locale != null) ? locale : LocaleContextHolder.getLocale();
        String cacheKey = buildCacheKey(code, locale);

        // 使用缓存，并且通过提取的通用方法处理消息获取和默认消息逻辑
        Locale finalLocale = locale;
        return messageCache.computeIfAbsent(cacheKey, key -> fetchMessageWithDefault(code, args, finalLocale, defaultMessage));
    }

    /**
     * 根据代码、参数、语言环境获取消息，如果找不到则返回默认消息
     * @param code 消息代码，用于标识需要获取的消息
     * @param args 消息参数，用于格式化消息
     * @param locale 语言环境，用于指定消息的语言和区域设置
     * @param defaultMessage 默认消息，当未找到特定消息时返回
     * @return 返回找到的消息或默认消息
     */
    private static String fetchMessageWithDefault(String code, Object[] args, Locale locale, String defaultMessage) {
        try {
            if (!isMessageCodeExist(code, locale)) {
                logger.warn("No message found for code: {} and locale: {}", code, locale);
                return defaultMessage;
            }

            String message = messageSource.getMessage(code, args, locale);
            logger.info("Successfully fetched message for code: {} with locale: {}", code, locale);
            return message;
        } catch (NoSuchMessageException e) {
            logger.warn("No message found for code: {} and locale: {}", code, locale);
            return defaultMessage;
        }
    }

    /**
     * 检查指定的code是否存在于指定Locale的properties文件中
     * @param code 消息键
     * @param locale 指定的语言环境
     * @return true 如果code存在，否则false
     */
    private static boolean isMessageCodeExist(String code, Locale locale) {
        try {
            messageSource.getMessage(code, null, locale);
            return true;  // 如果成功获取消息，则表示code存在
        } catch (NoSuchMessageException e) {
            return false; // 如果抛出NoSuchMessageException，表示code不存在
        }
    }

    /**
     * 构建缓存的key
     * @param code 消息code
     * @param locale 语言环境
     * @return 构建好的缓存key
     */
    private static String buildCacheKey(String code, Locale locale) {
        return code + "_" + locale.toString();
    }
}