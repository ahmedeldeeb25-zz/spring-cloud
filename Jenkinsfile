#!groovy

pipeline {
   agent any

    stages{
       /* stage('Pull Source') {
            steps {
                git url: 'https://github.com/ahmedeldeeb25/spring-cloud.git/', branch: 'master'
            }
        }*/
        stage("Build"){
            steps{
                echo "start of build stage for main Microservice"
                sh "mvn -f ./main clean package -DskipTests"

                echo "start of build stage for gateway Microservice"
                sh "npm --prefix ./gateway/src/main/webapp/ install"
                sh "mvn -f ./gateway clean package -DskipTests"

                sh "mvn -f ./registry clean package -DskipTests"
                sh "mvn -f ./user-uaa clean package -DskipTests"
            }
        }
        stage("Build Docker"){
            steps{
                echo "start of build Docker images stage"
                sh "docker-compose build"
            }
        }

        stage("Run Docker"){
            steps{
                sh "docker stop main_ms gateway_ms registry postgres"
                sh "docker-compose up"
            }
        }
    }
}
