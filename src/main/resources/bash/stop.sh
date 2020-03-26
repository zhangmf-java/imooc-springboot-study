#!/usr/bin/env bash
pid="ps -ef |grep imooc-springboot-study.jar | grep -v grep | awk'{print $2}'"

if[[ -z "${pid}"]]
then
  echo appliction is already stop
else
  echo kill ${pid}
  kill -9 ${pid}
fi