Logback example

<configuration scan="true">
    <property name="DEV_HOME" value="${user.dir}/log"/>
    <timestamp key="bySecond" datePattern="yyyyMMdd'T'HHmmss"/>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <Pattern>
                %d{yyyy-MM-dd HH:mm:ss} %highlight(%-5level) - %highlight( %msg%n)
            </Pattern>
        </layout>
    </appender>

    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${DEV_HOME}/timeBasedlogFile_${bySecond}.log</file>  <!-- z timestamp-->
        <append>true</append>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- daily rollover -->
            <fileNamePattern>${DEV_HOME}/timeBasedlogFile.%d{yyyy-MM-dd-HH-mm}.zip</fileNamePattern>
            <maxHistory>3</maxHistory>
            <totalSizeCap>30KB</totalSizeCap>
        </rollingPolicy>
        <encoder>
            <pattern>[%thread] %-5level %logger{35} - %msg%n</pattern>
        </encoder>
    </appender>

    <!--    Jesli raskomentowac wiersze 28-30(zeby pisal w log tylko poziom Info i wyszej dla klasy AutomationSiteNameTest),
            trzeba zakomentowac wiersz 34-->
    <!--    <logger name="AutomationSiteNameTest.class" level="info">-->
    <!--        <appender-ref ref="FILE"/>-->
    <!--    </logger>-->

    <root level="debug">
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="FILE"/>
    </root>
</configuration>
