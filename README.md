# Grails Deep Dive 

This Grails application is the workshop project for the September 2021 Grails Deep Dive class. 

It exposes a REST API (`/api`), as well as a simple UI for subscribing for an email newsletter (`/newsletter/subscribe`) and a dashboard for authenticated users (`/newsletter/dashboard`)

User login is `admin/admin`

To start RabbitMQ broker/management dashboard (username/password: guest/guest)
```
docker run --rm -it \
        -p 5672:5672 \
        -p 15672:15672 \
        rabbitmq:3.8.12-management

```

## Useful links

- [Workshop Slides](slides.pdf)
- Grails Documentation: https://docs.grails.org/latest/
- Grails Guides: https://guides.grails.org/#/index
- Official Grails Samples: https://github.com/grails-samples
- GORM: https://gorm.grails.org/
- Grails Testing: https://testing.grails.org
- Spring Security Plugin: https://grails-plugins.github.io/grails-spring-security-core/latest/


