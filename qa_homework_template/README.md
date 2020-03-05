# QA homework project template

## Description

This simple project template is provided so the candidate doesn't have to spend time on setting up whole project structure

## Importing project template

First of all - IDE should be installed. IntelliJ IDEA is being used for the following example. Then:

- File -->
- Open -->
- Choose the build.gradle file from (extracted/unzipped) project template -->
- use the default settings in "Import Project from Gradle" window
(make sure that "Use default gradle wrapper" is checked) -->
- OK

Other IDEs can be used as well, importing steps should be quite similar.

## Building the project

Open the command line and navigate to the  project template folder.

    gradlew test

This command will compile whole project and run the tests (1 test is provided as an example).
