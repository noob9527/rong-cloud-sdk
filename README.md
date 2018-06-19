# rong cloud sdk

### installation
```
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile("com.github.noob9527:rong-cloud-sdk:master-SNAPSHOT")
    // ...
}
```
### getting started
if you are using spring boot, related service are auto configured, otherwise you have to create them on your own

### configuration
| key | required | default |
| - | - | - |
| rong-cloud.app-key                    | true ||
| rong-cloud.app-secret                 | true ||
| rong-cloud.api-url                    | true | http://api.cn.ronghub.com |
| rong-cloud.log-level                  | true | NONE |

