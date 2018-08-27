## Automation Test for Web and API

### Highlights
* Chosen [Serenity](http://www.thucydides.info/docs/serenity/) framework, as it comes with inbuilt methods on top of selenium
* To automate [Selenium Webdriver](https://docs.seleniumhq.org/projects/webdriver/) binaries management in runtime am using [webdrivermanager](https://github.com/bonigarcia/webdrivermanager), an excellent library by [Boni García](https://github.com/bonigarcia)
* Designed the project to run Maven or Gradle, to be easily plugged with CI tools
* Reports - Serenity by default generated Rich HTML reports with screenshots
* Used Serenity Rest Assured for API Automation Tests
* Cross browser & platform


### How to run?
Clone or download the project and
Issue the below commands in project root directory

 ##### Gradle
```javascript
./gradlew test aggregate
```
By default it runs in Chrome browser, you can specify which browser to use as well
```javascript
./gradlew test aggregate -Dbrowser=firefox
```
`aggregate` in above command will generate Serenity HTML(index.html) report under `target/site/serenity`
>If you're on Windows replace `./gradlew` with `gradlew.bat`

Browsers added in this project are
* chrome
* firefox
* edge
* ie
* opera

##### Maven
```javascript
mvn clean verify
```
Or
```javascript
mvn clean verify -Dbrowser=firefox
```
