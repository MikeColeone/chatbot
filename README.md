# chatbot

## Introduce
### 项目架构
```java
zsxq_access_token=3BAAF6BC-6739-D355-4ADA-D12CBFCAB5DD_88C8C9B07BCB99FD; zsxqsessionid=b34baf1632666fceeb259b41c6d7de5b; abtest_env=product
```

### gpt接口相关
- ChatGPT：[https://chat.openai.com/chat](https://chat.openai.com/chat)
- ApiKeys：[https://beta.openai.com/account/api-keys](https://beta.openai.com/account/api-keys) - hsk-dproj-xoYwfzP3VmtmV5Q4wtuzEMgxEFcKDXeyoYycoMU14OFL6ztBoWJTmxccZN4wWsXKvYcBVHev-2PT3BlbkFJywlP6qcTXKhzHdKiafdaDq9c-lxSG5XIG3nOPMCM524pIfB4uMmCrTmhSpukZpnCg8k052tCwA
- json2entity：[https://www.sojson.com/json2entity.html](https://www.sojson.com/json2entity.html) - 用于对象转换
- 知识星球：[https://wx.zsxq.com/dweb2/index/group/28885518425541](https://wx.zsxq.com/dweb2/index/group/28885518425541)
- cookie获取: F12打开调试面板


## 部署
```java
vim /usr/lib/systemd/system/docker.service
在ExecStart=/usr/bin/dockerd-current 后面加上 -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock \
重新加载配置文件
systemctl daemon-reload
重启启动
systemctl restart docker
```

## 脚本

```java
docker run -e PARAMS=" --chatbot-api.groupId=你的星球ID --chatbot-api.openAiKey=自行申请 --chatbot-api.cookie=登录cookie信息" -p 8090:8090 --name chatbot-api -d chatbot-api:1.0
```

## Update
1. 搭建项目结构