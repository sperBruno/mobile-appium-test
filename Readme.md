#Mobile

**Requeriments**

Make sure following requirements are met:

1. Gradle (download from here: https://gradle.org/releases/)
2. Java 8
3. Intellij idea
4. Git
5. Allure Report (download from here: https://bintray.com/qameta/generic/allure2/2.7.0)

Make sure Gradle, Java and Allure are added to your environment variable specifically to the PATH

***Configurations***

Open gradle.properties and fill the required variables

**Execution**

To execute feature files run following cmd command:
> gradle runFeatures


Run by tag, add tag to the args in the build.gradle file
> '--tags', '@Login_001'

> gradle runFeatures -Ptags="@Mobile_001" 

**Generate Allure Report**

To generate allure report run following command:

> allure generate --clean

Then open allure-report/index.html on a browser

OR

> allure serve