# Notty

# Requirements
- Docker

# Install
1. `git clone https://github.com/rolymeck/notty.git`
2. `bash start.sh`

***

# Usage
`java -jar game.jar`
***

# Description
5 микросервисов  
1 - Eureka (все ждут пока она не запуститься и не начнет слушать 8761 порт)  
2 - Gateway (точка входа, маршрутизация)  
3, 4, 5 -  REST end points  

Gateway принимает запросы на 80 порту
Для отправки уведомления необходимо отправить POST запрос с JSON body

**URL**
- /notification/email
- /notification/push
- /notification/sms

JSON Scheme:  
```
{
    "recipient": "Alik",
    "text": "Alaverdi"
}
```
Если все прошло успешно end point напишет в консоль всю необходимую информацю и вернет в ответе строку об успешной отправке