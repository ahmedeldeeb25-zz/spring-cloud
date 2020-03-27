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
                sh "mvn -f ./main clean package"

                echo "start of build stage for gateway Microservice"
                sh "mvn -f ./gateway clean package"
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
                sh "docker-compose up"
            }
        }
    }
}
