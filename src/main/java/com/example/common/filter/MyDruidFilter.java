package com.example.common.filter;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import lombok.extern.slf4j.Slf4j;


/**
 * @author wangzhanhui
 * @version 1.0
 * @date 2022/12/9 18:26
 * @desc
 */
@Slf4j
public class MyDruidFilter extends StatFilter {


    @Override
    protected void handleSlowSql(StatementProxy statement) {


        //耗时  毫秒
        long millis = statement.getLastExecuteTimeNano() / 1000000L;
        //sql参数
        String slowParameters = this.buildSlowParameters(statement);
        //sql语句
        String lastExecSql = statement.getLastExecuteSql();
        //推送告警
       //推送警告类
        long healthCheckSlowSqlMaxTime = 1;
        if (millis>=healthCheckSlowSqlMaxTime) {
            /*SlowSqlEvent.SlowSqlDto slowSqlDto = new SlowSqlEvent.SlowSqlDto();
            slowSqlDto.setSlowParameters(slowParameters);
            slowSqlDto.setCostTime(millis);
            slowSqlDto.setSlowSql(lastExecSql);
            //获取调用栈信息
            slowSqlDto.setStackTraceElements(Thread.currentThread().getStackTrace());*/
            log.warn("MyDruidFilter slow sql " + millis + " millis. " + lastExecSql + "" + slowParameters);
        }


        log.info("health sql " + millis + " millis. " + lastExecSql + "" + slowParameters);
    }
}
