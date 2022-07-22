## Story Wall


A retailer offers a rewards program to its customers awarding points based on each recorded purchase
as follows:
For every dollar spent over $50 on the transaction, the customer receives one point.
In addition, for every dollar spent over $100, the customer receives another point.

Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points
## Customer table


| Id   | Name  |
|------|-------|
| 1001 | Mayur |
| 1002 | Mack  |
| 1003 | Jack  |
| 1004 | Rose  |

## Transactions table


| Id  | Amount | Customer Id | Transaction Date    |
|-----|--------|-------------|---------------------|
| 001 | 15     | 1001        | 2022-05-20 10:30:25 |
| 002 | 60     | 1001        | 2022-05-21 10:30:25                    |
| 003 | 105    | 1001        | 2022-05-22 10:30:25                    |
| 004 | 5      | 1001        | 2022-06-20 10:30:25                    |
| 005 | 55     | 1001        | 2022-06-25 10:30:25                    |
| 006 | 70     | 1001        | 2022-06-26 10:30:25                    |
| 007 | 90     | 1001        | 2022-06-29 10:30:25                    |
| 008 | 10     | 1002        | 2022-05-21 10:30:2                    |
| 009 | 45     | 1002        | 2022-05-22 10:30:25                    |
| 010 | 40     | 1002        | 2022-05-23 10:30:25                    |
| 011 | 30     | 1002        | 2022-05-24 10:30:25                    |
| 012 | 100    | 1003        | 2022-06-25 10:30:25                    |
| 013 | 50     | 1003        | 2022-06-27 10:30:25                    |
| 014 | 150    | 1004        | 2022-07-20 10:30:25                    |

These values are used in the code and in the following examples too.

## Calculated Reward Point(output)



| Name  | Points |
|-------|--------|
| Mayur | 135    |
| Mack  | 0      |
| Jack  | 50     |
| Rose  | 150    |

## Requirements

The project requires [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or
higher.

The project makes use of Gradle and uses
the [Gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html), which means you don't need Gradle
installed.

## Useful Gradle commands

The project makes use of Gradle and uses the Gradle wrapper to help you out carrying some common tasks such as building
the project or running it.

### List all Gradle tasks

List all the tasks that Gradle can do, such as `build` and `test`.

```console
$ ./gradlew tasks
```

### Build the project

Compiles the project, runs the test and then creates an executable JAR file

```console
$ ./gradlew build
```

Run the application using Java and the executable JAR file produced by the Gradle `build` task. The application will be
listening to port `8080`.

```console
$ java -jar build/libs/reward-program.jar
```

### Run the tests

There are two types of tests, the unit tests and the functional tests. These can be executed as follows.

- Run unit tests only

  ```console
  $ ./gradlew test
  ```

- Run functional tests only

  ```console
  $ ./gradlew functionalTest
  ```

- Run both unit and functional tests

  ```console
  $ ./gradlew check
  ```

### Run the application

Run the application which will be listening on port `8080`.

```console
$ ./gradlew bootRun
```

## API

Below is a list of API endpoints with their respective input and output. Please note that the application needs to be
running for the following endpoints to work. For more information about how to run the application, please refer
to [run the application](#run-the-application) section above.

### Health Check

Endpoint

```text
GET /reward-point/health-check
```

Example of body

```json
Service is Up
```

### Get Reward Points

Endpoint

```text
GET /reward-point/fetch
```

Parameters

| Parameter | Description                                        |
|-----------|----------------------------------------------------|
| `month`   | optional query parameter, by default it is 3 month |

Retrieving readings using CURL

```console
$ curl "http://localhost:8080/reward-point/fetch"
```

Example output

```json
[
  {
    "name": "Rose",
    "rewardPoints": 150
  },
  {
    "name": "Jack",
    "rewardPoints": 50
  },
  {
    "name": "Mack",
    "rewardPoints": 0
  },
  {
    "name": "Mayur",
    "rewardPoints": 135
  }
]
```

